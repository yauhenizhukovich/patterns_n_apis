package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.bl_residency.BLResidency;
import by.belinvest.panel.admin.nsi.service.BLResidencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/nsi/bl_residency")
public class BLResidencyController {

    private static final String BL_RESIDENCY_CREATE_URL = "/create";
    private static final String BL_RESIDENCY_EDIT_URL = "/edit";
    private static final String BL_RESIDENCY_REMOVE_URL = "/remove";
    private static final String BL_RESIDENCY_DIRECTORY_GET_URL = "/nsi/bl_residency";

    private static final String BL_RESIDENCY_CODE_PARAMETER = "CODE";
    private static final String BL_RESIDENCY_NAME_PARAMETER = "NAME";

    private static final String BL_RESIDENCY_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BL_RESIDENCY_PRIMARY_KEY = "CODE";
    private static final String BL_RESIDENCY_DOMAIN = "bl_residency";

    @Autowired
    private BLResidencyService blResidencyService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(BL_RESIDENCY_DIRECTORY_PARAMETER, blResidencyService.get());
        model.addAttribute("domain", BL_RESIDENCY_DOMAIN);
        model.addAttribute("primaryKey", BL_RESIDENCY_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = BL_RESIDENCY_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BL_RESIDENCY_NAME_PARAMETER) String name) {

        blResidencyService.create(BLResidency.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + BL_RESIDENCY_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BL_RESIDENCY_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return blResidencyService.update(BLResidency.fromJSON(data));
    }

    @RequestMapping(value = BL_RESIDENCY_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return blResidencyService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BL_RESIDENCY_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
