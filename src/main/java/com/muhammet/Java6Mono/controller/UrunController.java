package com.muhammet.Java6Mono.controller;

import com.muhammet.Java6Mono.dto.request.UrunSaveRequestDto;
import com.muhammet.Java6Mono.repository.entity.Urun;
import com.muhammet.Java6Mono.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.muhammet.Java6Mono.constants.EndPoints.*;
@RestController
@RequestMapping(API+VERSION+URUN)
@RequiredArgsConstructor
public class UrunController {
    private final UrunService urunService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(UrunSaveRequestDto dto){
        urunService.saveDto(dto);
       return ResponseEntity.ok().build();
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Urun>> findAll(){
        return ResponseEntity.ok(urunService.findAll());
    }

}
