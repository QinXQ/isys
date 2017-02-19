package com.qin.isys.config.controller;

import com.qin.isys.modules.user.exception.JustWantException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * use advice to help controller be better.
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({JustWantException.class})
    public String justWantException(){
        return "error/stopAndLook";
    }
}
