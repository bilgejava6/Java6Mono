package com.muhammet.Java6Mono.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblurun")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String marka;
    String model;
    Double fiyat;
    int kdv;
    String barkod;
    int stokadedi;
    String detay;


}
