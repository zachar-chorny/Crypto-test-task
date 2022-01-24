package com.example.cryptotst.service.api;

import com.example.cryptotst.model.dto.CryptocurrencyRequestDto;
import com.example.cryptotst.service.CryptocurrencyService;
import com.example.cryptotst.service.mapper.CryptocurrencyRequestDtoMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ApiFetcherServiceImpl implements ApiFetcherService {
    private final HttpClient httpClient;
    private final CryptocurrencyService service;
    private final CryptocurrencyRequestDtoMapper mapper;

    public ApiFetcherServiceImpl(HttpClient httpClient,
                                 CryptocurrencyService service,
                                 CryptocurrencyRequestDtoMapper mapper) {
        this.httpClient = httpClient;
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @Scheduled(cron = "0/60 * * * * *")
    public void fetchInfo() {
        CryptocurrencyRequestDto btc = (CryptocurrencyRequestDto) httpClient.getDataTroughHttp(
                "https://cex.io/api/last_price/BTC/USD", CryptocurrencyRequestDto.class);
        CryptocurrencyRequestDto eth = (CryptocurrencyRequestDto) httpClient.getDataTroughHttp(
                "https://cex.io/api/last_price/ETH/USD", CryptocurrencyRequestDto.class);
        CryptocurrencyRequestDto xrp = (CryptocurrencyRequestDto) httpClient.getDataTroughHttp(
                "https://cex.io/api/last_price/XRP/USD", CryptocurrencyRequestDto.class);
        service.add(mapper.mapToModel(btc));
        service.add(mapper.mapToModel(eth));
        service.add(mapper.mapToModel(xrp));
    }
}
