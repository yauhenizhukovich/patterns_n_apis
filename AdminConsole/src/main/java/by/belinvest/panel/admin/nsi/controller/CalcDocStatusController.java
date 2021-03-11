package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.calc_doc_status.CalcDocStatus;
import by.belinvest.panel.admin.nsi.service.CalcDocStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/calc_doc_status")
public class CalcDocStatusController {
    private static final String CALC_DOC_STATUS_CREATE_URL = "/create";
    private static final String CALC_DOC_STATUS_EDIT_URL = "/edit";
    private static final String CALC_DOC_STATUS_REMOVE_URL = "/remove";
    private static final String CALC_DOC_STATUS_DIRECTORY_GET_URL = "/nsi/calc_doc_status";

    private static final String CALC_DOC_STATUS_CODE_PARAMETER = "CODE";
    private static final String CALC_DOC_STATUS_NAME_PARAMETER = "NAME";

    private static final String CALC_DOC_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CALC_DOC_STATUS_PRIMARY_KEY = "CODE";
    private static final String CALC_DOC_STATUS_DOMAIN = "calc_doc_status";

    @Autowired
    private CalcDocStatusService calcDocStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CALC_DOC_STATUS_DIRECTORY_PARAMETER, calcDocStatusService.get());
        model.addAttribute("domain",CALC_DOC_STATUS_DOMAIN);
        model.addAttribute("primaryKey",CALC_DOC_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CALC_DOC_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CALC_DOC_STATUS_NAME_PARAMETER) String name) {

        calcDocStatusService.create(CalcDocStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + CALC_DOC_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CALC_DOC_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return calcDocStatusService.update(CalcDocStatus.fromJSON(data));
    }

    @RequestMapping(value = CALC_DOC_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return calcDocStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CALC_DOC_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
