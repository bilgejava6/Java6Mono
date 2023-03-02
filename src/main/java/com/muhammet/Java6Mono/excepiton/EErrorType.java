package com.muhammet.Java6Mono.excepiton;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {

    MUSTERI_BULUNAMADI(1003,"Aradınız müşteri sistemde kayıt değildir.", INTERNAL_SERVER_ERROR),
    URUN_EKLEME(2001,"Ürün ekleme başarısız oldu", INTERNAL_SERVER_ERROR),
    INVALID_PARAMETER(3001,"Geçersiz parametre giriş yaptınız", BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
