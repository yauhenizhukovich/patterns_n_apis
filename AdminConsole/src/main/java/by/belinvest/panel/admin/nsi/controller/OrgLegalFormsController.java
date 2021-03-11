package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.org_legal_forms.OrgLegalForms;
import by.belinvest.panel.admin.nsi.service.OrgLegalFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/org_legal_forms")
public class OrgLegalFormsController {
    private static final String ORG_LEGAL_FORMS_CREATE_URL = "/create";
    private static final String ORG_LEGAL_FORMS_EDIT_URL = "/edit";
    private static final String ORG_LEGAL_FORMS_REMOVE_URL = "/remove";
    private static final String ORG_LEGAL_FORMS_DIRECTORY_GET_URL = "/nsi/org_legal_forms";

    private static final String ORG_LEGAL_FORMS_DIMID_PARAMETER = "DIMID";
    private static final String ORG_LEGAL_FORMS_NAME_PARAMETER = "NAME";
    private static final String ORG_LEGAL_FORMS_CODE_PARAMETER = "CODE";

    private static final String ORG_LEGAL_FORMS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String ORG_LEGAL_FORMS_PRIMARY_KEY = "DIMID";
    private static final String ORG_LEGAL_FORMS_DOMAIN = "org_legal_forms";

    @Autowired
    private OrgLegalFormsService orgLegalFormsService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(ORG_LEGAL_FORMS_DIRECTORY_PARAMETER, orgLegalFormsService.get());
        model.addAttribute("domain", ORG_LEGAL_FORMS_DOMAIN);
        model.addAttribute("primaryKey", ORG_LEGAL_FORMS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = ORG_LEGAL_FORMS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = ORG_LEGAL_FORMS_NAME_PARAMETER) String name,
                               @RequestParam(value = ORG_LEGAL_FORMS_CODE_PARAMETER) String code) {

        orgLegalFormsService.create(OrgLegalForms.builder()
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + ORG_LEGAL_FORMS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = ORG_LEGAL_FORMS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return orgLegalFormsService.update(OrgLegalForms.fromJSON(data));
    }

    @RequestMapping(value = ORG_LEGAL_FORMS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return orgLegalFormsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(ORG_LEGAL_FORMS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(ORG_LEGAL_FORMS_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
