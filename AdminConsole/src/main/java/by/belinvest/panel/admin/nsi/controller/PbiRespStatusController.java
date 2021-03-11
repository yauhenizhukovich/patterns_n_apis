package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.pbi_resp_status.PbiRespStatus;
import by.belinvest.panel.admin.nsi.service.PbiRespStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/pbi_resp_status")
public class PbiRespStatusController {
    private static final String PBI_RESP_STATUS_CREATE_URL = "/create";
    private static final String PBI_RESP_STATUS_EDIT_URL = "/edit";
    private static final String PBI_RESP_STATUS_REMOVE_URL = "/remove";
    private static final String PBI_RESP_STATUS_DIRECTORY_GET_URL = "/nsi/pbi_resp_status";

    private static final String PBI_RESP_STATUS_CODE_PARAMETER = "CODE";
    private static final String PBI_RESP_STATUS_NAME_PARAMETER = "NAME";

    private static final String PBI_RESP_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PBI_RESP_STATUS_PRIMARY_KEY = "CODE";
    private static final String PBI_RESP_STATUS_DOMAIN = "pbi_resp_status";

    @Autowired
    private PbiRespStatusService pbiRespStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PBI_RESP_STATUS_DIRECTORY_PARAMETER, pbiRespStatusService.get());
        model.addAttribute("domain", PBI_RESP_STATUS_DOMAIN);
        model.addAttribute("primaryKey", PBI_RESP_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PBI_RESP_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PBI_RESP_STATUS_NAME_PARAMETER) String name) {

        pbiRespStatusService.create(PbiRespStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + PBI_RESP_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PBI_RESP_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return pbiRespStatusService.update(PbiRespStatus.fromJSON(data));
    }

    @RequestMapping(value = PBI_RESP_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return pbiRespStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PBI_RESP_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }

}
