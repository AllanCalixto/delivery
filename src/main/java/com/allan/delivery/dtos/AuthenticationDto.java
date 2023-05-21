package com.allan.delivery.dtos;

import lombok.Data;

@Data
public class AuthenticationDto {
    public String login;
    public String password;

    public AuthenticationDto() {
        this.login = getLogin();
        this.password = getPassword();
    }

}
