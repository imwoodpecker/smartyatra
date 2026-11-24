package com.smartyatra.smart_yatra_backend.dto;

import com.smartyatra.smart_yatra_backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRequest {
    private String email;
    private String name;
    private String password;
    private Role role;
}