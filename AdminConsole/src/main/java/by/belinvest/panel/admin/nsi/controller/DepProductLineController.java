package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.dep_product_line.DepProductLine;
import by.belinvest.panel.admin.nsi.service.DepProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/dep_product_line")
public class DepProductLineController {
    private static final String DEP_PRODUCT_LINE_CREATE_URL = "/create";
    private static final String DEP_PRODUCT_LINE_EDIT_URL = "/edit";
    private static final String DEP_PRODUCT_LINE_REMOVE_URL = "/remove";
    private static final String DEP_PRODUCT_LINE_DIRECTORY_GET_URL = "/nsi/dep_product_line";

    private static final String DEP_PRODUCT_LINE_CODE_PARAMETER = "CODE";
    private static final String DEP_PRODUCT_LINE_NAME_PARAMETER = "NAME";

    private static final String DEP_PRODUCT_LINE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String DEP_PRODUCT_LINE_PRIMARY_KEY = "CODE";
    private static final String DEP_PRODUCT_LINE_DOMAIN = "dep_product_line";

    @Autowired
    private DepProductLineService depProductLineService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(DEP_PRODUCT_LINE_DIRECTORY_PARAMETER, depProductLineService.get());
        model.addAttribute("domain",DEP_PRODUCT_LINE_DOMAIN);
        model.addAttribute("primaryKey",DEP_PRODUCT_LINE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = DEP_PRODUCT_LINE_CREATE_URL, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {
            depProductLineService.create(DepProductLine.builder()
                            .name(map.get("name"))
                            .build(),
                    map.get("textarea")
            );
        }catch (Exception e){
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.ok().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = DEP_PRODUCT_LINE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return depProductLineService.update(DepProductLine.fromJSON(data));
    }

    @RequestMapping(value = DEP_PRODUCT_LINE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return depProductLineService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(DEP_PRODUCT_LINE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
