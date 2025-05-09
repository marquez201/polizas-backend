package com.mvr.poliza.exeptions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageException {
    FAILURE("FAILURE");
    
    final String message;
}
