package com.green.smartGrade.security.sign.model;

import lombok.Data;

@Data
public class SignInParam {
    private String id;
    private String password;
    private String role;
}
