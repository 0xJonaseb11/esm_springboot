package net.springboot.ems.controller;

import lombok.AllArgsConstructor;
import net.springboot.ems.apisecurityconfig.JwtService;
import net.springboot.ems.dto.EmployeeDTO;
import net.springboot.ems.services.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final JwtService jwtService;
    @PostMapping("/add")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDto){
        String jwtToken = employeeService.createEmployee(employeeDto);
        return ResponseEntity.status(201).body(jwtToken);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDTO emp = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(emp);
    }

    @GetMapping("/get")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployees();

        return ResponseEntity.ok(employeeDTOS);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeDTO updateEmpDto){
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, updateEmpDto);
        return ResponseEntity.ok(updatedEmployee);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee was deleted successfully");
    }

}
