package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.work_type.WorkType;
import by.belinvest.panel.admin.nsi.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/work_type")
public class WorkTypeController {

    private static final String TYP_CR_CREATE_URL = "/create";
    private static final String TYP_CR_EDIT_URL = "/edit";
    private static final String TYP_CR_REMOVE_URL = "/remove";
    private static final String TYP_CR_DIRECTORY_GET_URL = "/nsi/work_type";

    private static final String TYP_CR_DIMID_PARAMETER = "DIMID";
    private static final String TYP_CR_NAME_PARAMETER = "NAME";
    private static final String TYP_CR_CODE_PARAMETER = "CODE";

    private static final String TYP_CR_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String TYP_CR_PRIMARY_KEY = "CODE";
    private static final String TYP_CR_DOMAIN = "work_type";

    @Autowired
    private WorkTypeService workTypeService;

    private String DIRECTORY_PAGE = "nsi/directory";;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(TYP_CR_DIRECTORY_PARAMETER, workTypeService.get());
        model.addAttribute("domain",TYP_CR_DOMAIN);
        model.addAttribute("primaryKey",TYP_CR_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = TYP_CR_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = TYP_CR_NAME_PARAMETER) String name) {

        workTypeService.create(WorkType.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + TYP_CR_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = TYP_CR_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return workTypeService.update(WorkType.fromJSON(data));
    }

    @RequestMapping(value = TYP_CR_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return workTypeService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(TYP_CR_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
