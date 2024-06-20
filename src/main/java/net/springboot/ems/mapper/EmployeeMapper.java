package net.springboot.ems.mapper;

import net.springboot.ems.dto.EmployeeDTO;
import net.springboot.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapEmpToDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPword(),
                employee.getRole()
        );
    }

    public static Employee mapDTOtoEmp(EmployeeDTO empDTO){
        return new Employee(
                empDTO.getId(),
                empDTO.getFirstName(),
                empDTO.getLastName(),
                empDTO.getEmail(),
                empDTO.getPword(),
                empDTO.getRole()

        );
    }
}
