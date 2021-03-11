package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.conditional_obligations.ConditionalObligations;
import by.belinvest.panel.admin.nsi.service.ConditionalObligationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/conditional_obligations")
public class ConditionalObligationsController {
    private static final String CONDITIONAL_OBLIGATIONS_CREATE_URL = "/create";
    private static final String CONDITIONAL_OBLIGATIONS_EDIT_URL = "/edit";
    private static final String CONDITIONAL_OBLIGATIONS_REMOVE_URL = "/remove";
    private static final String CONDITIONAL_OBLIGATIONS_DIRECTORY_GET_URL = "/nsi/conditional_obligations";

    private static final String CONDITIONAL_OBLIGATIONS_CODE_PARAMETER = "CODE";
    private static final String CONDITIONAL_OBLIGATIONS_NAME_PARAMETER = "NAME";

    private static final String CONDITIONAL_OBLIGATIONS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CONDITIONAL_OBLIGATIONS_PRIMARY_KEY = "CODE";
    private static final String CONDITIONAL_OBLIGATIONS_DOMAIN = "conditional_obligations";

    @Autowired
    private ConditionalObligationsService conditionalObligationsService;

    private String DIRECTORY_PAGE = "nsi/directory";;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CONDITIONAL_OBLIGATIONS_DIRECTORY_PARAMETER, conditionalObligationsService.get());
        model.addAttribute("domain",CONDITIONAL_OBLIGATIONS_DOMAIN);
        model.addAttribute("primaryKey",CONDITIONAL_OBLIGATIONS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CONDITIONAL_OBLIGATIONS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CONDITIONAL_OBLIGATIONS_NAME_PARAMETER) String name) {

        conditionalObligationsService.create(ConditionalObligations.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + CONDITIONAL_OBLIGATIONS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CONDITIONAL_OBLIGATIONS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return conditionalObligationsService.update(ConditionalObligations.fromJSON(data));
    }

    @RequestMapping(value = CONDITIONAL_OBLIGATIONS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return conditionalObligationsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CONDITIONAL_OBLIGATIONS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
