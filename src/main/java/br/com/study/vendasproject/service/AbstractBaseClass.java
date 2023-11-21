package br.com.study.vendasproject.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseClass {

    @Autowired
    protected ModelMapper mapper;

}
