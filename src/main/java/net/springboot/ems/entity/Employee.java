package net.springboot.ems.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String pword;

    @Enumerated
    @Column(name = "role")
    private Role role;

//    public Employee(String firstName, String lastName, String email, String pword) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.pword = pword;
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return pword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
