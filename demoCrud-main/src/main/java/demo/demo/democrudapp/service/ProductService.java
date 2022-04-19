package demo.demo.democrudapp.service;

import demo.demo.democrudapp.enums.CategoryType;
import demo.demo.democrudapp.model.Product;
import demo.demo.democrudapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public List<Product> findProductsByCategoryType(CategoryType categoryType) {
        return productRepository.findProductsByCategoryType(categoryType);
    }

    public Product createNewProduct(Product product) {
        return productRepository.save(product);
    }

    public String updateProduct(Product product) {
        String response = "";
        Optional<Product> currentProduct = productRepository.findById(product.getId());
        if (currentProduct.isPresent()) {
            productRepository.save(product);
            response = "Product was updated in database!";
        } else {
            response = "Product with id " + product.getId() + " was not found. Database was not updated!";
        }
        return response;
    }

    public String deleteProductById(Long id) {
        String response = "";
        Optional<Product> currentProduct = productRepository.findById(id);
        if (currentProduct.isPresent()) {
            productRepository.deleteById(id);
            response = "Product with id " + id + " deleted from database!";
        } else {
            response = "Product with id " + id + " was not found. Database was not updated!";
        }
        return response;
    }
}
