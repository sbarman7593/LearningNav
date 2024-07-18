package com.example.learninNav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NumberApiServiceImpl implements NumberApiService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getFactForNumber(int number) {
        String url = "http://numbersapi.com/" + String.valueOf(number);
        String numberApiResponse = restTemplate.getForObject(url, String.class);

        return numberApiResponse;
    }
    
    

}
