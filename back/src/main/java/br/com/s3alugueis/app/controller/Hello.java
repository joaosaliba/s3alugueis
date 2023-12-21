package br.com.s3alugueis.app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Hello {

    @GetMapping("hello")
    public SomeData getMethodName() {
        return  new SomeData("Hello");
    }
    
  
    public record SomeData(
        String hello
    ){}
}
