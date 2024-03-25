package com.junioroffers.domain.loginandregister;

public class UserNameNotFoundException extends RuntimeException {
    public UserNameNotFoundException(String userNotFound) {
        super(userNotFound);
    }
}
