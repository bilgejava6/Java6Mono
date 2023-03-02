package com.muhammet.Java6Mono.service;

import com.muhammet.Java6Mono.repository.ISatisRepository;
import com.muhammet.Java6Mono.repository.entity.Musteri;
import com.muhammet.Java6Mono.repository.entity.Satis;
import com.muhammet.Java6Mono.repository.entity.Urun;
import com.muhammet.Java6Mono.repository.view.VwSatis;
import com.muhammet.Java6Mono.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SatisService extends ServiceManager<Satis,Long> {
    private final ISatisRepository repository;
    /**
     * @Autowired
     * Spring bu anotasyon ile işaretlenen sınıfların nesnelerini yaratarak
     * ilgili değişkene atamasını yapar. Bean yönetimini böylece sağlamış olur.
     */
    @Autowired
    private MusteriService musteriService;
    @Autowired
    private UrunService urunService;
    public SatisService(ISatisRepository repository){
        super(repository);
        this.repository=repository;
    }

    public List<VwSatis> findAllSatisList(){
        List<Urun> urunList = urunService.findAll();
        List<Musteri> musteriList = musteriService.findAll();

        List<VwSatis> vwSatisList = new ArrayList<>();
        findAll().forEach(x->{
            String musteriadi =
                    //musteriService.findById(x.getMusteriid()).get().getAd();
                    musteriList.stream()
                                .filter(m-> m.getId().equals(x.getMusteriid()))
                                .findFirst().get().getAd();
            String urunadi = urunList.stream()
                    .filter(u->u.getId().equals(x.getUrunid()))
                    .findFirst().get().getAd();
            VwSatis vwsatis = VwSatis.builder()
                    .satisid(x.getId())
                    .urunid(x.getUrunid())
                    .musteriid(x.getMusteriid())
                    .adet(x.getAdet())
                    .birimfiyat(x.getBirimfiyat())
                    .toplamfiyat(x.getToplamfiyat())
                    .musteriadi(musteriadi)
                    .urunadi(urunadi)
                    .build();
            vwSatisList.add(vwsatis);
        });
        return vwSatisList;
    }

}
