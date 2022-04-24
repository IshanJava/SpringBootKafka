package com.employee.employeemgmtconsumer.service;

import com.employee.employeemgmtconsumer.repository.EmployeeRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.employee.employeemgmtconsumer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmpKafkaService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @KafkaListener(topics = "${topic.value}", groupId = "grpid")
    public void saveEmployee(String empMessage){
        try {
            employeeRepo.save(new ObjectMapper().readValue(empMessage, Employee.class));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
