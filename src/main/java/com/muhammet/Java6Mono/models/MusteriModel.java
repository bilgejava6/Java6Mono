package com.muhammet.Java6Mono.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MusteriModel {
    public String baslik;
    public List<String> musterilistesi;
    public String adres;
    public List<String> menulistesi;
}
