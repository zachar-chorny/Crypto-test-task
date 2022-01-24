package com.example.cryptotst.dao;

import com.example.cryptotst.model.Cryptocurrency;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyDao extends MongoRepository<Cryptocurrency, ObjectId> {

    Cryptocurrency findFirstByNameOrderByPriceAsc(String name);

    Cryptocurrency findFirstByNameOrderByPriceDesc(String name);

    Page<Cryptocurrency> findAllByOrderByPriceAsc(Pageable pageable);
}
