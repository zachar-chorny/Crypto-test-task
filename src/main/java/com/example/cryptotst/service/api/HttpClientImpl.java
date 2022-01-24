package com.example.cryptotst.service.api;

import com.example.cryptotst.model.dto.CryptocurrencyRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class HttpClientImpl implements HttpClient<CryptocurrencyRequestDto> {
    private final ObjectMapper mapper;

    public HttpClientImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CryptocurrencyRequestDto getDataTroughHttp(
            String url, Class<? extends CryptocurrencyRequestDto> clazz) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                return mapper.readValue(result, clazz);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to perform request", e);
        }
    }
}
