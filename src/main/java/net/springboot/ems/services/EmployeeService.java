package net.springboot.ems.services;

import net.springboot.ems.dto.EmployeeDTO;

import java.util.List;

public  interface EmployeeService {
    String createEmployee(EmployeeDTO employeeDto);
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long id, EmployeeDTO updateEmpDto);

    public void deleteEmployee(Long id);
}
