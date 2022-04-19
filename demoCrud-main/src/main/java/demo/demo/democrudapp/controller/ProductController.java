package demo.demo.democrudapp.controller;

import demo.demo.democrudapp.model.Product;
import demo.demo.democrudapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> readAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> readProductById(@PathVariable Long id) {
        Product product = productService
                .findProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        return ResponseEntity.ok(product);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product currentProduct = productService.createNewProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(currentProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        Optional<Product> product = productService.findProductById(id);
//        String response =  productService.deleteProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProductById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productService.deleteProductById(id));
        }
    }


}

