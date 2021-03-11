package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.accstatus.AccStatus;
import by.belinvest.panel.admin.nsi.service.AccStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/acc_status")
public class AccStatusController {

    private static final String ACC_STATUS_CREATE_URL = "/create";
    private static final String ACC_STATUS_EDIT_URL = "/edit";
    private static final String ACC_STATUS_REMOVE_URL = "/remove";
    private static final String ACC_STATUS_DIRECTORY_GET_URL = "/nsi/acc_status";

    private static final String ACC_STATUS_CODE_PARAMETER = "CODE";
    private static final String ACC_STATUS_NAME_PARAMETER = "NAME";

    private static final String ACC_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String ACC_STATUS_PRIMARY_KEY = "CODE";
    private static final String ACC_STATUS_DOMAIN = "acc_status";

    @Autowired
    private AccStatusService accStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(ACC_STATUS_DIRECTORY_PARAMETER, accStatusService.get());
        model.addAttribute("domain",ACC_STATUS_DOMAIN);
        model.addAttribute("primaryKey",ACC_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
    return DIRECTORY_PAGE;
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DirectoryDTO getJson() {
        return accStatusService.get();
    }

    @RequestMapping(value = ACC_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                                        @RequestParam(value = ACC_STATUS_NAME_PARAMETER) String name) {

        accStatusService.create(AccStatus.builder()
                                .name(name)
                                .build()
        );
        return new RedirectView(request.getContextPath() + ACC_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = ACC_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return accStatusService.update(AccStatus.fromJSON(data));
    }

    @RequestMapping(value = ACC_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return accStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(ACC_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }

}
