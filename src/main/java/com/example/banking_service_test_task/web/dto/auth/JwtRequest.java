package com.example.banking_service_test_task.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
@Schema(description = "Request for login")
public class JwtRequest {

    @Schema(description = "username", example = "nikita")
    @NotNull(message = "Username must be not null!")
    private String username;

    @Schema(description = "password", example = "12345")
    @NotNull(message = "Password must be not null!")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
