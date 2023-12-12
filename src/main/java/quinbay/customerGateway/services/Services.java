package quinbay.customerGateway.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import quinbay.customerGateway.customerdata.Customer;
import quinbay.customerGateway.model.entity.Product;
import quinbay.customerGateway.model.vo.ProductVo;
import quinbay.customerGateway.model.vo.ProductVo;

import java.util.List;

public interface Services {
    List<Customer> getAllProductDetails();
    List<Customer> getProductByName(String name);
    String postDetails(ProductVo product) throws JsonProcessingException;
    String putDetails(long id, ProductVo product);
    String deleteDetails(ProductVo product);
    String orderProduct(ProductVo productVo);
    List<Customer> getCustomerHistory(int customerId);
    List<Customer> getRecommendations(long id);
    String postRecommendations(ProductVo productVo);



//    void sendMessage(String message);
//    void postKafka(Customer customer) throws JsonProcessingException;
//




}
