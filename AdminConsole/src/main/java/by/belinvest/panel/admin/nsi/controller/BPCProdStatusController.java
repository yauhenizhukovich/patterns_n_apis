package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.bpc_prod_status.BPCProdStatus;
import by.belinvest.panel.admin.nsi.service.BPCProdStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/bpc_prod_status")
public class BPCProdStatusController {
    private static final String BPC_PROD_STATUS_CREATE_URL = "/create";
    private static final String BPC_PROD_STATUS_EDIT_URL = "/edit";
    private static final String BPC_PROD_STATUS_REMOVE_URL = "/remove";
    private static final String BPC_PROD_STATUS_DIRECTORY_GET_URL = "/nsi/bpc_prod_status";

    private static final String BPC_PROD_STATUS_CODE_PARAMETER = "CODE";
    private static final String BPC_PROD_STATUS_NAME_PARAMETER = "NAME";

    private static final String BPC_PROD_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BPC_PROD_STATUS_PRIMARY_KEY = "CODE";
    private static final String BPC_PROD_STATUS_DOMAIN = "bpc_prod_status";

    @Autowired
    private BPCProdStatusService bpcProdStatusService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(BPC_PROD_STATUS_DIRECTORY_PARAMETER, bpcProdStatusService.get());
        model.addAttribute("domain",BPC_PROD_STATUS_DOMAIN);
        model.addAttribute("primaryKey",BPC_PROD_STATUS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = BPC_PROD_STATUS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BPC_PROD_STATUS_NAME_PARAMETER) String name) {

        bpcProdStatusService.create(BPCProdStatus.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + BPC_PROD_STATUS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BPC_PROD_STATUS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return bpcProdStatusService.update(BPCProdStatus.fromJSON(data));
    }

    @RequestMapping(value = BPC_PROD_STATUS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return bpcProdStatusService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BPC_PROD_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
