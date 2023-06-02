package com.muhammet.Java6Mono.controller;

import static com.muhammet.Java6Mono.constants.EndPoints.*;
import com.muhammet.Java6Mono.dto.request.MusteriSaveRequestDto;
import com.muhammet.Java6Mono.dto.response.MusteriFindAllResponseDto;
import com.muhammet.Java6Mono.repository.entity.Musteri;
import com.muhammet.Java6Mono.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller - RestController
 * MVC        - RestApi İstekleri için
 * RequestMapping -> Uygulamanıza gelen isteklerin URL içinden analiz edilerek
 * ulaşması gereken sınıfa ulaştırılması için kullanılır.
 * Aslında Filter işlemi yapılarak yönlendirme yapılmaktadır.
 */
@RestController
// localhost:9090/musteri
@RequestMapping(API+VERSION+MUSTERI)
@RequiredArgsConstructor
public class MusteriController {
    private final MusteriService musteriService;

    /**
     * !!!!DİKKAT!!!!
     * RestApi data iletme ve alma işlemlerini yapar, burada data gönderimi ve alımı
     * olabildiğince amaca yönelik ve kısıtlı olmalıdır.
     * Bu nedenle, gereksiz şekilde dönülen Entity ler ve  datalar,
     * 1- güvenlik açığı oluşturur.
     * 2- performansı mahveder.
     * Bu sorunu çözmek adına DataTransferObject-DTO kullanırız. Dto ayrıca
     * talep ettiğimiz alanların validasyonunu yapmak içinde kullanılır.
     */

    /**
     * Bu sınıf içerisine getirilen isteklerin hangi method u tetikleyeceğinin bilinmesine
     * ihtiyaç vardır. Bu nedenle methodları işaretlememiz gerekir. Bu işaretleme işlemini
     * Post, Put,Get,Delete v.s. gibi işlemlere göre yaparız.
     *
     */

    /**
     * http://localhost:9090/musteri/save
     * ResponseEntity -> Kullanıcıya dönülecek olan datanın bir Varlık olarak
     * dönmesi ve bu varığın Json formatında dönmesi için kullanırız.
     * http://localhost:9090/musteri/save?ad=muhammet&adres=Ankara&telefon=05556669988
     */
    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody MusteriSaveRequestDto dto){
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        musteriService.saveDto(dto);
        return ResponseEntity.ok("Ok.");
    }

    /**
     *
     * http://localhost:9090/musteri/getall
     */
    @GetMapping(GETALL)
    @CrossOrigin("*")
    public ResponseEntity<List<MusteriFindAllResponseDto>> findAll(){
        return ResponseEntity.ok(musteriService.findAllResponseDtos());
    }

    @GetMapping(GETBYAD)
    @CrossOrigin("*")
    public ResponseEntity<Musteri> findByAd(String ad){
        return ResponseEntity.ok(musteriService.findByAd(ad));
    }

}
