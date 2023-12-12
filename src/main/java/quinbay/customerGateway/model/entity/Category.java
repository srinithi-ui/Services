package quinbay.customerGateway.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import quinbay.customerGateway.model.constant.FieldNames;

import javax.persistence.*;

@Entity
@Table(name = FieldNames.CATEGORY_T)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Category {

    @Id
    @Column(name  = FieldNames.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FieldNames.NAME, nullable = false)
    private  String name;

//
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<quinbay.Inventory.model.entity.Product>  products;



}
