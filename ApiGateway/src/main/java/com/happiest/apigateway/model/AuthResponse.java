package com.happiest.apigateway.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

@NoArgsConstructor
public class AuthResponse {
    private String token;
    private UUID id;
    private String username;
    private String profilename;
    private String role;

    public AuthResponse(String token, UUID id, String username, String profilename, String role) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.profilename = profilename;
        this.role = role;
    }


    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", profilename='" + profilename + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

