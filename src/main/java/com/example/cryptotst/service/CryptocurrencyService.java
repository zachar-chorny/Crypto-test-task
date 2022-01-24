package com.example.cryptotst.service;

import com.example.cryptotst.model.Cryptocurrency;
import java.util.List;

public interface CryptocurrencyService {

    Cryptocurrency add(Cryptocurrency cryptocurrency);

    Cryptocurrency findMinByName(String name);

    Cryptocurrency findMaxByName(String name);

    List<Cryptocurrency> getPage(Integer page, Integer size);

    void createCsv();
}
