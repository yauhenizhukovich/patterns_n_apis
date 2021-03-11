package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.pos_credit_organisations.PosCreditOrganisations;
import by.belinvest.panel.admin.nsi.service.PosCreditOrganistionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/pos_kredit_organisations")
public class PosCreditOrganisationsController {

    private static final String POS_KREDIT_ORGANISATIONS_CREATE_URL = "/create";
    private static final String POS_KREDIT_ORGANISATIONS_EDIT_URL = "/edit";
    private static final String POS_KREDIT_ORGANISATIONS_REMOVE_URL = "/remove";
    private static final String POS_KREDIT_ORGANISATIONS_DIRECTORY_GET_URL = "/nsi/pos_kredit_organisations";

    private static final String POS_KREDIT_ORGANISATIONS_DIMID_PARAMETER = "DIMID";
    private static final String POS_KREDIT_ORGANISATIONS_PARENTID_PARAMETER = "PARENTID";
    private static final String POS_KREDIT_ORGANISATIONS_CODE_PARAMETER = "CODE";
    private static final String POS_KREDIT_ORGANISATIONS_NAME_PARAMETER = "NAME";
    private static final String POS_KREDIT_ORGANISATIONS_NAME_PKO_NAME_PARAMETER = "PKO_NAME";
    private static final String POS_KREDIT_ORGANISATIONS_BORDER_PKO_ADRESS_PARAMETER = "PKO_ADRESS";
    private static final String POS_KREDIT_ORGANISATIONS_RATING_PKO_UNP_PARAMETER = "PKO_UNP";
    private static final String POS_KREDIT_ORGANISATIONS_PKO_BANKS_PARAMETER = "PKO_BANKS";
    private static final String POS_KREDIT_ORGANISATIONS_PKO_ACCOUNT_NACVAL = "PKO_ACCOUNT";
    private static final String POS_KREDIT_ORGANISATIONS_PKO_BANKS_POS_PARAMETER = "PKO_BANKS_POS";
    private static final String POS_KREDIT_ORGANISATIONS_PKO_NAME_TT_PARAMETER = "PKO_NAME_TT";
    private static final String POS_KREDIT_ORGANISATIONS_PKO_ADRESS_TT_PARAMETER = "PKO_ADRESS_TT";
    private static final String POS_KREDIT_ORGANISATIONS_PKO_UNP_TT_PARAMETER = "PKO_UNP_TT";
    private static final String POS_KREDIT_ORGANISATIONS_PKO_BANKS_TT_PARAMETER = "PKO_BANKS_TT";
    private static final String POS_KREDIT_ORGANISATIONS_PKO_ACCOUNT_TT_PARAMETER = "PKO_ACCOUNT_TT";


    private static final String POS_KREDIT_ORGANISATIONS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String POS_KREDIT_ORGANISATIONS_PRIMARY_KEY = "DIMID";
    private static final String POS_KREDIT_ORGANISATIONS_DOMAIN = "pos_kredit_organisations";

    @Autowired
    private PosCreditOrganistionsService posCreditOrganisationsService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(POS_KREDIT_ORGANISATIONS_DIRECTORY_PARAMETER, posCreditOrganisationsService.get());
        model.addAttribute("domain",POS_KREDIT_ORGANISATIONS_DOMAIN);
        model.addAttribute("primaryKey",POS_KREDIT_ORGANISATIONS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = POS_KREDIT_ORGANISATIONS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_CODE_PARAMETER) String code,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_NAME_PARAMETER) String name,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_NAME_PKO_NAME_PARAMETER) String pkoName,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_BORDER_PKO_ADRESS_PARAMETER) String pkoAdress,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_RATING_PKO_UNP_PARAMETER) String pkoUnp,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PKO_BANKS_PARAMETER) String pkoBanks,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PKO_ACCOUNT_NACVAL) String pkoAccount,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PKO_BANKS_POS_PARAMETER) String pkoBankPos,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PKO_NAME_TT_PARAMETER) String pkoNameTt,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PKO_ADRESS_TT_PARAMETER) String pkoAdressTt,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PKO_UNP_TT_PARAMETER) String pkoUnpTt,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PKO_BANKS_TT_PARAMETER) String pkoBanksTt,
                               @RequestParam(value = POS_KREDIT_ORGANISATIONS_PKO_ACCOUNT_TT_PARAMETER) String pkoAccountTt) {

        posCreditOrganisationsService.create(PosCreditOrganisations.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .pkoName(pkoName)
                .pkoAdress(pkoAdress)
                .pkoUnp(pkoUnp)
                .pkoBanks(pkoBanks)
                .pkoAccount(pkoAccount)
                .pkoBankPos(pkoBankPos)
                .pkoNameTt(pkoNameTt)
                .pkoAdressTt(pkoAdressTt)
                .pkoUnpTt(pkoUnpTt)
                .pkoBanksTt(pkoBanksTt)
                .pkoAccountTt(pkoAccountTt)
                .build()
        );
        return new RedirectView(request.getContextPath() + POS_KREDIT_ORGANISATIONS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = POS_KREDIT_ORGANISATIONS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return posCreditOrganisationsService.update(PosCreditOrganisations.fromJSON(data));
    }

    @RequestMapping(value = POS_KREDIT_ORGANISATIONS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return posCreditOrganisationsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_NAME_PKO_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_BORDER_PKO_ADRESS_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_RATING_PKO_UNP_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PKO_BANKS_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PKO_ACCOUNT_NACVAL, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PKO_BANKS_POS_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PKO_NAME_TT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PKO_ADRESS_TT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PKO_UNP_TT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PKO_BANKS_TT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(POS_KREDIT_ORGANISATIONS_PKO_ACCOUNT_TT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
