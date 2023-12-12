package quinbay.customerGateway.model.vo;

import lombok.Data;
import quinbay.customerGateway.model.entity.Category;

@Data
public class ProductVo {
    private int id;
    private String name;
    private double price;
    private int quantity;

//    @JsonBackReference
    private Category category;
    private int customerId;



}
