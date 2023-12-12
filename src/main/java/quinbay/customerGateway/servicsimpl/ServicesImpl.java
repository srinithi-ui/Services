package quinbay.customerGateway.servicsimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import quinbay.customerGateway.CustomerGatewayApplication;
import quinbay.customerGateway.customerdata.Customer;
import java.util.*;

import quinbay.customerGateway.model.vo.ProductVo;
import quinbay.customerGateway.services.*;

import quinbay.customerGateway.model.vo.CategoryVo;
@Service
public class ServicesImpl implements Services {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    @Override
//    public void sendMessage(String message){
//        kafkaTemplate.send("com.quinbay.product.create", message);
//    }
//
//    @Override
//    public void postKafka(Customer customer) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String details = objectMapper.writeValueAsString(customer);
//        kafkaTemplate.send("com.quinbay.product.create",details);
//    }


    private String baseUrl = "http://localhost:8099/httpmethod";
    public List<Customer> getAllProductDetails(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl+"/product").build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();

    }




    public List<Customer> getProductByName(String productName){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl+"/product/name").queryParam("name",productName).build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();

    }


    public String postDetails(ProductVo product) throws JsonProcessingException{
//        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductVo> entity = new HttpEntity<>(product, headers);
//        ObjectMapper objectMapper = new ObjectMapper();
        return restTemplate.exchange("http://localhost:8099/httpmethod/product/add", HttpMethod.POST, entity, String.class).getBody();

    }

    public String putDetails(long id, ProductVo product){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductVo> entity = new HttpEntity<>(product, headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl+"/product/update").queryParam("id",id).build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, String.class).getBody();

    }

    public String deleteDetails(ProductVo product){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductVo> entity = new HttpEntity<>(product, headers);

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(baseUrl+"/product/delete").build();

        return restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, entity, String.class).getBody();
//            return null;


    }




    public String orderProduct(ProductVo product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductVo> entity = new HttpEntity<>(product, headers);
//        UriComponents builder  = UriComponentsBuilder.fromHttpUrl("http://localhost:8092/httpmethod/order/add").build();
        return restTemplate.exchange("http://localhost:8092/httpmethod/order/add", HttpMethod.POST, entity, String.class).getBody();


    }

    public List<Customer> getCustomerHistory(int customerId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8092/httpmethod/order/customer").queryParam("id",customerId).build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();

    }

    public List<Customer> getRecommendations(long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8100/httpmethod/getRecommendations").queryParam("id",id).build();
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();

    }
    public String postRecommendations(ProductVo product){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductVo> entity = new HttpEntity<>(product, headers);
        return restTemplate.exchange("http://localhost:8100/httpmethod/addRecommendation", HttpMethod.POST, entity, String.class).getBody();

    }


}
