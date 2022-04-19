package demo.demo.democrudapp.model;

import demo.demo.democrudapp.enums.CategoryType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "product")
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_Id")
    private Long id;
    private String name;
    private Double price;
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @ManyToMany
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "product_Id"),
            inverseJoinColumns = @JoinColumn(name = "order_Id")
    )
    @ToString.Exclude
    private Set<Order> orderList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
