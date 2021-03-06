package demo.demo.democrudapp.repository;

import demo.demo.democrudapp.enums.CategoryType;
import demo.demo.democrudapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductById(Long id);
    List<Product> findProductsByCategoryType(CategoryType categoryType);
}
