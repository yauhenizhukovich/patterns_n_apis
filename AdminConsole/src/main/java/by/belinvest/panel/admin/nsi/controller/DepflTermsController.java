package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.dep_currency.DepCurrency;
import by.belinvest.panel.admin.entity.nsi.dep_terms.DepTerms;
import by.belinvest.panel.admin.entity.nsi.depfl_terms.DepflTerms;
import by.belinvest.panel.admin.nsi.service.DepTermsService;
import by.belinvest.panel.admin.nsi.service.DepflTermsService;
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
@RequestMapping(value = "/nsi/depfl_terms")
public class DepflTermsController {
    private static final String DEPFL_TERMS_CREATE_URL = "/create";
    private static final String DEPFL_TERMS_EDIT_URL = "/edit";
    private static final String DEPFL_TERMS_REMOVE_URL = "/remove";
    private static final String DEPFL_TERMS_DIRECTORY_GET_URL = "/nsi/depfl_terms";

    private static final String DEPFL_TERMS_CODE_PARAMETER = "CODE";
    private static final String DEPFL_TERMS_NAME_PARAMETER = "NAME";

    private static final String DEPFL_TERMS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String DEPFL_TERMS_PRIMARY_KEY = "CODE";
    private static final String DEPFL_TERMS_DOMAIN = "depfl_terms";

    @Autowired
    private DepflTermsService depflTermsService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(DEPFL_TERMS_DIRECTORY_PARAMETER, depflTermsService.get());
        model.addAttribute("domain",DEPFL_TERMS_DOMAIN);
        model.addAttribute("primaryKey",DEPFL_TERMS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {
            depflTermsService.create(DepflTerms.builder()
                    .name(map.get("name"))
                    .build()
            );
        }catch (Exception e){
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.ok().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = DEPFL_TERMS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return depflTermsService.update(DepflTerms.fromJSON(data));
    }

    @RequestMapping(value = DEPFL_TERMS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return depflTermsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(DEPFL_TERMS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
