package com.gateway.ApiGateWay.models;


import lombok.*;
import org.hibernate.validator.constraints.CodePointLength;

import java.util.Collection;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private Long expireAt;
    private Collection<String> authorities;

}
