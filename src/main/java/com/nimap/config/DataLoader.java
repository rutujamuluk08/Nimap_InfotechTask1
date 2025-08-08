package com.nimap.config;

import com.nimap.entity.Category;
import com.nimap.entity.Product;
import com.nimap.repository.CategoryRepository;
import com.nimap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Load categories
        Category electronics = new Category("Electronics", "Electronic devices and gadgets");
        Category clothing = new Category("Clothing", "Fashion and apparel");
        Category books = new Category("Books", "Books and publications");
        Category home = new Category("Home & Garden", "Home improvement and garden items");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, books, home));

        // Load products
        Product laptop = new Product("Laptop", "High-performance laptop for work and gaming", 
                                   new BigDecimal("999.99"), electronics);
        Product smartphone = new Product("Smartphone", "Latest smartphone with advanced features", 
                                       new BigDecimal("699.99"), electronics);
        Product tshirt = new Product("T-Shirt", "Comfortable cotton t-shirt", 
                                   new BigDecimal("19.99"), clothing);
        Product jeans = new Product("Jeans", "Classic blue jeans", 
                                  new BigDecimal("49.99"), clothing);
        Product novel = new Product("The Great Novel", "Bestselling fiction novel", 
                                  new BigDecimal("14.99"), books);
        Product gardenTool = new Product("Garden Tool Set", "Complete set of garden tools", 
                                       new BigDecimal("89.99"), home);

        productRepository.saveAll(Arrays.asList(laptop, smartphone, tshirt, jeans, novel, gardenTool));
    }
}
