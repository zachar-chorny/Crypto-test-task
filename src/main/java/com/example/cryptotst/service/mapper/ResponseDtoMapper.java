package com.example.cryptotst.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
