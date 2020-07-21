package com.Sandar.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {
    private Long merchantAccountId;
    private String displayName;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long merchantAccountId, String displayName) {
        super(username, password, authorities);
        this.merchantAccountId = merchantAccountId;
        this.displayName = displayName;
    }

    public Long getMerchantAccountId() {
        return merchantAccountId;
    }

    public String getDisplayName() {
        return displayName;
    }
}