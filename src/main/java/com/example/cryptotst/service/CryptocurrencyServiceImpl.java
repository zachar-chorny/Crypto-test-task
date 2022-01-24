package com.example.cryptotst.service;

import com.example.cryptotst.dao.CryptocurrencyDao;
import com.example.cryptotst.model.Cryptocurrency;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService {
    private final CryptocurrencyDao dao;
    private final String csvPath = "src/main/resources/report.csv";

    public CryptocurrencyServiceImpl(CryptocurrencyDao dao) {
        this.dao = dao;
    }

    @Override
    public Cryptocurrency add(Cryptocurrency cryptocurrency) {
        cryptocurrency.setActualDate(LocalDateTime.now());
        return dao.save(cryptocurrency);
    }

    @Override
    public Cryptocurrency findMinByName(String name) {
        return dao.findFirstByNameOrderByPriceAsc(name);
    }

    @Override
    public Cryptocurrency findMaxByName(String name) {
        return dao.findFirstByNameOrderByPriceDesc(name);
    }

    @Override
    public List<Cryptocurrency> getPage(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Cryptocurrency> pageCrypto = dao.findAllByOrderByPriceAsc(paging);
        return pageCrypto.getContent();
    }

    @Override
    public void createCsv() {
        File file = new File(csvPath);
        List<String[]> data = new ArrayList();
        data.add(new String[]{"Name", "Min", "Max"});
        data.add(new String[]{"BTC",
                String.valueOf(findMinByName("BTC").getPrice()),
                String.valueOf(findMaxByName("BTC").getPrice())});
        data.add(new String[]{"XRP",
                String.valueOf(findMinByName("XRP").getPrice()),
                String.valueOf(findMaxByName("XRP").getPrice())});
        data.add(new String[]{"ETH",
                String.valueOf(findMinByName("ETH").getPrice()),
                String.valueOf(findMaxByName("ETH").getPrice())});
        try (FileWriter fileWriter = new FileWriter(file);
                CSVWriter csvWriter = new CSVWriter(fileWriter)) {
            csvWriter.writeAll(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
