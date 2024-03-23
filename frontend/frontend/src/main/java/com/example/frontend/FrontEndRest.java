package com.example.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontEndRest {
    @GetMapping("/infos")
    @ResponseBody
    public String infos() {
        return "<html>" +
                "<body>" +
                "<p>Cesar Encoding: Shifts each letter by a fixed number of positions in the alphabet.</p>" +
                "<p>SHA-256 Encoding: Generates a unique fixed-size 256-bit (32-byte) hash. It's a one-way function.</p>" +
                "<p>Base64 Encoding: Encodes binary data to plain text using Base64 digits.</p>" +
                "<p>MD5 Encoding: Produces a 128-bit (16-byte) hash value, typically rendered as a 32 character hexadecimal number.</p>" +
                "</body>" +
                "</html>";
    }
    
}
