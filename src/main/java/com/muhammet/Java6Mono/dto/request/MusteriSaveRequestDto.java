package com.muhammet.Java6Mono.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MusteriSaveRequestDto {
    String token;
    String ip;
    String userpcmodel;
    String ad;
    String adres;
    String telefon;
}
