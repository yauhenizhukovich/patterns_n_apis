package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.prospects.Prospects;
import by.belinvest.panel.admin.entity.nsi.risks.Risks;
import by.belinvest.panel.admin.nsi.service.RisksService;
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
@RequestMapping(value = "/nsi/risks")
public class RisksController {
    private static final String RISKS_CREATE_URL = "/create";
    private static final String RISKS_EDIT_URL = "/edit";
    private static final String RISKS_REMOVE_URL = "/remove";
    private static final String RISKS_DIRECTORY_GET_URL = "/nsi/risks";

    private static final String ID_RISK_PARAMETER = "ID_RISK";
    private static final String RISK_NAME_PARAMETER = "RISK_NAME";
    private static final String RISK_DESCRIPTION_PARAMETER = "DESCRIPTION";

    private static final String RISKS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String RISKS_PRIMARY_KEY = "ID_RISK";
    private static final String RISKS_DOMAIN = "risks";

    @Autowired
    private RisksService risksService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(RISKS_DIRECTORY_PARAMETER, risksService.get());
        model.addAttribute("domain", RISKS_DOMAIN);
        model.addAttribute("primaryKey", RISKS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {
            risksService.create(Risks.builder()
                    .riskName(map.get("name"))
                    .description(map.get("desc"))
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

    @RequestMapping(value = RISKS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return risksService.update(Risks.fromJSON(data));
    }

    @RequestMapping(value = RISKS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return risksService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(RISK_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(RISK_DESCRIPTION_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
