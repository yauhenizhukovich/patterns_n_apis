package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.product_class.ProductClass;
import by.belinvest.panel.admin.nsi.service.CurrencyService;
import by.belinvest.panel.admin.nsi.service.ProductClassService;
import by.belinvest.panel.admin.nsi.service.StatusProdService;
import by.belinvest.panel.admin.product.service.ProductGroupService;
import by.belinvest.panel.admin.product.service.ProductService;
import by.belinvest.panel.admin.product.service.TreeForUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/product_class")
public class ProductClassController {
    private static final String PRODUCT_CLASS_CREATE_URL = "/create";
    private static final String PRODUCT_CLASS_EDIT_URL = "/edit";
    private static final String PRODUCT_CLASS_REMOVE_URL = "/remove";
    private static final String PRODUCT_CLASS_DIRECTORY_GET_URL = "/nsi/preferential_rate";

    private static final String PRODUCT_CLASS_ID_PARAMETER = "ID";
    private static final String PRODUCT_CLASS_NOTE_PARAMETER = "NOTE";
    private static final String PRODUCT_CLASS_CODE_PARAMETER = "CODE";
    private static final String PRODUCT_CLASS_NAME_PARAMETER = "NAME";

    private static final String PRODUCT_CLASS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PRODUCT_CLASS_PRIMARY_KEY = "ID";
    private static final String PRODUCT_CLASS_DOMAIN = "preferential_rate";

    @Autowired
    private ProductClassService productClassService;

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

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("productGroups",productGroupService.getFifthLevelGroups());
        model.addAttribute("tree", treeService.getFifthTree(null,null,null,null,null,null,null));
        model.addAttribute("currencyList",currencyService.get());
        model.addAttribute("statusList",statusProdService.get());
return "nsi/productClass";
    }

    @RequestMapping(value = PRODUCT_CLASS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PRODUCT_CLASS_NOTE_PARAMETER) String note,
                               @RequestParam(value = PRODUCT_CLASS_CODE_PARAMETER) String code,
                               @RequestParam(value = PRODUCT_CLASS_NAME_PARAMETER) String name){

        productClassService.create(ProductClass.builder()
                .note(note)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + PRODUCT_CLASS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PRODUCT_CLASS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return productClassService.update(ProductClass.fromJSON(data));
    }

    @RequestMapping(value = PRODUCT_CLASS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return productClassService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PRODUCT_CLASS_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PRODUCT_CLASS_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PRODUCT_CLASS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
