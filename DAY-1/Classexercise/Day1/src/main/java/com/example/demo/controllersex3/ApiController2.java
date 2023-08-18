package com.example.demo.controllersex3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController2 {
          
          @Value("${val1}")
          private String yourFavColor;

          @GetMapping("/c")
          public String getName()
          {
        	  return "My favorite color is "+yourFavColor;
          }
}
