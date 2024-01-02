package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl {

    @Autowired
    private EmployeeRepo employeeRepoImpl;

    public Employee signUp(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public Optional<Employee> findById(int empId){
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> findAll(){
        return employeeRepoImpl.findAll();
    }

    public boolean signIn(String empEmailId,String empPassword){
        boolean flag = false;
        for (Employee employee : findAll()){
            if (employee.getEmpMailId().equals(empEmailId) && employee.getEmpPassWord().equals(empPassword)){
                flag = true;
            }


        }
        return flag;
    }

    public  Employee update(Employee employee){
        return employeeRepoImpl.save(employee);
    }
    public void deleteById(int empId){
        employeeRepoImpl.deleteById(empId);
    }
}
