package com.hwan.shopping.dto;

import com.hwan.shopping.domain.Account;
import com.hwan.shopping.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequestDto {

    private String email;
    private String password;
    private String name;
    private String role;

    public Account toEntity(){
        return Account.builder()
                .name(this.getName())
                .email(this.getEmail())
                .password(this.getPassword())
                .role(Role.valueOf(this.getRole()))
                .build();
    }
}
