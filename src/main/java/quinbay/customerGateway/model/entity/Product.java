package quinbay.customerGateway.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quinbay.customerGateway.model.constant.FieldNames;

import javax.persistence.*;

@Entity
@Table(name = FieldNames.PRODUCT_T)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Product {
    @Id
    @Column(name  = FieldNames.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FieldNames.NAME, nullable = false)
    private  String name;

    @Column(name = FieldNames.PRICE, nullable = false)
    private double price ;


    @Column(name = FieldNames.QUANTITY, nullable = false)
    private  int quantity;

    @ManyToOne
    @JoinColumn(name = FieldNames.CATEGORY_ID, nullable = false)
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
