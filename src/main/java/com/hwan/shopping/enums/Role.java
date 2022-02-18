package com.hwan.shopping.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST","손님"),
    USER("ROLE_USER","유저"),
    ADMIN("ROLE_ADMIN","관리자");


    private final String key;
    private final String title;
}
