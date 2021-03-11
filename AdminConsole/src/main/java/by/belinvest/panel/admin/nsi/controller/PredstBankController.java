package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.predst_bank.PredstBank;
import by.belinvest.panel.admin.nsi.service.PredstBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/predst_bank")
public class PredstBankController {

    private static final String PREDST_BANK_CREATE_URL = "/create";
    private static final String PREDST_BANK_EDIT_URL = "/edit";
    private static final String PREDST_BANK_REMOVE_URL = "/remove";
    private static final String PREDST_BANK_DIRECTORY_GET_URL = "/nsi/predst_bank";

    private static final String PREDST_BANK_CODE_PARAMETER = "CODE";
    private static final String PREDST_BANK_NAME_PARAMETER = "NAME";
    private static final String PREDST_BANK_DOLJN_PREDST_PARAMETER = "DOLJN_PREDST";
    private static final String PREDST_BANK_POST_R_PARAMETER = "POST_R";
    private static final String PREDST_BANK_FIO_R_ACCESS_PARAMETER = "FIO_R_ACCESS";
    private static final String PREDST_BANK_FIO_R_PARAMETER = "FIO_R";
    private static final String PREDST_BANK_POST_R_ACCESS_NACVAL = "POST_R_ACCESS";
    private static final String PREDST_BANK_MANAGER_PERSON_NUM_PARAMETER = "MANAGER_PERSON_NUM";
    private static final String PREDST_BANK_DOKUM_PREDST_PARAMETER = "DOKUM_PREDST";


    private static final String PREDST_BANK_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PREDST_BANK_PRIMARY_KEY = "CODE";
    private static final String PREDST_BANK_DOMAIN = "predst_bank";

    @Autowired
    private PredstBankService predstBankService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PREDST_BANK_DIRECTORY_PARAMETER, predstBankService.get());
        model.addAttribute("domain", PREDST_BANK_DOMAIN);
        model.addAttribute("primaryKey", PREDST_BANK_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PREDST_BANK_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PREDST_BANK_NAME_PARAMETER) String name,
                               @RequestParam(value = PREDST_BANK_DOLJN_PREDST_PARAMETER) String doljnPredst,
                               @RequestParam(value = PREDST_BANK_POST_R_PARAMETER) String postR,
                               @RequestParam(value = PREDST_BANK_FIO_R_ACCESS_PARAMETER) String fioRAdress,
                               @RequestParam(value = PREDST_BANK_FIO_R_PARAMETER) String fioR,
                               @RequestParam(value = PREDST_BANK_POST_R_ACCESS_NACVAL) String postRAccess,
                               @RequestParam(value = PREDST_BANK_MANAGER_PERSON_NUM_PARAMETER) String managerPersonNum,
                               @RequestParam(value = PREDST_BANK_DOKUM_PREDST_PARAMETER) String documPredst) {

        predstBankService.create(PredstBank.builder()
                .name(name)
                .doljnPredst(doljnPredst)
                .postR(postR)
                .fioRAdress(fioRAdress)
                .fioR(fioR)
                .postRAccess(postRAccess)
                .managerPersonNum(managerPersonNum)
                .documPredst(documPredst)
                .build()
        );
        return new RedirectView(request.getContextPath() + PREDST_BANK_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PREDST_BANK_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return predstBankService.update(PredstBank.fromJSON(data));
    }

    @RequestMapping(value = PREDST_BANK_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return predstBankService.remove(id);
    }

    private Map<String, String> getFieldsType() {
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PREDST_BANK_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREDST_BANK_DOLJN_PREDST_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREDST_BANK_POST_R_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREDST_BANK_FIO_R_ACCESS_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREDST_BANK_FIO_R_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREDST_BANK_POST_R_ACCESS_NACVAL, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREDST_BANK_MANAGER_PERSON_NUM_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREDST_BANK_DOKUM_PREDST_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
