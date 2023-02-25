package com.example.assignment1.config;


import com.example.assignment1.models.Customer;
import com.example.assignment1.models.Product;
import com.example.assignment1.repository.CustomerRepository;
import com.example.assignment1.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class SeedConfig {
    @Bean
    @Qualifier("e_commerceSeed")
    public CommandLineRunner run(
            ProductRepository productRepository,
            CustomerRepository customerRepository

    ) throws Exception {
        return (String[] args) -> {
            this.createCustomer(customerRepository);
            this.createProduct(productRepository);
        };
    }

    private void createCustomer(CustomerRepository customerRepository) throws IOException {
        InputStream inputStreamRoles = new ClassPathResource("seed/customers.json",
                this.getClass().getClassLoader()).getInputStream();
        String text = new BufferedReader(new InputStreamReader(inputStreamRoles))
                .lines().parallel().collect(Collectors.joining("\n"));
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> clientFilterJson = Arrays.asList(mapper.readValue(text, Map[].class));
        for (Map<String, String> map : clientFilterJson) {
            try {
               if(!customerRepository.existsById(Long.valueOf(map.get("id")))){
                   Customer customer = Customer.builder()
                           .id(Long.valueOf(map.get("id")))
                           .name(map.get("name"))
                           .email(map.get("email"))
                           .password(map.get("password"))
                           .build();
                   customerRepository.save(customer);
               }
            } catch (Exception e) {
                log.info("eeeee[create customer] >>>> {}", e.toString());
            }
        }
    }

    private void createProduct(ProductRepository productRepository) throws IOException {
        InputStream inputStreamRoles = new ClassPathResource("seed/products.json",
                this.getClass().getClassLoader()).getInputStream();
        String text = new BufferedReader(new InputStreamReader(inputStreamRoles)).lines().parallel().collect(Collectors.joining("\n"));
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> clientFilterJson = Arrays.asList(mapper.readValue(text, Map[].class));
        for (Map<String, String> map : clientFilterJson) {
            try {
                if(!productRepository.existsById(Long.valueOf(map.get("id")))){
                    Product product = Product.builder()
                            .id(Long.valueOf(map.get("id")))
                            .name(map.get("name"))
                            .description(map.get("description"))
                            .price(Double.parseDouble(map.get("price")))
                            .stock(Integer.parseInt(map.get("stock")))
                            .build();
                    productRepository.save(product);
                }
            } catch (Exception e) {
                log.info("eeeee[create product] >>>> {}", e.toString());
            }
        }
    }
}
