package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.exec_status.ExecStatus;
import by.belinvest.panel.admin.nsi.service.ExecStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/exec_status")
public class ExecStatusController {
    private static final String EXEC_STATUS_CREATE_URL = "/create";
    private static final String EXEC_STATUS_EDIT_URL = "/edit";
    private static final String EXEC_STATUS_REMOVE_URL = "/remove";
    private static final String EXEC_STATUS_DIRECTORY_GET_URL = "/nsi/exec_status";

    private static final String EXEC_STATUS_CODE_PARAMETER = "CODE";
    private static final String EXEC_STATUS_NAME_PARAMETER = "NAME";

    private static final String EXEC_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String EXEC_STATUS_PRIMARY_KEY = "CODE";
    private static final String EXEC_STATUS_DOMAIN = "exec_status";

    @Autowired
    private ExecStatusService execStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(EXEC_STATUS_DIRECTORY_PARAMETER, execStatusService.get());
        model.addAttribute("domain",EXEC_STATUS_DOMAIN);
        model.addAttribute("primaryKey",EXEC_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());

        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = EXEC_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = EXEC_STATUS_NAME_PARAMETER) String name) {

        execStatusService.create(ExecStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + EXEC_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = EXEC_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return execStatusService.update(ExecStatus.fromJSON(data));
    }

    @RequestMapping(value = EXEC_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return execStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(EXEC_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
