package com.amaysim_client;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {

	private String productsUrl = "http://ec2-54-206-17-197.ap-southeast-2.compute.amazonaws.com/amaysim/products";
	private String productByIdUrl = "http://ec2-54-206-17-197.ap-southeast-2.compute.amazonaws.com/amaysim/product/";
	
    public static void main(String args[]) {
        SpringApplication.run(App.class, args);
    }

    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        
        
        if (args.length == 0){
	        List<Product> products = 
	        		(List<Product>) restTemplate.getForObject(productsUrl, List.class);
	        
	        System.out.println();
	        System.out.println(productsUrl + ": ");
	        System.out.println(products);
	        System.out.println();
	        
        } else if (args.length == 1){
        	
        	try{
        	int id = Integer.parseInt(args[0]);
	        Product product = restTemplate.getForObject(productByIdUrl + id, Product.class);
	        System.out.println();
	        System.out.println(productByIdUrl + "("+ id +"): ");
	        System.out.println(product);
	        System.out.println();
        	} catch (java.lang.NumberFormatException e){
        		printUsage();
        	}
        } else {
        	printUsage();
        }
    }
    
    private void printUsage(){
    	System.out.println("Usage: \n\t\"java -jar amaysim-client-0.0.1.jar\" to list all the products"
    			+ "\n\t\"java -jar amaysim-client-0.0.1.jar\\ <productId>\" to list the product having the id <productId>");
    	
    }
}