package com.raiko.project.myCafe.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER_ROLE, ADMIN_ROLE;

    @Override
    public String getAuthority() {
        return name();
    }
}
