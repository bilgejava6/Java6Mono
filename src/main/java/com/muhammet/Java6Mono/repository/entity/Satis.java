package com.muhammet.Java6Mono.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblsatis")
public class Satis {

    /**
     * Tüm Katmanlar -> Mapper dahil yazılacak.
     * Ne zaman
     * Kime
     * Ne kdar
     * Ne
     * satıldı?
     * --------------------------
     * Sorgu
     * 1- Kime Ne satıldı Listesi
     * 2- A Kişisine neler satıldı listesi
     * 3- En çok satış adedi olan müşteri
     * 4- En çok satılan 3 ürün
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    Long urunid;
    Long tarih;
    int adet;
    Double birimfiyat;
    Double toplamfiyat;

}
