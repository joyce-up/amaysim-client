package com.amaysim_client;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {

	private String productsUrl = "http://ec2-54-206-17-197.ap-southeast-2.compute.amazonaws.com/amaysim/products";
	private String productByIdUrl = "http://ec2-54-206-17-197.ap-southeast-2.compute.amazonaws.com/amaysim/product/1";
	
    public static void main(String args[]) {
        SpringApplication.run(App.class);
    }

    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        List<Product> products = 
        		(List<Product>) restTemplate.getForObject(productsUrl, List.class);
        
        System.out.println();
        System.out.println(productsUrl + ": ");
        System.out.println(products);
        System.out.println();
        
        
        Product product = restTemplate.getForObject(productByIdUrl, Product.class);
        System.out.println();
        System.out.println(productByIdUrl + ": ");
        System.out.println(product);
        System.out.println();
    }
}