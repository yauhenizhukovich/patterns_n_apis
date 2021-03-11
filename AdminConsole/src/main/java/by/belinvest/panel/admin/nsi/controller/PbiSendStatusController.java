package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.pbi_send_status.PbiSendStatus;
import by.belinvest.panel.admin.nsi.service.PbiSendStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/pbi_send_status")
public class PbiSendStatusController {
    private static final String PBI_SEND_STATUS_CREATE_URL = "/create";
    private static final String PBI_SEND_STATUS_EDIT_URL = "/edit";
    private static final String PBI_SEND_STATUS_REMOVE_URL = "/remove";
    private static final String PBI_SEND_STATUS_DIRECTORY_GET_URL = "/nsi/pbi_send_status";

    private static final String PBI_SEND_STATUS_CODE_PARAMETER = "CODE";
    private static final String PBI_SEND_STATUS_NAME_PARAMETER = "NAME";

    private static final String PBI_SEND_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PBI_SEND_STATUS_PRIMARY_KEY = "CODE";
    private static final String PBI_SEND_STATUS_DOMAIN = "pbi_send_status";

    @Autowired
    private PbiSendStatusService pbiSendStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PBI_SEND_STATUS_DIRECTORY_PARAMETER, pbiSendStatusService.get());
        model.addAttribute("domain", PBI_SEND_STATUS_DOMAIN);
        model.addAttribute("primaryKey", PBI_SEND_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PBI_SEND_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PBI_SEND_STATUS_NAME_PARAMETER) String name) {

        pbiSendStatusService.create(PbiSendStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + PBI_SEND_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PBI_SEND_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return pbiSendStatusService.update(PbiSendStatus.fromJSON(data));
    }

    @RequestMapping(value = PBI_SEND_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return pbiSendStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PBI_SEND_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
