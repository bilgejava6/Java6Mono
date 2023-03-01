package com.muhammet.Java6Mono.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MusteriFindAllResponseDto {
    String username;
    String ad;
    String img;
    String telefon;
}
