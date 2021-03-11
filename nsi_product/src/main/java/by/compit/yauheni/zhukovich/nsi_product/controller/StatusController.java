package by.compit.yauheni.zhukovich.nsi_product.controller;

import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import by.compit.yauheni.zhukovich.nsi_product.service.BankingProductCardService;
import by.compit.yauheni.zhukovich.nsi_product.service.ProductService;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NullEntityException;
import by.compit.yauheni.zhukovich.nsi_product.service.model.Data;
import by.compit.yauheni.zhukovich.nsi_product.service.model.StatusResponse;

@RestController
@RequestMapping("/synchronize")
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
public class StatusController {

    @Value("${url}")
    private String url;
    @Value("${auth.username}")
    private String username;
    @Value("${auth.password}")
    private String password;

    private final ProductService productService;
    private final BankingProductCardService bankingProductCardService;

    public StatusController(ProductService productService, BankingProductCardService bankingProductCardService) {
        this.productService = productService;
        this.bankingProductCardService = bankingProductCardService;
    }

    @GetMapping(produces = "application/json;charset=utf-8")
    public Object synchronize(
            @RequestParam String id,
            @RequestParam String status
    ) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            bankingProductCardService.updateStatusById(id, status);
        } catch (NullEntityException e) {
            statusResponse.setUpdatedStatus(e.getMessage());
            return statusResponse;
        }
        List<Long> productsId;
        try {
            productsId = productService.getIdsByBPCardId(id);
        } catch (NullEntityException e) {
            statusResponse.setUpdatedStatus(e.getMessage());
            return statusResponse;
        }
        RestTemplate restTemplate = getRestTemplate();
        Data data = new Data(productsId, status);
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<Data> request = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        String responseBody = response.getBody();
        JSONObject jsonObject = new JSONObject(responseBody);
        String msg = (String) jsonObject.get("msg");
        statusResponse.setUpdatedStatus(msg);
        return statusResponse;
    }

    private RestTemplate getRestTemplate() {
        ClientHttpRequestFactory requestFactory = new
                HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
        return restTemplate;
    }

}