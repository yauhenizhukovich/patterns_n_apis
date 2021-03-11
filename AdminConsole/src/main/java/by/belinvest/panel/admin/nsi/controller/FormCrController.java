package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.form_cr.FormCr;
import by.belinvest.panel.admin.nsi.service.FormCrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/form_cr")
public class FormCrController {
    private static final String FORM_CR_CREATE_URL = "/create";
    private static final String FORM_CR_EDIT_URL = "/edit";
    private static final String FORM_CR_REMOVE_URL = "/remove";
    private static final String FORM_CR_DIRECTORY_GET_URL = "/nsi/form_cr";

    private static final String FORM_CR_DIMID_PARAMETER = "DIMID";
    private static final String FORM_CR_CODE_PARAMETER = "CODE";
    private static final String FORM_CR_NAME_PARAMETER = "NAME";
    private static final String FORM_CR_KR_VID_SDELKI_PARAMETER = "KR_VID_SDELKI";


    private static final String FORM_CR_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String FORM_CR_PRIMARY_KEY = "DIMID";
    private static final String FORM_CR_DOMAIN = "form_cr";

    @Autowired
    private FormCrService formCrService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(FORM_CR_DIRECTORY_PARAMETER, formCrService.get());
        model.addAttribute("domain", FORM_CR_DOMAIN);
        model.addAttribute("primaryKey", FORM_CR_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = FORM_CR_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = FORM_CR_CODE_PARAMETER) String code,
                               @RequestParam(value = FORM_CR_NAME_PARAMETER) String name,
                               @RequestParam(value = FORM_CR_KR_VID_SDELKI_PARAMETER) String krVidSdelki) {

        formCrService.create(FormCr.builder()
                .code(code)
                .name(name)
                .krVidSdelki(krVidSdelki)
                .build()
        );
        return new RedirectView(request.getContextPath() + FORM_CR_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = FORM_CR_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return formCrService.update(FormCr.fromJSON(data));
    }

    @RequestMapping(value = FORM_CR_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return formCrService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(FORM_CR_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(FORM_CR_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(FORM_CR_KR_VID_SDELKI_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
