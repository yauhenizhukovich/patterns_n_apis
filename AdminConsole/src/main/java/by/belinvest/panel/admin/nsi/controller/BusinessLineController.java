package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.business_line.BusinessLine;
import by.belinvest.panel.admin.nsi.service.BusinessLineService;
import by.belinvest.panel.admin.nsi.service.CurrencyService;
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
@RequestMapping(value = "/nsi/business_line")
public class BusinessLineController {
    private static final String BUSINESS_LINE_CREATE_URL = "/create";
    private static final String BUSINESS_LINE_EDIT_URL = "/edit";
    private static final String BUSINESS_LINE_REMOVE_URL = "/remove";
    private static final String BUSINESS_LINE_DIRECTORY_GET_URL = "/nsi/business_line";

    private static final String BUSINESS_LINE_CODE_PARAMETER = "CODE";
    private static final String BUSINESS_LINE_NAME_PARAMETER = "NAME";

    private static final String BUSINESS_LINE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BUSINESS_LINE_PRIMARY_KEY = "CODE";
    private static final String BUSINESS_LINE_DOMAIN = "business_line";

    @Autowired
    private BusinessLineService businessLineService;

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
        return "nsi/business_line";
    }

    @RequestMapping(value = BUSINESS_LINE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BUSINESS_LINE_NAME_PARAMETER) String name) {

        businessLineService.create(BusinessLine.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + BUSINESS_LINE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BUSINESS_LINE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return businessLineService.update(BusinessLine.fromJSON(data));
    }

    @RequestMapping(value = BUSINESS_LINE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return businessLineService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BUSINESS_LINE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
