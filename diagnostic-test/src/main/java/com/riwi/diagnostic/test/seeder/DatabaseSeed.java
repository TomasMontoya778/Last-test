package com.riwi.diagnostic.test.seeder;

import com.riwi.diagnostic.test.domain.entities.Product;
import com.riwi.diagnostic.test.domain.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DatabaseSeed implements CommandLineRunner {

    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        log.info("Starting DatabaseSeed...");

        //Si la validación es true se corta
        if (this.productRepository.count() > 0) return;

        Product product1 = Product.builder().id("1").name("Laptop").description("High-performance laptop").price(999.99).build();
        Product product2 = Product.builder().id("2").name("Smartphone").description("Latest model smartphone").price(799.99).build();
        Product product3 = Product.builder().id("3").name("Tablet").description("10-inch display tablet").price(499.99).build();
        Product product4 = Product.builder().id("4").name("Smartwatch").description("Waterproof smartwatch").price(199.99).build();
        Product product5 = Product.builder().id("5").name("Wireless Headphones").description("Noise-cancelling headphones").price(149.99).build();
        Product product6 = Product.builder().id("6").name("Bluetooth Speaker").description("Portable Bluetooth speaker").price(89.99).build();
        Product product7 = Product.builder().id("7").name("External Hard Drive").description("1TB external hard drive").price(59.99).build();
        Product product8 = Product.builder().id("8").name("Gaming Console").description("Next-gen gaming console").price(499.99).build();
        Product product9 = Product.builder().id("9").name("Smart TV").description("4K Ultra HD Smart TV").price(1299.99).build();
        Product product10 = Product.builder().id("10").name("Digital Camera").description("High-resolution digital camera").price(699.99).build();

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);
    }
}
