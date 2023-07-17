package com.ricardocamacho.examen.dto;

import lombok.Data;

@Data
public class GenericResponseDto<T> {
    private T response  ;  

    public GenericResponseDto<T> build (T referenceObject){
        this.response  = referenceObject;
        return this;
    }
}
