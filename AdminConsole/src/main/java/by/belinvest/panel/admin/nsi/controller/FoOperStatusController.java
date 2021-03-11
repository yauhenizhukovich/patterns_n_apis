package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.fo_oper_status.FoOperStatus;
import by.belinvest.panel.admin.nsi.service.FoOperStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/fo_oper_status")
public class FoOperStatusController {
    private static final String FO_OPER_STATUS_CREATE_URL = "/create";
    private static final String FO_OPER_STATUS_EDIT_URL = "/edit";
    private static final String FO_OPER_STATUS_REMOVE_URL = "/remove";
    private static final String FO_OPER_STATUS_DIRECTORY_GET_URL = "/nsi/fo_oper_status";

    private static final String FO_OPER_STATUS_CODE_PARAMETER = "CODE";
    private static final String FO_OPER_STATUS_NAME_PARAMETER = "NAME";

    private static final String FO_OPER_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String FO_OPER_STATUS_PRIMARY_KEY = "CODE";
    private static final String FO_OPER_STATUS_DOMAIN = "fo_oper_status";

    @Autowired
    private FoOperStatusService foOperStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(FO_OPER_STATUS_DIRECTORY_PARAMETER, foOperStatusService.get());
        model.addAttribute("domain",FO_OPER_STATUS_DOMAIN);
        model.addAttribute("primaryKey",FO_OPER_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = FO_OPER_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = FO_OPER_STATUS_NAME_PARAMETER) String name) {

        foOperStatusService.create(FoOperStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + FO_OPER_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = FO_OPER_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return foOperStatusService.update(FoOperStatus.fromJSON(data));
    }

    @RequestMapping(value = FO_OPER_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return foOperStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(FO_OPER_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
