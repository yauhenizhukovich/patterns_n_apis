package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.client_business_category.ClientBusinessCategory;
import by.belinvest.panel.admin.nsi.service.ClientBusinessCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/client_business_category")

public class ClientBusinessCategoryController {
    private static final String CLIENT_BUSINESS_CATEGORY_CREATE_URL = "/create";
    private static final String CLIENT_BUSINESS_CATEGORY_EDIT_URL = "/edit";
    private static final String CLIENT_BUSINESS_CATEGORY_REMOVE_URL = "/remove";
    private static final String CLIENT_BUSINESS_CATEGORY_DIRECTORY_GET_URL = "/nsi/client_business_category";

    private static final String CLIENT_BUSINESS_CATEGORY_DIMID_PARAMETER = "DIMID";
    private static final String CLIENT_BUSINESS_CATEGORY_PARENTID_PARAMETER = "PARENTID";
    private static final String CLIENT_BUSINESS_CATEGORY_CODE_PARAMETER = "CODE";
    private static final String CLIENT_BUSINESS_CATEGORY_NAME_PARAMETER = "NAME";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_EMPL_MIN_CNT_PARAMETER = "CLB_EMPL_MIN_CNT";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_MAX_SUM_PARAMETER = "CLB_MAX_SUM";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_SUM_MIN_PARAMETER = "CLB_CREDIT_SUM_MIN";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_DEFAULT_PARAMETER = "CLB_DEFAULT";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_PUBLIC_ADMIN_PARAMETER = "CLB_PUBLIC_ADMIN";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_SUM_MAX_PARAMETER = "CLB_CREDIT_SUM_MAX";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_OWNERSHIP_TYPE_PARAMETER = "CLB_OWNERSHIP_TYPE";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_BG_SUM_MAX_PARAMETER = "CLB_BG_SUM_MAX";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_EMPL_MAX_CNT_PARAMETER = "CLB_EMPL_MAX_CNT";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_CONTRAGENT_PARAMETER = "CLB_CONTRAGENT";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_BANK_CHILD_COMP_PARAMETER = "CLB_BANK_CHILD_COMP";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_BG_SUM_MIN_PARAMETER = "CLB_BG_SUM_MIN";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_MIN_SUM_PARAMETER = "CLB_MIN_SUM";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_DEBT_CUR_PARAMETER = "CLB_CREDIT_DEBT_CUR";
    private static final String CLIENT_BUSINESS_CATEGORY_CLB_CURRENCY_PARAMETER = "CLB_CURRENCY";



    private static final String CLIENT_BUSINESS_CATEGORY_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CLIENT_BUSINESS_CATEGORY_PRIMARY_KEY = "DIMID";
    private static final String CLIENT_BUSINESS_CATEGORY_DOMAIN = "client_business_category";

    @Autowired
    private ClientBusinessCategoryService clientBusinessCategoryService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CLIENT_BUSINESS_CATEGORY_DIRECTORY_PARAMETER, clientBusinessCategoryService.get());
        model.addAttribute("domain",CLIENT_BUSINESS_CATEGORY_DOMAIN);
        model.addAttribute("primaryKey",CLIENT_BUSINESS_CATEGORY_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CLIENT_BUSINESS_CATEGORY_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CODE_PARAMETER) String code,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_NAME_PARAMETER) String name,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_EMPL_MIN_CNT_PARAMETER) String clbEmplMinCnt,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_MAX_SUM_PARAMETER) String clbMaxSum,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_SUM_MIN_PARAMETER) String clbCreditSumMin,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_DEFAULT_PARAMETER) String clbDefault,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_PUBLIC_ADMIN_PARAMETER) String clbPublicAdmin,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_SUM_MAX_PARAMETER) String clbCreditSumMax,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_OWNERSHIP_TYPE_PARAMETER) String clbOwnershipType,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_BG_SUM_MAX_PARAMETER) String clbBgSumMax,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_EMPL_MAX_CNT_PARAMETER) String clbEmplMaxCnt,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_CONTRAGENT_PARAMETER) String clbContragent,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_BANK_CHILD_COMP_PARAMETER) String clbBankChildComp,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_BG_SUM_MIN_PARAMETER) String clbBgSumMin,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_MIN_SUM_PARAMETER) String clbMinSum,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_DEBT_CUR_PARAMETER) String clbCreditDebtCur,
                               @RequestParam(value = CLIENT_BUSINESS_CATEGORY_CLB_CURRENCY_PARAMETER) String clbCurrency) {

        clientBusinessCategoryService.create(ClientBusinessCategory.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .clbEmplMinCnt(clbEmplMinCnt)
                .clbMaxSum(clbMaxSum)
                .clbCreditSumMin(clbCreditSumMin)
                .clbDefault(clbDefault)
                .clbPublicAdmin(clbPublicAdmin)
                .clbCreditSumMax(clbCreditSumMax)
                .clbOwnershipType(clbOwnershipType)
                .clbBgSumMax(clbBgSumMax)
                .clbEmplMaxCnt(clbEmplMaxCnt)
                .clbContragent(clbContragent)
                .clbBankChildComp(clbBankChildComp)
                .clbBgSumMin(clbBgSumMin)
                .clbMinSum(clbMinSum)
                .clbCreditDebtCur(clbCreditDebtCur)
                .clbCurrency(clbCurrency)
                .build()
        );
        return new RedirectView(request.getContextPath() + CLIENT_BUSINESS_CATEGORY_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CLIENT_BUSINESS_CATEGORY_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return clientBusinessCategoryService.update(ClientBusinessCategory.fromJSON(data));
    }

    @RequestMapping(value = CLIENT_BUSINESS_CATEGORY_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return clientBusinessCategoryService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_EMPL_MIN_CNT_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_MAX_SUM_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_SUM_MIN_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_DEFAULT_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_PUBLIC_ADMIN_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_SUM_MAX_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_OWNERSHIP_TYPE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_BG_SUM_MAX_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_EMPL_MAX_CNT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_CONTRAGENT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_BANK_CHILD_COMP_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_BG_SUM_MIN_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_MIN_SUM_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_CREDIT_DEBT_CUR_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CLIENT_BUSINESS_CATEGORY_CLB_CURRENCY_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
