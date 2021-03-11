package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.units.Units;
import by.belinvest.panel.admin.nsi.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/units")
public class UnitsController {

    private static final String UNITS_CREATE_URL = "/create";
    private static final String UNITS_EDIT_URL = "/edit";
    private static final String UNITS_REMOVE_URL = "/remove";
    private static final String UNITS_DIRECTORY_GET_URL = "/nsi/units";

    private static final String UNITS_DIMID_PARAMETER = "ID_UNIT";
    private static final String UNITS_UNIT_FULLNAME_PARAMETER = "UNIT_FULLNAME";
    private static final String UNITS_UNIT_NAME_PARAMETER = "UNIT_NAME";
    private static final String UNITS_IS_DEVELOPER_PARAMETER = "IS_DEVELOPER";
    private static final String UNITS_MANAGER_NAME_PARAMETER = "MANAGER_NAME";
    private static final String UNITS_MANAGER_POSITION_PARAMETER = "MANAGER_POSITION";
    private static final String UNITS_CURATOR_PARAMETER = "CURATOR";
    private static final String UNITS_SUPERIOR_UNIT_PARAMETER = "SUPERIOR_UNIT";

    private static final String UNITS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String UNITS_PRIMARY_KEY = "ID_UNIT";
    private static final String UNITS_DOMAIN = "units";

    @Autowired
    private UnitsService unitsService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(UNITS_DIRECTORY_PARAMETER, unitsService.get());
        model.addAttribute("domain",UNITS_DOMAIN);
        model.addAttribute("primaryKey",UNITS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = UNITS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = UNITS_UNIT_FULLNAME_PARAMETER) String unitFullName,
                               @RequestParam(value = UNITS_UNIT_NAME_PARAMETER) String unitName,
                               @RequestParam(value = UNITS_IS_DEVELOPER_PARAMETER) String isDeveloper,
                               @RequestParam(value = UNITS_MANAGER_NAME_PARAMETER) String managerName,
                               @RequestParam(value = UNITS_MANAGER_POSITION_PARAMETER) String managerPosition,
                               @RequestParam(value = UNITS_CURATOR_PARAMETER) String curator,
                               @RequestParam(value = UNITS_SUPERIOR_UNIT_PARAMETER) String superiorUnit) {

        unitsService.create(Units.builder()
                .unitFullName(unitFullName)
                .unitName(unitName)
                .isDeveloper(isDeveloper)
                .managerName(managerName)
                .managerPosition(managerPosition)
                .curator(curator)
                .superiorUnit(superiorUnit)
                .build()
        );
        return new RedirectView(request.getContextPath() + UNITS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = UNITS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return unitsService.update(Units.fromJSON(data));
    }

    @RequestMapping(value = UNITS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return unitsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(UNITS_UNIT_FULLNAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(UNITS_UNIT_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(UNITS_IS_DEVELOPER_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(UNITS_MANAGER_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(UNITS_MANAGER_POSITION_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(UNITS_CURATOR_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(UNITS_SUPERIOR_UNIT_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
