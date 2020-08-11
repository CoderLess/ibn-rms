package com.ibn.rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class IbmRmsProviderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(IbmRmsProviderApplication.class, args);
        System.in.read();
    }

}
