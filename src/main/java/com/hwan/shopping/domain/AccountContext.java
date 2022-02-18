package com.hwan.shopping.domain;

import com.hwan.shopping.enums.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

@Getter
public class AccountContext extends User {

    private final Account account;

    public AccountContext(Account account) {
        super(account.getEmail(), account.getPassword(), getAuthorities(account.getRole()));
        this.account = account;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.getKey()));
    }
}
