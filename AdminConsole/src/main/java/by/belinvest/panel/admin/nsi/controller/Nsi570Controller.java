package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.nsi_570.Nsi570;
import by.belinvest.panel.admin.nsi.service.Nsi570Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/nsi_570")
public class Nsi570Controller {
    private static final String NSI_570_CREATE_URL = "/create";
    private static final String NSI_570_EDIT_URL = "/edit";
    private static final String NSI_570_REMOVE_URL = "/remove";
    private static final String NSI_570_DIRECTORY_GET_URL = "/nsi/nsi_570";

    private static final String INSI_570_ID_PARAMETER = "DIMID";
    private static final String NSI_570_NOTE_PARAMETER = "NOTE";
    private static final String NSI_570_CODE_PARAMETER = "CODE";
    private static final String NSI_570_NAME_PARAMETER = "NAME";

    private static final String NSI_570_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String NSI_570_PRIMARY_KEY = "DIMID";
    private static final String NSI_570_DOMAIN = "nsi_570";

    @Autowired
    private Nsi570Service nsi570Service;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(NSI_570_DIRECTORY_PARAMETER, nsi570Service.get());
        model.addAttribute("domain", NSI_570_DOMAIN);
        model.addAttribute("primaryKey", NSI_570_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = NSI_570_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = NSI_570_NOTE_PARAMETER) String note,
                               @RequestParam(value = NSI_570_CODE_PARAMETER) String code,
                               @RequestParam(value = NSI_570_NAME_PARAMETER) String name) {

        nsi570Service.create(Nsi570.builder()
                .note(note)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + NSI_570_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = NSI_570_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return nsi570Service.update(Nsi570.fromJSON(data));
    }

    @RequestMapping(value = NSI_570_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return nsi570Service.remove(id);
    }

    private Map<String, String> getFieldsType() {
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(NSI_570_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_570_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_570_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
