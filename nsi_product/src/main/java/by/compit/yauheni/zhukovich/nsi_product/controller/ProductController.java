package by.compit.yauheni.zhukovich.nsi_product.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.compit.yauheni.zhukovich.nsi_product.service.ProductService;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NonexistentProductException;
import by.compit.yauheni.zhukovich.nsi_product.service.model.ProductAggregation;

@RestController
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {this.productService = productService;}

    @GetMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public Object getProductById(
            @PathVariable Long id
    ) {
        try {
            return productService.getById(id);
        } catch (NonexistentProductException e) {
            return e.getMessage();
        }
    }

    @GetMapping(produces = "application/json;charset=utf-8")
    public ProductAggregation getProductByParameter(
            @RequestParam(required = false) String contragentType,
            @RequestParam(required = false) String productClass,
            @RequestParam(required = false) String productType,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate creationDate,
            @RequestParam(required = false) Long validityTerm
    ) {
        if (contragentType == null &&
                productClass == null &&
                productType == null &&
                productName == null &&
                creationDate == null &&
                validityTerm == null) {
            return productService.getAll();
        }
        if (contragentType != null) {
            return productService.getByContraAgentType(contragentType);
        }
        if (productClass != null) {
            return productService.getByProductClass(productClass);
        }
        if (productType != null) {
            return productService.getByProductType(productType);
        }
        if (productName != null) {
            return productService.getByProductName(productName);
        }
        return null;
    }

}
