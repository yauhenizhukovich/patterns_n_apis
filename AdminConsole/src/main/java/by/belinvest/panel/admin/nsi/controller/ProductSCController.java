package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.product_sc.ProductSC;
import by.belinvest.panel.admin.nsi.db.ProductSCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/product_sc")
public class ProductSCController {
    private static final String PRODUCT_SC_CREATE_URL = "/create";
    private static final String PRODUCT_SC_EDIT_URL = "/edit";
    private static final String PRODUCT_SC_REMOVE_URL = "/remove";
    private static final String PRODUCT_SC_DIRECTORY_GET_URL = "/nsi/product_sc";

    private static final String PRODUCT_SC_PSC_ID_PARAMETER = "PSC_ID";
    private static final String PRODUCT_SC_PSC_NAME_PARAMETER = "PSC_NAME";
    private static final String PRODUCT_SC_PSC_DESC_PARAMETER = "PSC_DESC";

    private static final String PRODUCT_SC_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PRODUCT_SC_PRIMARY_KEY = "PSC_ID";
    private static final String PRODUCT_SC_DOMAIN = "product_sc";

    @Autowired
    private ProductSCRepository productSCRepository;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PRODUCT_SC_DIRECTORY_PARAMETER, productSCRepository.get());
        model.addAttribute("domain",PRODUCT_SC_DOMAIN);
        model.addAttribute("primaryKey",PRODUCT_SC_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PRODUCT_SC_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PRODUCT_SC_PSC_NAME_PARAMETER) String pscName,
                               @RequestParam(value = PRODUCT_SC_PSC_DESC_PARAMETER) String pscDesc){

        productSCRepository.create(ProductSC.builder()
                .pscDesc(pscDesc)
                .pscName(pscName)
                .build()
        );
        return new RedirectView(request.getContextPath() + PRODUCT_SC_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PRODUCT_SC_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return productSCRepository.update(ProductSC.fromJSON(data));
    }

    @RequestMapping(value = PRODUCT_SC_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return productSCRepository.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PRODUCT_SC_PSC_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PRODUCT_SC_PSC_DESC_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
