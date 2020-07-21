package com.Sandar.demo;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.Sandar.demo.security.CustomUserDetails;

public class AdminBaseController {
    protected CustomUserDetails getSignedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object myUser = (auth != null) ? auth.getPrincipal() :  null;
        if(myUser instanceof CustomUserDetails) {
            return (CustomUserDetails) myUser;
        }
        return null;
    }

}