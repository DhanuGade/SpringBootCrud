package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;


    @Size(min = 2, message = "Employee Name Should Be Two Char...")
    private String empName;

    private String empAddress;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date empDob;

    private double empSalary;

    @Range(min = 1000000000,max = 9999999999L,message = "Contact Number Must Be 10 Digit..")
    private long empContactNumber;


    @Email(message = "Email Id Must Be Valid...")
    private String empMailId;


    @Size(min = 4, message = "Password Should Be Four Char..")
    private String empPassWord;
}
