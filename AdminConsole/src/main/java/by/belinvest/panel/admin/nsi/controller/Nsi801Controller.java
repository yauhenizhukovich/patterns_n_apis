package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.nsi_801.Nsi801;
import by.belinvest.panel.admin.nsi.service.Nsi801Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/nsi_801")
public class Nsi801Controller {

    private static final String NSI_801_CREATE_URL = "/create";
    private static final String NSI_801_EDIT_URL = "/edit";
    private static final String NSI_801_REMOVE_URL = "/remove";
    private static final String NSI_801_DIRECTORY_GET_URL = "/nsi/nsi_801";

    private static final String NSI_801_DIMID_PARAMETER = "DIMID";
    private static final String NSI_801_PARENTID_PARAMETER = "PARENTID";
    private static final String NSI_801_CODE_PARAMETER = "CODE";
    private static final String NSI_801_NAME_PARAMETER = "NAME";
    private static final String NSI_801_LGOTNOST_SIGN_PARAMETER = "LGOTNOST_SIGN";
    private static final String NSI_801_REFER_INVEST_PARAMETER = "REFER_INVEST";
    private static final String NSI_801_GOSMEROPRIATIA_PARAMETER = "GOSMEROPRIATIA";


    private static final String NSI_801_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String NSI_801_PRIMARY_KEY = "DIMID";
    private static final String NSI_801_DOMAIN = "nsi_801";

    @Autowired
    private Nsi801Service nsi801Service;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(NSI_801_DIRECTORY_PARAMETER, nsi801Service.get());
        model.addAttribute("domain",NSI_801_DOMAIN);
        model.addAttribute("primaryKey",NSI_801_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = NSI_801_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = NSI_801_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = NSI_801_CODE_PARAMETER) String code,
                               @RequestParam(value = NSI_801_NAME_PARAMETER) String name,
                               @RequestParam(value = NSI_801_LGOTNOST_SIGN_PARAMETER) String lgotnostSign,
                               @RequestParam(value = NSI_801_REFER_INVEST_PARAMETER) String referInvest,
                               @RequestParam(value = NSI_801_GOSMEROPRIATIA_PARAMETER) String gosmeropriatia) {

        nsi801Service.create(Nsi801.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .lgotnostSign(lgotnostSign)
                .referInvest(referInvest)
                .gosmeropriatia(gosmeropriatia)
                .build()
        );
        return new RedirectView(request.getContextPath() + NSI_801_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = NSI_801_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return nsi801Service.update(Nsi801.fromJSON(data));
    }

    @RequestMapping(value = NSI_801_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return nsi801Service.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(NSI_801_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_801_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_801_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_801_LGOTNOST_SIGN_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(NSI_801_REFER_INVEST_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_801_GOSMEROPRIATIA_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
