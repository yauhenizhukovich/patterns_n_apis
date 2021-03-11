package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.bpc_applid.BPCAppLid;
import by.belinvest.panel.admin.nsi.service.BPCAppLidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/bpc_applid")
public class BPCAppLidController {
    private static final String BPC_APPLID_CREATE_URL = "/create";
    private static final String BPC_APPLID_EDIT_URL = "/edit";
    private static final String BPC_APPLID_REMOVE_URL = "/remove";
    private static final String BPC_APPLID_DIRECTORY_GET_URL = "/nsi/bpc_applid";

    private static final String BPC_APPLID_DIMID_PARAMETER = "DIMID";
    private static final String BPC_APPLID_NAME_PARAMETER = "NAME";
    private static final String BPC_APPLID_CODE_PARAMETER = "CODE";

    private static final String BPC_APPLID_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BPC_APPLID_PRIMARY_KEY = "DIMID";
    private static final String BPC_APPLID_DOMAIN = "bpc_applid";

    @Autowired
    private BPCAppLidService bpcAppLidService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(BPC_APPLID_DIRECTORY_PARAMETER, bpcAppLidService.get());
        model.addAttribute("domain",BPC_APPLID_DOMAIN);
        model.addAttribute("primaryKey",BPC_APPLID_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = BPC_APPLID_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BPC_APPLID_NAME_PARAMETER) String name,
                               @RequestParam(value = BPC_APPLID_CODE_PARAMETER) String code) {

        bpcAppLidService.create(BPCAppLid.builder()
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + BPC_APPLID_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BPC_APPLID_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return bpcAppLidService.update(BPCAppLid.fromJSON(data));
    }

    @RequestMapping(value = BPC_APPLID_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return bpcAppLidService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BPC_APPLID_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(BPC_APPLID_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
