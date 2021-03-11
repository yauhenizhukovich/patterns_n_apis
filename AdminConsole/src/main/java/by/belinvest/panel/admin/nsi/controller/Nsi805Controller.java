package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.nsi_805.Nsi805;
import by.belinvest.panel.admin.nsi.service.Nsi805Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/nsi_805")
public class Nsi805Controller {

    private static final String NSI_805_CREATE_URL = "/create";
    private static final String NSI_805_EDIT_URL = "/edit";
    private static final String NSI_805_REMOVE_URL = "/remove";
    private static final String NSI_805_DIRECTORY_GET_URL = "/nsi/nsi_805";

    private static final String NSI_805_DIMID_PARAMETER = "DIMID";
    private static final String NSI_805_PARENTID_PARAMETER = "PARENTID";
    private static final String NSI_805_CODE_PARAMETER = "CODE";
    private static final String NSI_805_NAME_PARAMETER = "NAME";
    private static final String NSI_805_KR_VID_SDELKI_805_PARAMETER = "KR_VID_SDELKI_805";
    private static final String NSI_805_KR_OBESP_805_PARAMETER = "KR_OBESP_805";


    private static final String NSI_805_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String NSI_805_PRIMARY_KEY = "DIMID";
    private static final String NSI_805_DOMAIN = "nsi_805";

    @Autowired
    private Nsi805Service nsi805Service;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(NSI_805_DIRECTORY_PARAMETER, nsi805Service.get());
        model.addAttribute("domain",NSI_805_DOMAIN);
        model.addAttribute("primaryKey",NSI_805_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = NSI_805_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = NSI_805_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = NSI_805_CODE_PARAMETER) String code,
                               @RequestParam(value = NSI_805_NAME_PARAMETER) String name,
                               @RequestParam(value = NSI_805_KR_VID_SDELKI_805_PARAMETER) String krVidSdelki805,
                               @RequestParam(value = NSI_805_KR_OBESP_805_PARAMETER) String krObesp805) {

        nsi805Service.create(Nsi805.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .krVidSdelki805(krVidSdelki805)
                .krObesp805(krObesp805)
                .build()
        );
        return new RedirectView(request.getContextPath() + NSI_805_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = NSI_805_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return nsi805Service.update(Nsi805.fromJSON(data));
    }

    @RequestMapping(value = NSI_805_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return nsi805Service.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(NSI_805_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_805_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_805_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_805_KR_VID_SDELKI_805_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_805_KR_OBESP_805_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
