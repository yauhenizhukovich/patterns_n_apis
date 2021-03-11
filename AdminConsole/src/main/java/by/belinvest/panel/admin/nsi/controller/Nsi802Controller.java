package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.nsi_802.Nsi802;
import by.belinvest.panel.admin.nsi.service.Nsi802Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/nsi_802")
public class Nsi802Controller {

    private static final String NSI_802_CREATE_URL = "/create";
    private static final String NSI_802_EDIT_URL = "/edit";
    private static final String NSI_802_REMOVE_URL = "/remove";
    private static final String NSI_802_DIRECTORY_GET_URL = "/nsi/nsi_802";

    private static final String NSI_802_DIMID_PARAMETER = "DIMID";
    private static final String NSI_802_PARENTID_PARAMETER = "PARENTID";
    private static final String NSI_802_CODE_PARAMETER = "CODE";
    private static final String NSI_802_NAME_PARAMETER = "NAME";
    private static final String NSI_802_NSI_802_PARAMETER = "NSI_812";


    private static final String NSI_802_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String NSI_802_PRIMARY_KEY = "DIMID";
    private static final String NSI_802_DOMAIN = "nsi_802";

    @Autowired
    private Nsi802Service nsi802Service;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(NSI_802_DIRECTORY_PARAMETER, nsi802Service.get());
        model.addAttribute("domain", NSI_802_DOMAIN);
        model.addAttribute("primaryKey", NSI_802_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = NSI_802_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = NSI_802_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = NSI_802_CODE_PARAMETER) String code,
                               @RequestParam(value = NSI_802_NAME_PARAMETER) String name,
                               @RequestParam(value = NSI_802_NSI_802_PARAMETER) String nsi812) {
        nsi802Service.create(Nsi802.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .nsi812(nsi812)
                .build()
        );
        return new RedirectView(request.getContextPath() + NSI_802_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = NSI_802_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return nsi802Service.update(Nsi802.fromJSON(data));
    }

    @RequestMapping(value = NSI_802_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return nsi802Service.remove(id);
    }

    private Map<String, String> getFieldsType() {
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(NSI_802_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_802_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_802_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_802_NSI_802_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
