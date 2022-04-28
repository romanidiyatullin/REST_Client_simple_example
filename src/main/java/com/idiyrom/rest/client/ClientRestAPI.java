package com.idiyrom.rest.client;

import com.idiyrom.rest.client.configuration.SpringConfiguration;
import com.idiyrom.rest.client.connectors.SimpleConnector;
import com.idiyrom.rest.client.entities.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientRestAPI
{
    public static void main( String[] args ) throws Exception{
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        SimpleConnector simpleConnector =
                context.getBean("simpleConnector", SimpleConnector.class);

        System.out.println(simpleConnector.getAllEmployees());

        System.out.println(simpleConnector.getEmployeeById(2));

        Employee employee = new Employee();
        employee.setDepartment("Sales");
        employee.setName("Sergey");
        employee.setLastName("Bezrukov");
        employee.setSalary(1111);

        System.out.println(simpleConnector.addEmployee(employee));
        System.out.println(simpleConnector.deleteEmployeeById(26));
    }
}
