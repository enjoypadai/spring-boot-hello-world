package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!";
    }


    @GetMapping(value = "/getDate/{url}")
    public String getData(@PathVariable String url) throws Exception {
        URL oracle = new URL("https://"+url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        StringBuilder inputLineS = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            inputLineS.append(inputLine);
        }
        in.close();
        return  inputLineS.toString();
    }


}
