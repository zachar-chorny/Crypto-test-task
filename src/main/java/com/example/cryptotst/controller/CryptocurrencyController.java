package com.example.cryptotst.controller;

import com.example.cryptotst.lib.ValidName;
import com.example.cryptotst.model.Cryptocurrency;
import com.example.cryptotst.model.dto.CryptocurrencyResponseDto;
import com.example.cryptotst.service.CryptocurrencyService;
import com.example.cryptotst.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cryptocurrencies")
@Validated
public class CryptocurrencyController {
    private final CryptocurrencyService service;
    private final ResponseDtoMapper<CryptocurrencyResponseDto, Cryptocurrency> dtoMapper;

    public CryptocurrencyController(CryptocurrencyService service,
                                    ResponseDtoMapper<CryptocurrencyResponseDto,
                                            Cryptocurrency> mapper) {
        this.service = service;
        this.dtoMapper = mapper;
    }

    @GetMapping("/min-price")
    public CryptocurrencyResponseDto getMinByName(@ValidName @RequestParam String name) {
        return dtoMapper.mapToDto(service.findMinByName(name));
    }

    @GetMapping("/max-price")
    public CryptocurrencyResponseDto getMaxByName(@ValidName @RequestParam String name) {
        return dtoMapper.mapToDto(service.findMaxByName(name));
    }

    @GetMapping("/page")
    public List<CryptocurrencyResponseDto> getPage(
            @RequestParam(defaultValue = "0") Integer number,
            @RequestParam(defaultValue = "10") Integer size) {
        return service.getPage(number, size).stream()
                .map(dtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/csv")
    public String createCsv() {
        service.createCsv();
        return "Report was created!";
    }
}
