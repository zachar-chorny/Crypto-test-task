package com.example.cryptotst.service.mapper;

import com.example.cryptotst.model.Cryptocurrency;
import com.example.cryptotst.model.dto.CryptocurrencyResponseDto;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class CryptocurrencyResponseDtoMapper implements
        ResponseDtoMapper<CryptocurrencyResponseDto, Cryptocurrency> {
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @Override
    public CryptocurrencyResponseDto mapToDto(Cryptocurrency cryptocurrency) {
        CryptocurrencyResponseDto responseDto = new CryptocurrencyResponseDto();
        responseDto.setActualDate(cryptocurrency.getActualDate().format(formatter));
        responseDto.setName(cryptocurrency.getName());
        responseDto.setPrice(cryptocurrency.getPrice());
        return responseDto;
    }
}
