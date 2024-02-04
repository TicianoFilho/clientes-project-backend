package br.com.study.vendasproject.rest.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public abstract class AbstractBaseClass {

    @Autowired
    protected ModelMapper mapper;

    @Autowired
    MessageSource messageSource;

    protected String getMessage(String messageCode) {
        return this.messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
    }

    protected String getMessage(String messageCode, String... args) {
        return this.messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }

}
