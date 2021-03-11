package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.partial_issuance.PartialIssuance;
import by.belinvest.panel.admin.nsi.service.PartialIssuanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/partial_issuance")
public class PartialIssuanceController {

    private static final String PARTIAL_ISSUANCE_CREATE_URL = "/create";
    private static final String PARTIAL_ISSUANCE_EDIT_URL = "/edit";
    private static final String PARTIAL_ISSUANCE_REMOVE_URL = "/remove";
    private static final String PARTIAL_ISSUANCE_DIRECTORY_GET_URL = "/nsi/partial_issuance";

    private static final String PARTIAL_ISSUANCE_ID_PARAMETER = "ID";
    private static final String PARTIAL_ISSUANCE_NOTE_PARAMETER = "NOTE";
    private static final String PARTIAL_ISSUANCE_CODE_PARAMETER = "CODE";
    private static final String PARTIAL_ISSUANCE_NAME_PARAMETER = "NAME";

    private static final String PARTIAL_ISSUANCE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PARTIAL_ISSUANCE_PRIMARY_KEY = "ID";
    private static final String PARTIAL_ISSUANCE_DOMAIN = "partial_issuance";

    @Autowired
    private PartialIssuanceService partialIssuanceService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PARTIAL_ISSUANCE_DIRECTORY_PARAMETER, partialIssuanceService.get());
        model.addAttribute("domain",PARTIAL_ISSUANCE_DOMAIN);
        model.addAttribute("primaryKey",PARTIAL_ISSUANCE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PARTIAL_ISSUANCE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PARTIAL_ISSUANCE_NOTE_PARAMETER) String note,
                               @RequestParam(value = PARTIAL_ISSUANCE_CODE_PARAMETER) String code,
                               @RequestParam(value = PARTIAL_ISSUANCE_NAME_PARAMETER) String name){

        partialIssuanceService.create(PartialIssuance.builder()
                .note(note)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + PARTIAL_ISSUANCE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PARTIAL_ISSUANCE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return partialIssuanceService.update(PartialIssuance.fromJSON(data));
    }

    @RequestMapping(value = PARTIAL_ISSUANCE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return partialIssuanceService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PARTIAL_ISSUANCE_NOTE_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(PARTIAL_ISSUANCE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PARTIAL_ISSUANCE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
