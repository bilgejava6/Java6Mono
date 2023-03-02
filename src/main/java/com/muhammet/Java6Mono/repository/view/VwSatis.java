package com.muhammet.Java6Mono.repository.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VwSatis {
    Long satisid;
    Long musteriid;
    String musteriadi;
    Long urunid;
    String urunadi;
    int adet;
    Double birimfiyat;
    Double toplamfiyat;
}
