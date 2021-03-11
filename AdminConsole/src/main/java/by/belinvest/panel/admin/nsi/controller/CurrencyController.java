package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.currency.Currency;
import by.belinvest.panel.admin.nsi.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/currency")
public class CurrencyController {

    private static final String CURRENCY_CREATE_URL = "/create";
    private static final String CURRENCY_EDIT_URL = "/edit";
    private static final String CURRENCY_REMOVE_URL = "/remove";
    private static final String CURRENCY_DIRECTORY_GET_URL = "/nsi/currency";

    private static final String CURRENCY_DIMID_PARAMETER = "DIMID";
    private static final String CURRENCY_PARENTID_PARAMETER = "PARENTID";
    private static final String CURRENCY_CODE_PARAMETER = "CODE";
    private static final String CURRENCY_NAME_PARAMETER = "NAME";
    private static final String CURRENCY_KURS_KOL_PARAMETER = "KURS_KOL";
    private static final String CURRENCY_STATE_PARAMETER = "STATE";
    private static final String CURRENCY_BBB_CODE_PARAMETER = "BBB_CODE";
    private static final String CURRENCY_FGENDER_PARAMETER = "FGENDER";
    private static final String CURRENCY_CURR_PERIOD_KOT_PARAMETER = "CURR_PERIOD_KOT";
    private static final String CURRENCY_CURR_ORDER_PARAMETER = "CURR_ORDER";
    private static final String CURRENCY_SIGN_KONTROL_PARAMETER = "SIGN_KONTROL";
    private static final String CURRENCY_PRINT_1P_PARAMETER = "PRINT_1P";
    private static final String CURRENCY_PRINT_1R_PARAMETER = "PRINT_1R";
    private static final String CURRENCY_PRINT_2R_PARAMETER = "PRINT_2R";
    private static final String CURRENCY_PRINT_NP_PARAMETER = "PRINT_NP";
    private static final String CURRENCY_IGENDER_PARAMETER = "IGENDER";
    private static final String CURRENCY_PRINT_NR_PARAMETER = "PRINT_NR";
    private static final String CURRENCY_PRINT_FNR_PARAMETER = "PRINT_FNR";
    private static final String CURRENCY_KURS_PRICE_PARAMETER = "KURS_PRICE";
    private static final String CURRENCY_KOD_CURR_NUM_PARAMETER = "KOD_CURR_NUM";
    private static final String CURRENCY_PRINT_F2R_PARAMETER = "PRINT_F2R";
    private static final String CURRENCY_PRINT_F1_PARAMETER = "PRINT_F1";
    private static final String CURRENCY_CURR_TYPE_PARAMETER = "CURR_TYPE";



    private static final String CURRENCY_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CURRENCY_PRIMARY_KEY = "DIMID";
    private static final String CURRENCY_DOMAIN = "currency";

    @Autowired
    private CurrencyService currencyService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CURRENCY_DIRECTORY_PARAMETER, currencyService.get());
        model.addAttribute("domain",CURRENCY_DOMAIN);
        model.addAttribute("primaryKey",CURRENCY_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CURRENCY_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CURRENCY_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = CURRENCY_NAME_PARAMETER) String name,
                               @RequestParam(value = CURRENCY_CODE_PARAMETER) String code,
                               @RequestParam(value = CURRENCY_KURS_KOL_PARAMETER) String kursKol,
                               @RequestParam(value = CURRENCY_STATE_PARAMETER) String state,
                               @RequestParam(value = CURRENCY_BBB_CODE_PARAMETER) String bbbCode,
                               @RequestParam(value = CURRENCY_FGENDER_PARAMETER) String fgender,
                               @RequestParam(value = CURRENCY_CURR_PERIOD_KOT_PARAMETER) String currPeriodKot,
                               @RequestParam(value = CURRENCY_CURR_ORDER_PARAMETER) String currOrder,
                               @RequestParam(value = CURRENCY_SIGN_KONTROL_PARAMETER) String signKontrol,
                               @RequestParam(value = CURRENCY_PRINT_1P_PARAMETER) String print1P,
                               @RequestParam(value = CURRENCY_PRINT_1R_PARAMETER) String print1R,
                               @RequestParam(value = CURRENCY_PRINT_2R_PARAMETER) String print2R,
                               @RequestParam(value = CURRENCY_PRINT_NP_PARAMETER) String printNP,
                               @RequestParam(value = CURRENCY_IGENDER_PARAMETER) String igender,
                               @RequestParam(value = CURRENCY_PRINT_NR_PARAMETER) String printNR,
                               @RequestParam(value = CURRENCY_PRINT_FNR_PARAMETER) String printFNR,
                               @RequestParam(value = CURRENCY_KURS_PRICE_PARAMETER) String kursPrice,
                               @RequestParam(value = CURRENCY_KOD_CURR_NUM_PARAMETER) String kodCurrNum,
                               @RequestParam(value = CURRENCY_PRINT_F2R_PARAMETER) String printF2R,
                               @RequestParam(value = CURRENCY_PRINT_F1_PARAMETER) String printF1,
                               @RequestParam(value = CURRENCY_CURR_TYPE_PARAMETER) String currType) {

        currencyService.create(Currency.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .kursKol(kursKol)
                .state(state)
                .bbbCode(bbbCode)
                .fgender(fgender)
                .currPeriodKot(currPeriodKot)
                .currOrder(currOrder)
                .signKontrol(signKontrol)
                .print1P(print1P)
                .print1R(print1R)
                .print2R(print2R)
                .printNP(printNP)
                .igender(igender)
                .printNR(printNR)
                .printFNR(printFNR)
                .kursPrice(kursPrice)
                .kodCurrNum(kodCurrNum)
                .printF2R(printF2R)
                .printF1(printF1)
                .currType(currType)
                .build()
        );
        return new RedirectView(request.getContextPath() + CURRENCY_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CURRENCY_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return currencyService.update(Currency.fromJSON(data));
    }

    @RequestMapping(value = CURRENCY_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return currencyService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CURRENCY_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CURRENCY_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_KURS_KOL_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CURRENCY_STATE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_BBB_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_FGENDER_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_CURR_PERIOD_KOT_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CURRENCY_CURR_ORDER_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_SIGN_KONTROL_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_PRINT_1P_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_PRINT_1R_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_PRINT_2R_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_PRINT_NP_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_IGENDER_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_PRINT_NR_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_PRINT_FNR_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_KURS_PRICE_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CURRENCY_KOD_CURR_NUM_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CURRENCY_PRINT_F2R_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_PRINT_F1_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_CURR_TYPE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
