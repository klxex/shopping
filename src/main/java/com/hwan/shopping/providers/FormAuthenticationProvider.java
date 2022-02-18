package com.hwan.shopping.providers;

import com.hwan.shopping.domain.AccountContext;
import com.hwan.shopping.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FormAuthenticationProvider implements AuthenticationProvider {
    private final AccountService accountService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        AccountContext accountContext = (AccountContext) accountService.loadUserByUsername(username);
        String passwordFromDb = accountContext.getAccount().getPassword();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //주입 확인 필요

        if (!passwordEncoder.matches(password, passwordFromDb)) {
            throw new BadCredentialsException("비밀번호가 틀립니다.");
        }
        System.out.println("this is provider");
        return new UsernamePasswordAuthenticationToken(accountContext.getAccount(), null, accountContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
