package com.estanciero.api.dto;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserCreateRequestDTO {

    private String name;

    private String email;

    private String password;

}
