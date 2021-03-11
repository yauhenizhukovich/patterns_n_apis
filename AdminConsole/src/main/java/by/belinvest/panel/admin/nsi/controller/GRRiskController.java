package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.gr_risk.GRRisk;
import by.belinvest.panel.admin.nsi.service.GRRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/gr_risk")
public class GRRiskController {
    private static final String GR_RISK_CREATE_URL = "/create";
    private static final String GR_RISK_EDIT_URL = "/edit";
    private static final String GR_RISK_REMOVE_URL = "/remove";
    private static final String GR_RISK_DIRECTORY_GET_URL = "/nsi/gr_risk";

    private static final String GR_RISK_DIMID_PARAMETER = "DIMID";
    private static final String GR_RISK_NAME_PARAMETER = "NAME";
    private static final String GR_RISK_CODE_PARAMETER = "CODE";

    private static final String GR_RISK_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String GR_RISK_PRIMARY_KEY = "DIMID";
    private static final String GR_RISK_DOMAIN = "gr_risk";

    @Autowired
    private GRRiskService grRiskService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(GR_RISK_DIRECTORY_PARAMETER, grRiskService.get());
        model.addAttribute("domain",GR_RISK_DOMAIN);
        model.addAttribute("primaryKey",GR_RISK_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = GR_RISK_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = GR_RISK_NAME_PARAMETER) String name,
                               @RequestParam(value = GR_RISK_CODE_PARAMETER) String code) {

        grRiskService.create(GRRisk.builder()
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + GR_RISK_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = GR_RISK_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return grRiskService.update(GRRisk.fromJSON(data));
    }

    @RequestMapping(value = GR_RISK_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return grRiskService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(GR_RISK_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(GR_RISK_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
