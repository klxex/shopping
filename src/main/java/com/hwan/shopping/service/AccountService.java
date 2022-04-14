package com.hwan.shopping.service;

import com.hwan.shopping.domain.Account;
import com.hwan.shopping.domain.AccountContext;
import com.hwan.shopping.dto.AccountRequestDto;
import com.hwan.shopping.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("user name 이 존재하지 않습니다"));
        return new AccountContext(account);
    }

    public Long save(AccountRequestDto accountRequestDto){
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        accountRequestDto.setPassword(encode.encode(accountRequestDto.getPassword()));
        return accountRepository.save(accountRequestDto.toEntity()).getId();
    }



}
