package com.example.cryptotst.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
