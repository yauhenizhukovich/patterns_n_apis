package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.bp_status.BPStatus;
import by.belinvest.panel.admin.nsi.service.BPStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/bp_status")
public class BPStatusController {
    private static final String BP_STATUS_CREATE_URL = "/create";
    private static final String BP_STATUS_EDIT_URL = "/edit";
    private static final String BP_STATUS_REMOVE_URL = "/remove";
    private static final String BP_STATUS_DIRECTORY_GET_URL = "/nsi/bp_status";

    private static final String BP_STATUS_CODE_PARAMETER = "CODE";
    private static final String BP_STATUS_NAME_PARAMETER = "NAME";

    private static final String BP_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BP_STATUS_PRIMARY_KEY = "CODE";
    private static final String BP_STATUS_DOMAIN = "bp_status";

    @Autowired
    private BPStatusService bpStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(BP_STATUS_DIRECTORY_PARAMETER, bpStatusService.get());
        model.addAttribute("domain",BP_STATUS_DOMAIN);
        model.addAttribute("primaryKey",BP_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = BP_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BP_STATUS_NAME_PARAMETER) String name) {

        bpStatusService.create(BPStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + BP_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BP_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return bpStatusService.update(BPStatus.fromJSON(data));
    }

    @RequestMapping(value = BP_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return bpStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BP_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
