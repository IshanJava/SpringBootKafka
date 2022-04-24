package com.employee.employeemgmtconsumer.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue()
    private int empId;
    private String firstName;
    private String lastName;
    private String email;
    private int departmentId;
}
