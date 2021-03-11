package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.nsi_803.Nsi803;
import by.belinvest.panel.admin.nsi.service.Nsi803Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/nsi_803")
public class Nsi803Controller {

    private static final String NSI_803_CREATE_URL = "/create";
    private static final String NSI_803_EDIT_URL = "/edit";
    private static final String NSI_803_REMOVE_URL = "/remove";
    private static final String NSI_803_DIRECTORY_GET_URL = "/nsi/nsi_803";

    private static final String NSI_803_DIMID_PARAMETER = "DIMID";
    private static final String NSI_803_NAME_PARAMETER = "NAME";
    private static final String NSI_803_CODE_PARAMETER = "CODE";

    private static final String NSI_803_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String NSI_803_PRIMARY_KEY = "DIMID";
    private static final String NSI_803_DOMAIN = "nsi_803";

    @Autowired
    private Nsi803Service nsi803Service;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(NSI_803_DIRECTORY_PARAMETER, nsi803Service.get());
        model.addAttribute("domain",NSI_803_DOMAIN);
        model.addAttribute("primaryKey",NSI_803_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = NSI_803_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = NSI_803_NAME_PARAMETER) String name,
                               @RequestParam(value = NSI_803_CODE_PARAMETER) String code) {

        nsi803Service.create(Nsi803.builder()
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + NSI_803_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = NSI_803_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return nsi803Service.update(Nsi803.fromJSON(data));
    }

    @RequestMapping(value = NSI_803_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return nsi803Service.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(NSI_803_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_803_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
