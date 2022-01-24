package com.example.cryptotst.service.mapper;

import com.example.cryptotst.model.Cryptocurrency;
import com.example.cryptotst.model.dto.CryptocurrencyRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CryptocurrencyRequestDtoMapper implements
        RequestDtoMapper<CryptocurrencyRequestDto, Cryptocurrency> {
    @Override
    public Cryptocurrency mapToModel(CryptocurrencyRequestDto dto) {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setName(dto.getCurr1());
        cryptocurrency.setPrice(dto.getLprice());
        return cryptocurrency;
    }
}
