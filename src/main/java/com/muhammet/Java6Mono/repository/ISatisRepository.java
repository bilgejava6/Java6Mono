package com.muhammet.Java6Mono.repository;

import com.muhammet.Java6Mono.repository.entity.Satis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISatisRepository extends JpaRepository<Satis,Long> {
    /**
     * A Kişisine neler satıldı?
     * @param musteriId
     * @return
     */
    List<Satis> findAllByMusteriid(Long musteriId);

    /**
     * 3- En çok satış adedi olan müşteri
     * - hangi müşteri ne kadar ürün satın almış
     * select musteriid, SUM(adet) from tblmusteri group by musteriid
     * - en çok ürün satışı olan müşteri
     * select musteriid from tblmusteri group by musteriid order by SUM(adet) desc top 1
     */
    @Query(
            value = "select s.musteriid from Satis s group by s.musteriid order by SUM(s.adet) desc limit 1",
            nativeQuery = true
    )
    Long findBySumSatisAdet();

    /**
     * 4- En çok satılan 3 ürün
     * @return
     */
    @Query(
            value = "select s.urunid from Satis s group by s.urunid order by SUM(s.adet) desc limit 3",
    nativeQuery = true)
    List<Long> findAllBySatisAdet();

}
