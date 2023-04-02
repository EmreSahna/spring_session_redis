package com.emresahna.sessionmanagmentwithredis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDto {
    private String username;
    private String password;
}
