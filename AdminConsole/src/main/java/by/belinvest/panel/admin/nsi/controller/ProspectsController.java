package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.dep_currency.DepCurrency;
import by.belinvest.panel.admin.entity.nsi.prospects.Prospects;
import by.belinvest.panel.admin.nsi.service.ProspectsService;
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
@RequestMapping(value = "/nsi/prospects")
public class ProspectsController {
    private static final String PROSPECTS_CREATE_URL = "/create";
    private static final String PROSPECTS_EDIT_URL = "/edit";
    private static final String PROSPECTS_REMOVE_URL = "/remove";
    private static final String PROSPECTS_DIRECTORY_GET_URL = "/nsi/prospects";

    private static final String PROSPECTS_ID_PROSPECTS_PARAMETER = "ID_PROSPECTS";
    private static final String PROSPECTS_PROSPECTS_NAME_PARAMETER = "PROSPECTS_NAME";
    private static final String PROSPECTS_PROSPECTS_DESC_PARAMETER = "PROSPECTS_DESC";

    private static final String PROSPECTS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PROSPECTS_PRIMARY_KEY = "ID_PROSPECTS";
    private static final String PROSPECTS_DOMAIN = "prospects";

    @Autowired
    private ProspectsService prospectsService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PROSPECTS_DIRECTORY_PARAMETER, prospectsService.get());
        model.addAttribute("domain", PROSPECTS_DOMAIN);
        model.addAttribute("primaryKey", PROSPECTS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {

            prospectsService.create(Prospects.builder()
                    .prospectsName(map.get("name"))
                    .prospectsDesc(map.get("desc"))
                    .build());

        }catch (Exception e){
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.ok().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = PROSPECTS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return prospectsService.update(Prospects.fromJSON(data));
    }

    @RequestMapping(value = PROSPECTS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return prospectsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PROSPECTS_PROSPECTS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROSPECTS_PROSPECTS_DESC_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
