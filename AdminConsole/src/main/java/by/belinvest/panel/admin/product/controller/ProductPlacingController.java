package by.belinvest.panel.admin.product.controller;


import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.product.Product;
import by.belinvest.panel.admin.entity.product.ProductElement;
import by.belinvest.panel.admin.entity.product.TreeElement;
import by.belinvest.panel.admin.nsi.service.CurrencyService;
import by.belinvest.panel.admin.nsi.service.StatusProdService;
import by.belinvest.panel.admin.product.dto.FullProductDto;
import by.belinvest.panel.admin.product.dto.ProductGroupTreeDTO;
import by.belinvest.panel.admin.product.service.ProductGroupService;
import by.belinvest.panel.admin.product.service.ProductService;
import by.belinvest.panel.admin.product.service.TreeForUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/product_placing")
public class ProductPlacingController {

    @Autowired
    private ProductGroupService productGroupService;

    @Autowired
    private TreeForUpdateService treeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StatusProdService statusProdService;

    @Autowired
    private CurrencyService currencyService;

    private static final String GET_PRODUCT_PLACING_VIEW = "product/product_placing";
    private static final String GET_REAL_PRODUCT_INFO = "product/real_product";

    @RequestMapping(method = RequestMethod.GET,value = "/main")
    public String getPage(Model model){
        model.addAttribute("productGroups",productGroupService.getFifthLevelGroups());
        model.addAttribute("tree", treeService.getFifthTree(null,null,null,null,null,null,null));
        model.addAttribute("currencyList",currencyService.get());
        model.addAttribute("statusList",statusProdService.get());
        return GET_PRODUCT_PLACING_VIEW;
    }


    @RequestMapping(method = RequestMethod.GET,value = "/filter")
    public String getTree(@RequestParam(required = false) Long firstLevelProductGroup ,
                          @RequestParam(required = false) Long secondLevelProductGroup,
                          @RequestParam(required = false) Long thirdLevelProductGroup,
                          @RequestParam(required = false) Long fourthLevelProductGroup,
                          @RequestParam(required = false) Long fifthLevelProductGroup,
                          @RequestParam(required = false) String currency,
                          @RequestParam(required = false) String status,
                          Model model) {
        model.addAttribute("tree", treeService.getFifthTree(firstLevelProductGroup, secondLevelProductGroup, thirdLevelProductGroup, fourthLevelProductGroup, fifthLevelProductGroup,currency,status));
        model.addAttribute("productGroups",productGroupService.getFifthLevelGroups());
        model.addAttribute("currencyList",currencyService.get());
        model.addAttribute("statusList",statusProdService.get());
        return GET_PRODUCT_PLACING_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    @ResponseBody
    public Product updateProduct(@RequestBody(required = false) ProductElement product) {
        return productService.updateBnIdAndDbId(product.getId(), product.getBnId(), product.getDbId());
    }

    @RequestMapping(method = RequestMethod.POST,value = "/product")
    public String getProduct(@RequestBody ProductElement product,Model model) {
        model.addAttribute("fullProductDTO",productService.getProductById(product.getProductId()));
        return GET_REAL_PRODUCT_INFO;
    }
}
