package com.example.javabasic.sample.java8;

import lombok.Data;

import java.util.Optional;

/**
 * @description: Optional Test
 * @author: cph
 * @date: 2021/6/17 17:19
 */
public class OptionalDemo {
    public static void main(String[] args) {

        Product product = new Product();
        product.setId(1L);
        product.setName("name");
        product.setType("type");

        Optional<Object> empty = Optional.empty();

        // 使用Optional包装product，product可能为null
        Optional<Product> p1 = Optional.of(product);
        Product p2 = p1.get();

        Product p3;
        // 原写法
        if (product == null) {
            p3 = new Product();
        }
        // Optional写法
        p3 = Optional.of(product).orElse(new Product());

        // 原写法
        // product == null ? null : new Product();
        // Optional写法
        Optional.of(product).orElseGet(() -> new Product());

    }

    @Data
    static class Product {
        private Long id;
        private String name;
        private String type;

    }
}
