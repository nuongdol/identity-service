package com.nuongdol.authen.request;

import lombok.Data;

@Data
public class ReqRes {
    private String accessToken;
    private String refreshToken;
    private String email;
    private String password;
    private String fullName;
}
