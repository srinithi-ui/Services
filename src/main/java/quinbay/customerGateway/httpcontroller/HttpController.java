package quinbay.customerGateway.httpcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;
import quinbay.customerGateway.customerdata.Customer;
import quinbay.customerGateway.model.vo.ProductVo;
import quinbay.customerGateway.services.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import quinbay.customerGateway.customerdata.*;

@RestController
@RequestMapping("/httpmethod")
public class HttpController {

    @Autowired
    Services service;

//    @PostMapping("/publish")
//    public void publishKafka(){
//        service.sendMessage("sri");
//    }
//
//    @PostMapping("/publish/send")
//    public void postKafka(@RequestBody Customer customer) throws JsonProcessingException {
//        service.postKafka(customer);
//
//    }


    @GetMapping("/product")
    public List<Customer> getAllProductDetails(){
        return service.getAllProductDetails();
    }
    @GetMapping("/product/name/{productName}")
    public List<Customer> getProductByName(@PathVariable String productName){
        return service.getProductByName(productName);
    }

    @PostMapping("/product/add")
    public String postDetails(@RequestBody ProductVo product) throws JsonProcessingException  {
        return service.postDetails(product);
    }
    @PutMapping("/product/update/{id}")
    public String putDetails(@PathVariable long id, @RequestBody ProductVo product) throws JsonProcessingException  {
        return service.putDetails(id, product);
    }

    @DeleteMapping("/product/delete")
    public String deleteDetails(@RequestBody ProductVo product) {
        return service.deleteDetails(product);
    }

    @PostMapping("/product/order")
    public String orderDetails(@RequestBody ProductVo productVo){
        return service.orderProduct(productVo);
    }


    @GetMapping("/customer/history/{id}")
    public List<Customer> getOrderHistory(@PathVariable int id){
        return service.getCustomerHistory(id);
    }

    @GetMapping("customer/recommendations/{id}")
    public List<Customer> getRecommendations(@PathVariable long id){
        return service.getRecommendations(id);
    }
    @PostMapping("customer/addRecommendation")
    public String postRecommendations(@RequestBody ProductVo productVo){
        return service.postRecommendations(productVo);
    }



}
