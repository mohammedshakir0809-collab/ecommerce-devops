package com.example.ecommerce_app;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ProductController {

  @GetMapping("/")
  public String home() {
    return "Online Grocery Store - DevOps Capstone";
  }

  @GetMapping("/health")
  public Map<String,String> health() {
    return Map.of("status", "UP");
  }

  @GetMapping("/api/products")
  public List<Map<String,Object>> products() {
    return List.of(
      Map.of("id",1,"name","Rice","price",60),
      Map.of("id",2,"name","Milk","price",30));
  }
}
