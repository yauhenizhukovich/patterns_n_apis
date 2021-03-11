package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.cd_doc_status.CdDocStatus;
import by.belinvest.panel.admin.nsi.service.CdDocStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/cd_doc_status")
public class CdDocStatusController {

    private static final String CD_DOC_STATUS_CREATE_URL = "/create";
    private static final String CD_DOC_STATUS_EDIT_URL = "/edit";
    private static final String CD_DOC_STATUS_REMOVE_URL = "/remove";
    private static final String CD_DOC_STATUS_DIRECTORY_GET_URL = "/nsi/cd_doc_status";

    private static final String CD_DOC_STATUS_CODE_PARAMETER = "CODE";
    private static final String CD_DOC_STATUS_NAME_PARAMETER = "NAME";

    private static final String CD_DOC_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CD_DOC_STATUS_PRIMARY_KEY = "CODE";
    private static final String CD_DOC_STATUS_DOMAIN = "cd_doc_status";

    @Autowired
    private CdDocStatusService cdDocStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CD_DOC_STATUS_DIRECTORY_PARAMETER, cdDocStatusService.get());
        model.addAttribute("domain",CD_DOC_STATUS_DOMAIN);
        model.addAttribute("primaryKey",CD_DOC_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CD_DOC_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CD_DOC_STATUS_NAME_PARAMETER) String name) {

        cdDocStatusService.create(CdDocStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + CD_DOC_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CD_DOC_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return cdDocStatusService.update(CdDocStatus.fromJSON(data));
    }

    @RequestMapping(value = CD_DOC_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return cdDocStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CD_DOC_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
