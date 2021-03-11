package by.belinvest.panel.admin.product.service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import by.belinvest.panel.admin.product.repository.RealProductRepository;
import by.belinvest.panel.admin.product.service.exception.BRISRequestStatusFieldException;
import by.belinvest.panel.admin.product.service.handler.RestTemplateResponseErrorHandler;
import by.belinvest.panel.admin.product.service.model.CardProductAdd;
import by.belinvest.panel.admin.product.service.model.CardProductEdit;
import by.belinvest.panel.admin.product.service.model.CreditProductAddRequest;
import by.belinvest.panel.admin.product.service.model.DepositProductAddRequest;
import by.belinvest.panel.admin.product.service.model.DimItem;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static by.belinvest.panel.admin.product.service.model.Status.getStatus;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertBigDecimalToString;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertIntegerToString;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertLongToString;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertRealProductToCardProductAdd;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertRealProductToCardProductEdit;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertRealProductToCreditProductAddRequest;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertRealProductToDepositProductAddRequest;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertRealProductToUrCredDimItem;
import static by.belinvest.panel.admin.product.service.util.ProductConversionUtil.convertRealProductToUrDepDimItem;

@Service
@PropertySource("classpath:remotehttp.properties")
public class BankProductService {

    public static final String NO_STATUS_ATTR_BRIS_MESSAGE = "Не удалось записать значение статуса с помощью \"API по взаимодействию SiebelCRM с ЦСКОФЛ BRIS\" " +
            "ввиду отсутствия соответствующего атрибута.";
    public static final String NO_STATUS_ATTR_BARS_MESSAGE = "Не удалось записать значение статуса с помощью \"API по взаимодействию SiebelCRM с ИУС BARS\" " +
            "ввиду отсутствия соответствующего атрибута.";
    public static final String NOT_SYNCHRONIZED_STATUS_UPDATE_MESSAGE = "Продукт не синхронизирован, и статус не может быть обновлен.";
    @Value("${bris_url}")
    private String brisUrl;
    @Value("${bars_url}")
    private String barsUrl;
    @Value("${credit_products_url}")
    private String creditProductsUrl;
    @Value("${card_products_url}")
    private String cardProductsUrl;
    @Value("${debit_products_url}")
    private String debitProductsUrl;
    @Value("${ur_products_url}")
    private String urProductsUrl;
    private final RealProductRepository realProductRepository;

    public BankProductService(RealProductRepository realProductRepository) {this.realProductRepository = realProductRepository;}

    public boolean addCredit(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        checkStatus(NOT_SYNCHRONIZED_STATUS_UPDATE_MESSAGE);
        RestTemplate restTemplate = getRestTemplate();
        CreditProductAddRequest creditProductAddRequest = convertRealProductToCreditProductAddRequest(realProduct);
        String url = brisUrl + creditProductsUrl;
        LinkedHashMap response;
        try {
            response = restTemplate.postForObject(
                    url,
                    creditProductAddRequest,
                    LinkedHashMap.class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            return false;
        }
        for (Object responseRow : response.entrySet()) {
            System.out.println(responseRow.toString());
        }
        Long sysId = (Long) response.get("creditProductId");
        System.out.println(sysId);
        BigDecimal id = (BigDecimal) realProduct.get("ID");
        System.out.println(id);
        realProductRepository.updateCreditSetSysId(id.longValue(), sysId);
        System.out.println("Added product ID: " + sysId);
        return sysId != null;
    }

    public boolean addCard(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        checkStatus(NOT_SYNCHRONIZED_STATUS_UPDATE_MESSAGE);
        RestTemplate restTemplate = getRestTemplate();
        CardProductAdd cardProductAdd = convertRealProductToCardProductAdd(realProduct);
        String url = brisUrl + cardProductsUrl;
        LinkedHashMap response;
        try {
            response = restTemplate.postForObject(
                    url,
                    cardProductAdd,
                    LinkedHashMap.class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            return false;
        }
        for (Object responseRow : response.entrySet()) {
            System.out.println(responseRow.toString());
        }
        Long sysId = (Long) response.get("cardProductId");
        BigDecimal id = (BigDecimal) realProduct.get("ID");
        realProductRepository.updateCardSetSysId(id.longValue(), sysId);
        System.out.println("Added product ID: " + sysId);
        return sysId != null;
    }

    public boolean addDebit(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        checkStatus(NOT_SYNCHRONIZED_STATUS_UPDATE_MESSAGE);
        RestTemplate restTemplate = getRestTemplate();
        DepositProductAddRequest depositProductAddRequest = convertRealProductToDepositProductAddRequest(realProduct);
        String url = brisUrl + debitProductsUrl;
        LinkedHashMap response;
        try {
            response = restTemplate.postForObject(
                    url,
                    depositProductAddRequest,
                    LinkedHashMap.class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            return false;
        }
        for (Object responseRow : response.entrySet()) {
            System.out.println(responseRow.toString());
        }
        Long sysId = (Long) response.get("depositProductId");
        BigDecimal id = (BigDecimal) realProduct.get("ID");
        realProductRepository.updateDebitSetSysId(id.longValue(), sysId);
        System.out.println("Added product ID: " + sysId);
        return sysId != null;
    }

    public boolean updateCredit(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        RestTemplate restTemplate = getRestTemplate();
        CreditProductAddRequest creditProductAddRequest = convertRealProductToCreditProductAddRequest(realProduct);
        creditProductAddRequest.setCreditProductId(convertBigDecimalToString(realProduct.get("SYS_ID")));
        checkStatus(NO_STATUS_ATTR_BRIS_MESSAGE);
        String url = brisUrl + creditProductsUrl;
        HttpEntity<CreditProductAddRequest> requestEntity = new HttpEntity<>(creditProductAddRequest);
        ResponseEntity<LinkedHashMap> responseEntity;
        try {
            responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    requestEntity,
                    LinkedHashMap.class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            return false;
        }
        LinkedHashMap response = responseEntity.getBody();
        for (Object responseRow : response.entrySet()) {
            System.out.println(responseRow.toString());
        }
        Object creditProductId = response.get("creditProductId");
        String addedId;
        try {
            addedId = convertLongToString(creditProductId);
        } catch (ClassCastException e) {
            addedId = convertIntegerToString(creditProductId);
        }
        System.out.println("Updated product ID: " + addedId);
        return addedId != null;
    }

    public boolean updateDebit(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        RestTemplate restTemplate = getRestTemplate();
        DepositProductAddRequest depositProductAddRequest = convertRealProductToDepositProductAddRequest(realProduct);
        depositProductAddRequest.setDepositProductId(convertBigDecimalToString(realProduct.get("SYS_ID")));
        checkStatus(NO_STATUS_ATTR_BRIS_MESSAGE);
        String url = brisUrl + debitProductsUrl;
        HttpEntity<DepositProductAddRequest> requestEntity = new HttpEntity<>(depositProductAddRequest);
        ResponseEntity<LinkedHashMap> responseEntity;
        try {
            responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    requestEntity,
                    LinkedHashMap.class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            return false;
        }
        LinkedHashMap response = responseEntity.getBody();
        for (Object responseRow : response.entrySet()) {
            System.out.println(responseRow.toString());
        }
        Object depositProductId = response.get("depositProductId");
        String addedId;
        try {
            addedId = convertLongToString(depositProductId);
        } catch (ClassCastException e) {
            addedId = convertIntegerToString(depositProductId);
        }
        System.out.println("Updated product ID: " + addedId);
        return addedId != null;
    }

    public boolean updateCard(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        RestTemplate restTemplate = getRestTemplate();
        CardProductEdit cardProductEdit = convertRealProductToCardProductEdit(realProduct);
        checkStatus(NO_STATUS_ATTR_BRIS_MESSAGE);
        String url = brisUrl + cardProductsUrl;
        HttpEntity<CardProductEdit> requestEntity = new HttpEntity<>(cardProductEdit);
        ResponseEntity<LinkedHashMap> responseEntity;
        try {
            responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    requestEntity,
                    LinkedHashMap.class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            return false;
        }
        LinkedHashMap response = responseEntity.getBody();
        for (Object responseRow : response.entrySet()) {
            System.out.println(responseRow.toString());
        }
        Object cardProductId = response.get("cardProductId");
        String addedId;
        try {
            addedId = convertLongToString(cardProductId);
        } catch (ClassCastException e) {
            addedId = convertIntegerToString(cardProductId);
        }
        System.out.println("Updated product ID: " + addedId);
        return addedId != null;
    }

    public boolean addUrDep(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        checkStatus(NOT_SYNCHRONIZED_STATUS_UPDATE_MESSAGE);
        RestTemplate restTemplate = getRestTemplate();
        DimItem dimItem = convertRealProductToUrDepDimItem(realProduct);
        System.out.println(dimItem);
        String url = barsUrl + urProductsUrl;
        LinkedHashMap response;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dimItem);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            System.out.println(json);
            response = restTemplate.postForObject(
                    url,
                    entity,
                    LinkedHashMap.class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            System.out.println("Catch block enabled.");
            return false;
        }
        System.out.println("Add method cotinues.");
        Long barsId = Long.valueOf((String) response.get("dimId"));
        System.out.println(barsId);
        BigDecimal id = (BigDecimal) realProduct.get("DIMID");
        System.out.println(id);
        realProductRepository.updateUrDepSetDimId(id.longValue(), barsId);
        System.out.println("Added product ID: " + barsId);
        return barsId != null;
    }

    public boolean addUrCred(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        checkStatus(NOT_SYNCHRONIZED_STATUS_UPDATE_MESSAGE);
        RestTemplate restTemplate = getRestTemplate();
        DimItem dimItem = convertRealProductToUrCredDimItem(realProduct);
        System.out.println(dimItem);
        String url = barsUrl + urProductsUrl;
        LinkedHashMap response;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dimItem);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            System.out.println(json);
            response = restTemplate.postForObject(
                    url,
                    entity,
                    LinkedHashMap.class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            System.out.println("Catch block enabled.");
            return false;
        }
        System.out.println("Add method cotinues.");
        Long barsId = Long.valueOf((String) response.get("dimId"));
        System.out.println(barsId);
        BigDecimal id = (BigDecimal) realProduct.get("DIMID");
        System.out.println(id);
        realProductRepository.updateUrCredSetDimId(id.longValue(), barsId);
        System.out.println("Added product ID: " + barsId);
        return barsId != null;
    }

    public boolean updateUrCred(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        checkStatus(NOT_SYNCHRONIZED_STATUS_UPDATE_MESSAGE);
        RestTemplate restTemplate = getRestTemplate();
        DimItem dimItem = convertRealProductToUrCredDimItem(realProduct);
        System.out.println(dimItem);
        Long dimId = ((BigDecimal) realProduct.get("DIMID")).longValue();
        Long barsId = realProductRepository.getUrCredBarsIdByDimId(dimId);
        String url = barsUrl + urProductsUrl + barsId;
        System.out.println(url);
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dimItem);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            System.out.println(json);
            restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    Object[].class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            RestTemplateResponseErrorHandler.errors = "Ошибка приема данных банковским сервисом. Сообщение: \"" + e.getMessage() + "\"";
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateUrDep(Map<String, Object> realProduct) throws BRISRequestStatusFieldException {
        checkStatus(NOT_SYNCHRONIZED_STATUS_UPDATE_MESSAGE);
        RestTemplate restTemplate = getRestTemplate();
        DimItem dimItem = convertRealProductToUrDepDimItem(realProduct);
        System.out.println(dimItem);
        Long dimId = ((BigDecimal) realProduct.get("DIMID")).longValue();
        Long barsId = realProductRepository.getUrDepBarsIdByDimId(dimId);
        String url = barsUrl + urProductsUrl + barsId;
        System.out.println(url);
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(dimItem);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            System.out.println(json);
            restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    Object[].class);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            RestTemplateResponseErrorHandler.errors = "Ошибка приема данных банковским сервисом. Сообщение: \"" + e.getMessage() + "\"";
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private RestTemplate getRestTemplate() {
        ClientHttpRequestFactory requestFactory = new
                HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
        return restTemplate;
    }

    private void checkStatus(String message) throws BRISRequestStatusFieldException {
        String status = getStatus();
        if (status != null) {
            throw new BRISRequestStatusFieldException("Новое значение статуса - " + status.toUpperCase() + ". " +
                    message
            );
        }
    }

}
