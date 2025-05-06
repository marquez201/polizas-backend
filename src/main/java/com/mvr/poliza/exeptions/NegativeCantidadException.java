package com.mvr.poliza.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.mvr.poliza.utils.ResponseMessage;

public class NegativeCantidadException extends ResponseStatusException {
    public NegativeCantidadException() {
        this(ResponseMessage.CANTIDAD.getMsgInformativo());
    }
    public NegativeCantidadException(String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }
}
