package com.acme.statusmgr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnsupportedDetailsRequestException extends RuntimeException {

    UnsupportedDetailsRequestException(String badParam) {
        super("Invalid details option: " + badParam);
    }
}
