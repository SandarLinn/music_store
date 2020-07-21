package com.Sandar.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Sandar.demo.models.UserAccount;
import com.Sandar.demo.repositories.UserAccountRepository;
import com.Sandar.demo.security.CustomUserDetails;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        UserAccount userAccount = userAccountRepository.findByEmail(username);

        System.out.println("load User By User Name : " + username);

        if (userAccount == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userAccount.getRole()));

        //return new org.springframework.security.core.userdetails.User(userAccount.email, userAccount.password, grantedAuthorities);
        return new CustomUserDetails(userAccount.getEmail(), userAccount.getPassword(), grantedAuthorities, null, userAccount.getDisplayName());
    }
}
