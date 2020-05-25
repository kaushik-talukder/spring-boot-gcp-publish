package com.ezycoding.sbgp.employee;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private Date dob;
}
