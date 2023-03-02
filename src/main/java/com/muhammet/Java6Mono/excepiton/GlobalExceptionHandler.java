package com.muhammet.Java6Mono.excepiton;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * @ExceptionHandler -> Uygulama içinde oluşacak hatanını türünü bizden alarak
     * onun yakalanmasını sağlar, böylece yakaladığı istisnayı methoda geçer.
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception exception){
        return ResponseEntity.badRequest().body("Uygulamada beklenmeyen bir hata oluştu...: "+ exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(SatisManagerException.class)
    public ResponseEntity<String> handleSatisManagerExcetion(SatisManagerException exception){
        return  ResponseEntity.badRequest().body("Satış İşlem Hatası....: "+ exception.getMessage());
    }

}
