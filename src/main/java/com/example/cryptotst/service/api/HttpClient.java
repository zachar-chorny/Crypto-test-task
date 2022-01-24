package com.example.cryptotst.service.api;

public interface HttpClient<T> {
    public T getDataTroughHttp(String url, Class<? extends T> clazz);
}
