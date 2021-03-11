package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.obtaining_proc_method.ObtainingProcMethod;
import by.belinvest.panel.admin.nsi.service.ObtainingProcMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/obtaining_proc_method")
public class ObtainingProcMethodController {

    private static final String OBTAINING_PROC_METHOD_CREATE_URL = "/create";
    private static final String OBTAINING_PROC_METHOD_EDIT_URL = "/edit";
    private static final String OBTAINING_PROC_METHOD_REMOVE_URL = "/remove";
    private static final String OBTAINING_PROC_METHOD_DIRECTORY_GET_URL = "/nsi/obtaining_proc_method";

    private static final String OBTAINING_PROC_METHOD_ID_PARAMETER = "ID";
    private static final String OBTAINING_PROC_METHOD_NOTE_PARAMETER = "NOTE";
    private static final String OBTAINING_PROC_METHOD_CODE_PARAMETER = "CODE";
    private static final String OBTAINING_PROC_METHOD_NAME_PARAMETER = "NAME";

    private static final String OBTAINING_PROC_METHOD_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String OBTAINING_PROC_METHOD_PRIMARY_KEY = "ID";
    private static final String OBTAINING_PROC_METHOD_DOMAIN = "obtaining_proc_method";

    @Autowired
    private ObtainingProcMethodService service;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(OBTAINING_PROC_METHOD_DIRECTORY_PARAMETER, service.get());
        model.addAttribute("domain",OBTAINING_PROC_METHOD_DOMAIN);
        model.addAttribute("primaryKey",OBTAINING_PROC_METHOD_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = OBTAINING_PROC_METHOD_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = OBTAINING_PROC_METHOD_NOTE_PARAMETER) String note,
                               @RequestParam(value = OBTAINING_PROC_METHOD_CODE_PARAMETER) String code,
                               @RequestParam(value = OBTAINING_PROC_METHOD_NAME_PARAMETER) String name){

        service.create(ObtainingProcMethod.builder()
                .note(note)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + OBTAINING_PROC_METHOD_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = OBTAINING_PROC_METHOD_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return service.update(ObtainingProcMethod.fromJSON(data));
    }

    @RequestMapping(value = OBTAINING_PROC_METHOD_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return service.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(OBTAINING_PROC_METHOD_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(OBTAINING_PROC_METHOD_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(OBTAINING_PROC_METHOD_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
