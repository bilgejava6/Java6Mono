package com.muhammet.Java6Mono.excepiton;

import lombok.Getter;

@Getter
public class SatisManagerException extends RuntimeException{
    private final EErrorType errorType;

    public SatisManagerException(EErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public SatisManagerException(EErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
