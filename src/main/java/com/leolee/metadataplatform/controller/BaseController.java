package com.leolee.metadataplatform.controller;

import com.leolee.metadataplatform.exception.ErrorInfo;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by panxiaobai on 20/08/2017.
 */
@RestController
public class BaseController {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleTypeMismatchException(HttpServletRequest req,
                                                 TypeMismatchException ex) {
        String errorURL = req.getRequestURL().toString();
        int code = HttpStatus.BAD_REQUEST.value();
        String type = ex.getErrorCode();
        Locale locale = LocaleContextHolder.getLocale();
        String errorMessage = messageSource.getMessage("error.customer.id", new Object[] { ex.getValue() }, locale);

        return new ErrorInfo(errorURL, code, type, errorMessage);
    }
}
