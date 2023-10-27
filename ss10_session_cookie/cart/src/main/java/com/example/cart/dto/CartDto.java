package com.example.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();
    public CartDto(){}

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }
    public void addProduct(ProductDto productDto) {
        if(productMap.containsKey(productDto)){
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto,currentValue + 1);
        } else{
            productMap.put(productDto, 1);
        }
    }

    public Long countTotalPayment(){
        long payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (long) entry.getValue();
        }
        return payment;
    }
    public void plusProduct(Long id) {
         for(Map.Entry<ProductDto, Integer> entry : productMap.entrySet()){
             if(id == entry.getKey().getId()) {
                 productMap.replace(entry.getKey(), entry.getValue() + 1);
             }
         }
    }
    public void subtractProduct(Long id) {
          for(Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
              if(id == entry.getKey().getId()) {
                  productMap.replace(entry.getKey(), entry.getValue() - 1);
              }
          }
    }
}
