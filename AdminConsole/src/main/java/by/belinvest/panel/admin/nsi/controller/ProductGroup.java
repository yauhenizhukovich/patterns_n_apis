package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.nsi.service.CurrencyService;
import by.belinvest.panel.admin.nsi.service.StatusProdService;
import by.belinvest.panel.admin.product.service.ProductGroupService;
import by.belinvest.panel.admin.product.service.ProductService;
import by.belinvest.panel.admin.product.service.TreeForUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/nsi/product_group")
public class ProductGroup {
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

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model) {
        model.addAttribute("productGroups",productGroupService.getFifthLevelGroups());
        model.addAttribute("tree", treeService.getFifthTree(null,null,null,null,null,null,null));
        model.addAttribute("currencyList",currencyService.get());
        model.addAttribute("statusList",statusProdService.get());
        return "nsi/productgroup";
    }

}
