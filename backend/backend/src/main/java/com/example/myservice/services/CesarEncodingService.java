package com.example.myservice;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class CesarEncodingService implements EncodingService {

    private final int shift;

    public CesarEncodingService() {
        this.shift = 3;
    }

    @Override
    public String encode(String text) {
        try {
            StringBuilder encoded = new StringBuilder();
            for (char character : text.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isLowerCase(character) ? 'a' : 'A';
                    int offset = Character.toLowerCase(character) - base;
                    int shifted = (offset + shift) % 26;
                    encoded.append((char) (base + shifted));
                } else {
                    encoded.append(character);
                }
            }
            return encoded.toString();
        } catch (Error e) {
            throw new RuntimeException("Could not complete Cesar encoding", e);
        }
    }
}
