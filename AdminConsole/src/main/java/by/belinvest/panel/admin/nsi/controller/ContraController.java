package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.contra.Contra;
import by.belinvest.panel.admin.nsi.service.ContraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/contra")
public class ContraController {
    private static final String CONTRA_CREATE_URL = "/create";
    private static final String CONTRA_EDIT_URL = "/edit";
    private static final String CONTRA_REMOVE_URL = "/remove";
    private static final String CONTRA_DIRECTORY_GET_URL = "/nsi/contra";

    private static final String CONTRA_DIMID_PARAMETER = "DIMID";
    private static final String CONTRA_PARENTID_PARAMETER = "PARENTID";
    private static final String CONTRA_CODE_PARAMETER = "CODE";
    private static final String CONTRA_NAME_PARAMETER = "NAME";
    private static final String CONTRA_NSI_010_CONTRA_PARAMETER = "NSI_010_CONTRA";


    private static final String CONTRA_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CONTRA_PRIMARY_KEY = "DIMID";
    private static final String CONTRA_DOMAIN = "contra";

    @Autowired
    private ContraService contraService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CONTRA_DIRECTORY_PARAMETER, contraService.get());
        model.addAttribute("domain",CONTRA_DOMAIN);
        model.addAttribute("primaryKey",CONTRA_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CONTRA_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CONTRA_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = CONTRA_CODE_PARAMETER) String code,
                               @RequestParam(value = CONTRA_NAME_PARAMETER) String name,
                               @RequestParam(value = CONTRA_NSI_010_CONTRA_PARAMETER) String nsi010contra) {

        contraService.create(Contra.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .nsi010contra(nsi010contra)
                .build()
        );
        return new RedirectView(request.getContextPath() + CONTRA_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CONTRA_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return contraService.update(Contra.fromJSON(data));
    }

    @RequestMapping(value = CONTRA_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return contraService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CONTRA_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CONTRA_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CONTRA_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CONTRA_NSI_010_CONTRA_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
