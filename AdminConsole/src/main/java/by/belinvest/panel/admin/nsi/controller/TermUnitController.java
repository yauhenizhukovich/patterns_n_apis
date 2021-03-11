package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.term_unit.TermUnit;
import by.belinvest.panel.admin.nsi.service.TermUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/term_unit")
public class TermUnitController {
    private static final String TERM_UNIT_CREATE_URL = "/create";
    private static final String TERM_UNIT_EDIT_URL = "/edit";
    private static final String TERM_UNIT_REMOVE_URL = "/remove";
    private static final String TERM_UNIT_DIRECTORY_GET_URL = "/nsi/term_unit";

    private static final String TERM_UNIT_DIMID_PARAMETER = "DIMID";
    private static final String TERM_UNIT_CODE_PARAMETER = "CODE";
    private static final String TERM_UNIT_NAME_PARAMETER = "NAME";
    private static final String TERM_UNIT_NOTE_PARAMETER = "NOTE";

    private static final String TERM_UNIT_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String TERM_UNIT_PRIMARY_KEY = "ID";
    private static final String TERM_UNIT_DOMAIN = "term_unit";

    @Autowired
    private TermUnitService termUnitService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(TERM_UNIT_DIRECTORY_PARAMETER, termUnitService.get());
        model.addAttribute("domain", TERM_UNIT_DOMAIN);
        model.addAttribute("primaryKey", TERM_UNIT_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = TERM_UNIT_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = TERM_UNIT_CODE_PARAMETER) String code,
                               @RequestParam(value = TERM_UNIT_NAME_PARAMETER) String name,
                               @RequestParam(value = TERM_UNIT_NOTE_PARAMETER) String note) {
        System.out.println(code+" "+name+" "+note);
        termUnitService.create(TermUnit.builder()
                .code(code)
                .name(name)
                .note(note)
                .build()
        );
        return new RedirectView(request.getContextPath() + TERM_UNIT_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = TERM_UNIT_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return termUnitService.update(TermUnit.fromJSON(data));
    }

    @RequestMapping(value = TERM_UNIT_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return termUnitService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(TERM_UNIT_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(TERM_UNIT_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(TERM_UNIT_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
