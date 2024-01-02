package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServicesImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServicesImpl employeeServices;

    @PostMapping("/signUp")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServices.signUp(employee), HttpStatus.CREATED);
    }

    @GetMapping("/signIn/{empEmailId}/{empPassword}")

    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, String empPassword) {
        return ResponseEntity.ok(employeeServices.signIn(empEmailId, empPassword));
    }

    @GetMapping("/finById/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServices.findById(empId));
    }

    @GetMapping("/findAll")

    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeServices.findAll());
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<String>deleteById(@RequestParam int empId){
        employeeServices.findById(empId);
        return ResponseEntity.ok("Id deleted SuccessFully");
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> update(@PathVariable int empId,@Valid @RequestBody Employee employee){
        Employee employee1 = employeeServices.findById(empId).orElseThrow(() -> new RecordNotFoundException("Employee Id Does Not Exist"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpId(employee.getEmpId());
        employee1.setEmpPassWord(employee.getEmpPassWord());
        employee1.setEmpDob(employee.getEmpDob());

        return new ResponseEntity<>(employeeServices.update(employee1),HttpStatus.CREATED);
    }
}
