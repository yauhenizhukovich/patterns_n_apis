package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.pd_doc_status.PdDocStatus;
import by.belinvest.panel.admin.nsi.service.PdDocStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/pd_doc_status")
public class PdDocStatusController {

    private static final String PD_DOC_STATUS_CREATE_URL = "/create";
    private static final String PD_DOC_STATUS_EDIT_URL = "/edit";
    private static final String PD_DOC_STATUS_REMOVE_URL = "/remove";
    private static final String PD_DOC_STATUS_DIRECTORY_GET_URL = "/nsi/pd_doc_status";

    private static final String PD_DOC_STATUS_CODE_PARAMETER = "CODE";
    private static final String PD_DOC_STATUS_NAME_PARAMETER = "NAME";

    private static final String PD_DOC_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PD_DOC_STATUS_PRIMARY_KEY = "CODE";
    private static final String PD_DOC_STATUS_DOMAIN = "pd_doc_status";

    @Autowired
    private PdDocStatusService pdDocStatusService;


    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PD_DOC_STATUS_DIRECTORY_PARAMETER, pdDocStatusService.get());
        model.addAttribute("domain", PD_DOC_STATUS_DOMAIN);
        model.addAttribute("primaryKey", PD_DOC_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PD_DOC_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PD_DOC_STATUS_NAME_PARAMETER) String name) {

        pdDocStatusService.create(PdDocStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + PD_DOC_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PD_DOC_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return pdDocStatusService.update(PdDocStatus.fromJSON(data));
    }

    @RequestMapping(value = PD_DOC_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return pdDocStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PD_DOC_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
