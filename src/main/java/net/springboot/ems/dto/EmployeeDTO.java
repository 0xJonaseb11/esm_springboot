package net.springboot.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.springboot.ems.entity.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private  String firstName;
    private  String lastName;
    private String email;
    private String pword;
    private Role role;
}
