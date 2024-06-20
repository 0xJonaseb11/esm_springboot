package net.springboot.ems.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    USER("USER"),
    ADMIN("ADMIN");
    private final String roleName;


}
