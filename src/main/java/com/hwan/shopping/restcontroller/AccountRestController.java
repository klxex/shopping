package com.hwan.shopping.restcontroller;

import com.hwan.shopping.dto.AccountRequestDto;
import com.hwan.shopping.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class AccountRestController {

    private final AccountService accountService;

    @GetMapping("/account")
    public void test(){
        System.out.println("테스트를 하겠습니다");
    }

    @PostMapping("/account")
    public void save(@RequestBody AccountRequestDto accountRequestDto){

        accountService.save(accountRequestDto);
    }

    
}
