package com.example.myservice;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.security.NoSuchAlgorithmException;

@Service
public class Base64EncodingService implements EncodingService {

    @Override
    public String encode(String text) {
        try {
            return Base64.getEncoder().encodeToString(text.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        } catch (Error e) {
            throw new RuntimeException("Could not complete Base64 encoding", e);
        }
    }
}
