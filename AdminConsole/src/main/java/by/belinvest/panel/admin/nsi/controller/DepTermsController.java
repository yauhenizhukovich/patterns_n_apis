package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.dep_terms.DepTerms;
import by.belinvest.panel.admin.entity.nsi.depfl_terms.DepflTerms;
import by.belinvest.panel.admin.nsi.service.DepTermsService;
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
@RequestMapping(value = "/nsi/dep_terms")
public class DepTermsController {
    private static final String DEP_TERMS_CREATE_URL = "/create";
    private static final String DEP_TERMS_EDIT_URL = "/edit";
    private static final String DEP_TERMS_REMOVE_URL = "/remove";
    private static final String DEP_TERMS_DIRECTORY_GET_URL = "/nsi/dep_terms";

    private static final String DEP_TERMS_CODE_PARAMETER = "CODE";
    private static final String DEP_TERMS_NAME_PARAMETER = "NAME";

    private static final String DEP_TERMS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String DEP_TERMS_PRIMARY_KEY = "CODE";
    private static final String DEP_TERMS_DOMAIN = "dep_terms";

    @Autowired
    private DepTermsService depTermsService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(DEP_TERMS_DIRECTORY_PARAMETER, depTermsService.get());
        model.addAttribute("domain",DEP_TERMS_DOMAIN);
        model.addAttribute("primaryKey",DEP_TERMS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {
            depTermsService.create(DepTerms.builder()
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

    @RequestMapping(value = DEP_TERMS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return depTermsService.update(DepTerms.fromJSON(data));
    }

    @RequestMapping(value = DEP_TERMS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return depTermsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(DEP_TERMS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
