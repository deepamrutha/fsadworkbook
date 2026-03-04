
package com.ecommerce.controller;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo){
        this.repo=repo;
    }

    // Insert sample product
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return repo.save(product);
    }

    // Find by category (Derived Query)
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){
        return repo.findByCategory(category);
    }

    // Filter by price range
    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam double min,@RequestParam double max){
        return repo.findByPriceBetween(min,max);
    }

    // Sort by price
    @GetMapping("/sorted")
    public List<Product> sortedProducts(){
        return repo.sortByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price){
        return repo.findExpensiveProducts(price);
    }
}
