package com.example.myservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "localhost:4001")
public class MyServiceRest {

    @Autowired
    private CesarEncodingService cesarService;

    @Autowired
    private Sha256EncodingService sha256Service;

    @Autowired
    private Base64EncodingService base64Service;
    
    @Autowired
    private Md5EncodingService md5Service;

    @GetMapping("/")
    public String getRoot()
    {
        return "OK";
    }

    @GetMapping("/encode")
    public Map<String, Object> encode(@RequestParam String text) {
        Map<String, String> encodings = new HashMap<>();
        encodings.put("CESAR", cesarService.encode(text));
        encodings.put("SHA-256", sha256Service.encode(text));
        encodings.put("Base64", base64Service.encode(text));
        encodings.put("MD5", md5Service.encode(text));
        return createResponseWithMetadata(encodings);
    }    

    @GetMapping("/encode-cesar")
    public Map<String, Object> getCesarEncoding(@RequestParam String text) {
        Map<String, String> encodings = new HashMap<>();
        encodings.put("CESAR", cesarService.encode(text));
        return createResponseWithMetadata(encodings);
    }

    @GetMapping("/encode-sha256")
    public Map<String, Object> getSha256Encoding(@RequestParam String text) {
        Map<String, String> encodings = new HashMap<>();
        encodings.put("SHA-256", sha256Service.encode(text));
        return createResponseWithMetadata(encodings);
    }

    @GetMapping("/encode-base64")
    public Map<String, Object> getBase64Encoding(@RequestParam String text) {
        Map<String, String> encodings = new HashMap<>();
        encodings.put("Base64", base64Service.encode(text));
        return createResponseWithMetadata(encodings);
    }

    @GetMapping("/encode-md5")
    public Map<String, Object> getMd5Encoding(@RequestParam String text) {
        Map<String, String> encodings = new HashMap<>();
        encodings.put("MD5", md5Service.encode(text));
        return createResponseWithMetadata(encodings);
    }


    private Map<String, Object> createResponseWithMetadata(Map<String, String> encodings) {
        Map<String, Object> response = new HashMap<>();
        response.put("encoding", encodings);
    
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        response.put("timestamp", now.format(formatter));

        response.put("id", UUID.randomUUID().toString());
    
        return response;
    }
    
}
