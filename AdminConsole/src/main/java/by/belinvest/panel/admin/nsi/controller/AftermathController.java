package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.aftermath.Aftermath;
import by.belinvest.panel.admin.entity.nsi.prospects.Prospects;
import by.belinvest.panel.admin.nsi.service.AftermathService;
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
@RequestMapping(value = "/nsi/aftermath")
public class AftermathController {

    private static final String AFTERMATH_CREATE_URL = "/create";
    private static final String AFTERMATH_EDIT_URL = "/edit";
    private static final String AFTERMATH_REMOVE_URL = "/remove";
    private static final String AFTERMATH_GET_URL = "/nsi/aftermath";

    private static final String ID_AFTERMATH_PARAMETER = "ID_AFTERMATH";
    private static final String AFTERMATH_NAME_PARAMETER = "AFTERMATH_NAME";
    private static final String AFTERMATH_DESC_PARAMETER = "AFTERMATH_DESC";

    private static final String AFTERMATH_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String AFTERMATH_PRIMARY_KEY = "ID_AFTERMATH";
    private static final String AFTERMATH_DOMAIN = "aftermath";

    @Autowired
    private AftermathService aftermathService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(AFTERMATH_DIRECTORY_PARAMETER, aftermathService.get());
        model.addAttribute("domain",AFTERMATH_DOMAIN);
        model.addAttribute("primaryKey",AFTERMATH_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
     return DIRECTORY_PAGE;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {
            aftermathService.create(Aftermath.builder()
                    .aftermathName(map.get("name"))
                    .aftermathDesc(map.get("desc"))
                    .build());
        }catch (Exception e){
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.ok().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = AFTERMATH_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return aftermathService.update(Aftermath.fromJSON(data));
    }

    @RequestMapping(value = AFTERMATH_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return aftermathService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(AFTERMATH_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(AFTERMATH_DESC_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
