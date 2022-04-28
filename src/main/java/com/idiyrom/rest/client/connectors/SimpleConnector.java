package com.idiyrom.rest.client.connectors;

import com.idiyrom.rest.client.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("simpleConnector")
public class SimpleConnector {

    private final String URL = "http://localhost:8080//rest2/api";

    @Autowired
    RestTemplate restTemplate;

    public List<Employee> getAllEmployees(){
        ResponseEntity<List<Employee>> response =
                restTemplate.exchange(URL+"/employees", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>(){});
        return response.getBody();
    }

    public Employee getEmployeeById(int id) {
        return restTemplate.getForObject(URL+"/employees/"+id,Employee.class);
    }

    public String addEmployee(Employee employee) {
        ResponseEntity<String> response =
                restTemplate.postForEntity(URL+"/employees/add",
                        employee,
                        String.class);
        return response.getBody();
    }

    public String deleteEmployeeById(int id) {

        try {
                Employee employee = restTemplate.getForObject(URL+"/employees/"+id, Employee.class);

                if(employee!=null) {
                    System.out.println("Following object with ID = " + id + " will be deleted: " + employee);
                    restTemplate.delete(URL+"/employees/delete/"+id, Employee.class);
                }
                else {
                    System.out.println("Object with given id = " + id + " is absent");
                }

        } catch (Exception e) {
                System.out.println("Attempt to delete object with id = " + id +
                                   " FAILED. See exception details below: " + e.getMessage());
                return "FAILURE";
        }
        return "SUCCESS";
    }


}
