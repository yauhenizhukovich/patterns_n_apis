package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.bpc_designid.BPCDesignId;
import by.belinvest.panel.admin.nsi.service.BPCDesignIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/bpc_designid")
public class BPCDesignIdController {
    private static final String BPC_DESIGNID_CREATE_URL = "/create";
    private static final String BPC_DESIGNID_EDIT_URL = "/edit";
    private static final String BPC_DESIGNID_REMOVE_URL = "/remove";
    private static final String BPC_DESIGNID_DIRECTORY_GET_URL = "/nsi/bpc_designid";

    private static final String BPC_DESIGNID_DIMID_PARAMETER = "DIMID";
    private static final String BPC_DESIGNID_NAME_PARAMETER = "NAME";
    private static final String BPC_DESIGNID_CODE_PARAMETER = "CODE";

    private static final String BPC_DESIGNID_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BPC_DESIGNID_PRIMARY_KEY = "DIMID";
    private static final String BPC_DESIGNID_DOMAIN = "bpc_designid";

    @Autowired
    private BPCDesignIdService bpcDesignIdService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(BPC_DESIGNID_DIRECTORY_PARAMETER, bpcDesignIdService.get());
        model.addAttribute("domain",BPC_DESIGNID_DOMAIN);
        model.addAttribute("primaryKey",BPC_DESIGNID_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = BPC_DESIGNID_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BPC_DESIGNID_NAME_PARAMETER) String name,
                               @RequestParam(value = BPC_DESIGNID_CODE_PARAMETER) String code) {

        bpcDesignIdService.create(BPCDesignId.builder()
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + BPC_DESIGNID_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BPC_DESIGNID_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return bpcDesignIdService.update(BPCDesignId.fromJSON(data));
    }

    @RequestMapping(value = BPC_DESIGNID_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return bpcDesignIdService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BPC_DESIGNID_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(BPC_DESIGNID_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
