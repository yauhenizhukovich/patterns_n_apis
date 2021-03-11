package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.product_type.ProductType;
import by.belinvest.panel.admin.nsi.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/product_type")
public class ProductTypeController {
    private static final String PRODUCT_TYPE_CREATE_URL = "/create";
    private static final String PRODUCT_TYPE_EDIT_URL = "/edit";
    private static final String PRODUCT_TYPE_REMOVE_URL = "/remove";
    private static final String PRODUCT_TYPE_DIRECTORY_GET_URL = "/nsi/product_type";

    private static final String PRODUCT_TYPE_ID_PARAMETER = "ID";
    private static final String PRODUCT_TYPE_NOTE_PARAMETER = "NOTE";
    private static final String PRODUCT_TYPE_CODE_PARAMETER = "CODE";
    private static final String PRODUCT_TYPE_NAME_PARAMETER = "NAME";

    private static final String PRODUCT_TYPE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PRODUCT_TYPE_PRIMARY_KEY = "ID";
    private static final String PRODUCT_TYPE_DOMAIN = "product_type";

    @Autowired
    private ProductTypeService productTypeService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PRODUCT_TYPE_DIRECTORY_PARAMETER, productTypeService.get());
        model.addAttribute("domain",PRODUCT_TYPE_DOMAIN);
        model.addAttribute("primaryKey",PRODUCT_TYPE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PRODUCT_TYPE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PRODUCT_TYPE_NOTE_PARAMETER) String note,
                               @RequestParam(value = PRODUCT_TYPE_CODE_PARAMETER) String code,
                               @RequestParam(value = PRODUCT_TYPE_NAME_PARAMETER) String name){

        productTypeService.create(ProductType.builder()
                .note(note)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + PRODUCT_TYPE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PRODUCT_TYPE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return productTypeService.update(ProductType.fromJSON(data));
    }

    @RequestMapping(value = PRODUCT_TYPE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return productTypeService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PRODUCT_TYPE_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PRODUCT_TYPE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PRODUCT_TYPE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
