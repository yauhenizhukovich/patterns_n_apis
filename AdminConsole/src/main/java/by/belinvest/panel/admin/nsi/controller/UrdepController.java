package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.urdep.Urdep;
import by.belinvest.panel.admin.nsi.service.UrdepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/urdep")
public class UrdepController {

    private static final String URDEP_CREATE_URL = "/create";
    private static final String URDEP_EDIT_URL = "/edit";
    private static final String URDEP_REMOVE_URL = "/remove";
    private static final String URDEP_DIRECTORY_GET_URL = "/nsi/urdep";

    private static final String URDEP_DIMID_PARAMETER = "DIMID";
    private static final String URDEP_PARENTID_PARAMETER = "PARENTID";
    private static final String URDEP_CODE_PARAMETER = "CODE";
    private static final String URDEP_NAME_PARAMETER = "NAME";
    private static final String URDEP_DEP_PROC_DECREASE_STAV_PARAMETER = "DEP_PROC_DECREASE_STAV";
    private static final String URDEP_DEP_VID_PROC_STAV_PARAMETER = "DEP_VID_PROC_STAV";
    private static final String URDEP_DEP_SUMBL_PARAMETER = "DEP_SUMBL";
    private static final String URDEP_DEP_SROK_PARAMETER = "DEP_SROK";
    private static final String URDEP_DEP_TYPE_PARAMETER = "DEP_TYPE";
    private static final String URDEP_DEP_SR_VOZVRAT_PARAMETER = "DEP_SR_VOZVRAT";
    private static final String URDEP_DEP_POROG_SUM_PARAMETER = "DEP_POROG_SUM";
    private static final String URDEP_DEP_SUM_SPIS_PARAMETER = "DEP_SUM_SPIS";
    private static final String URDEP_DEP_MAX_SROK_PARAMETER = "DEP_MAX_SROK";
    private static final String URDEP_DEP_STAV_SPIS_PARAMETER = "DEP_STAV_SPIS";
    private static final String URDEP_DEP_USL_RASTOR_PARAMETER = "DEP_USL_RASTOR";
    private static final String URDEP_DEP_BLOC_PARAMETER = "DEP_BLOC";
    private static final String URDEP_DEP_SUMDOG_PARAMETER = "DEP_SUMDOG";
    private static final String URDEP_DEP_ALLOW_ADDITION_PARAMETER = "DEP_ALLOW_ADDITION";
    private static final String URDEP_DEP_BAN_DEYS_PARAMETER = "DEP_BAN_DEYS";
    private static final String URDEP_DEP_STAV_RAST_PARAMETER = "DEP_STAV_RAST";
    private static final String URDEP_DEP_STAVKA_PARAMETER = "DEP_STAVKA";
    private static final String URDEP_DEP_GOAL_PARAMETER = "DEP_GOAL";
    private static final String URDEP_SHKALA_STAV_PARAMETER = "DEP_SHKALA_STAV";
    private static final String URDEP_DEP_KOL_PARAMETER = "DEP_KOL";
    private static final String URDEP_DEP_TYPE_NACH_PROC_PARAMETER = "DEP_TYPE_NACH_PROC";
    private static final String URDEP_DEP_PROC_RAST_PARAMETER = "DEP_PROC_RAST";
    private static final String URDEP_DEP_MAX_STAV_PARAMETER = "DEP_MAX_STAV";
    private static final String URDEP_DEP_MAX_LIMIT_PARAMETER = "DEP_MAX_LIMIT";
    private static final String URDEP_DEP_PROC_TAKE_ALLOW_PARAMETER = "DEP_PROC_TAKE_ALLOW";
    private static final String URDEP_DEP_MIN_SROK_PARAMETER = "DEP_MIN_SROK";
    private static final String URDEP_DEP_STAV_RAST_VAL_PARAMETER = "DEP_STAV_RAST_VAL";
    private static final String URDEP_DEP_SROK_WAIT_RETURN_PARAMETER = "DEP_SROK_WAIT_RETURN";
    private static final String URDEP_DEP_LIMIT_PARAMETER = "DEP_LIMIT";
    private static final String URDEP_DEP_TYPE_CONTRACT_PARAMETER = "DEP_TYPE_CONTRACT";
    private static final String URDEP_DEP_ADDITIONAL_INCOME_PARAMETER = "DEP_ADDITIONAL_INCOME";
    private static final String URDEP_DEP_KONTR_MAX_STAV_PARAMETER = "DEP_KONTR_MAX_STAV";
    private static final String URDEP_DEP_CURRENCY_PARAMETER = "DEP_CURRENCY";
    private static final String URDEP_DEP_STAV_POROG_PARAMETER = "DEP_STAV_POROG";


    private static final String URDEP_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String URDEP_PRIMARY_KEY = "DIMID";
    private static final String URDEP_DOMAIN = "urdep";

    @Autowired
    private UrdepService urdepService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@\n"+
                urdepService.get());
        model.addAttribute(URDEP_DIRECTORY_PARAMETER, urdepService.get());
        model.addAttribute("domain", URDEP_DOMAIN);
        model.addAttribute("primaryKey", URDEP_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = URDEP_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = URDEP_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = URDEP_CODE_PARAMETER) String code,
                               @RequestParam(value = URDEP_NAME_PARAMETER) String name,
                               @RequestParam(value = URDEP_DEP_PROC_DECREASE_STAV_PARAMETER) String decreaseStav,
                               @RequestParam(value = URDEP_DEP_VID_PROC_STAV_PARAMETER) String prodStav,
                               @RequestParam(value = URDEP_DEP_SUMBL_PARAMETER) String depSumbl,
                               @RequestParam(value = URDEP_DEP_SROK_PARAMETER) String srok,
                               @RequestParam(value = URDEP_DEP_TYPE_PARAMETER) String type,
                               @RequestParam(value = URDEP_DEP_SR_VOZVRAT_PARAMETER) String srVozvrat,
                               @RequestParam(value = URDEP_DEP_POROG_SUM_PARAMETER) String porogSum,
                               @RequestParam(value = URDEP_DEP_SUM_SPIS_PARAMETER) String sumSpis,
                               @RequestParam(value = URDEP_DEP_MAX_SROK_PARAMETER) String maxSrok,
                               @RequestParam(value = URDEP_DEP_STAV_SPIS_PARAMETER) String stavSpis,
                               @RequestParam(value = URDEP_DEP_USL_RASTOR_PARAMETER) String uslRastor,
                               @RequestParam(value = URDEP_DEP_BLOC_PARAMETER) String bloc,
                               @RequestParam(value = URDEP_DEP_SUMDOG_PARAMETER) String sumdog,
                               @RequestParam(value = URDEP_DEP_ALLOW_ADDITION_PARAMETER) String allowAddition,
                               @RequestParam(value = URDEP_DEP_BAN_DEYS_PARAMETER) String banDeys,
                               @RequestParam(value = URDEP_DEP_STAV_RAST_PARAMETER) String stavRast,
                               @RequestParam(value = URDEP_DEP_STAVKA_PARAMETER) String depStavka,
                               @RequestParam(value = URDEP_DEP_GOAL_PARAMETER) String goal,
                               @RequestParam(value = URDEP_SHKALA_STAV_PARAMETER) String shkalaStav,
                               @RequestParam(value = URDEP_DEP_KOL_PARAMETER) String kol,
                               @RequestParam(value = URDEP_DEP_TYPE_NACH_PROC_PARAMETER) String nachProc,
                               @RequestParam(value = URDEP_DEP_PROC_RAST_PARAMETER) String procRast,
                               @RequestParam(value = URDEP_DEP_MAX_STAV_PARAMETER) String maxStav,
                               @RequestParam(value = URDEP_DEP_MAX_LIMIT_PARAMETER) String maxLimit,
                               @RequestParam(value = URDEP_DEP_PROC_TAKE_ALLOW_PARAMETER) String takeAllow,
                               @RequestParam(value = URDEP_DEP_MIN_SROK_PARAMETER) String minSrok,
                               @RequestParam(value = URDEP_DEP_STAV_RAST_VAL_PARAMETER) String stavRastVal,
                               @RequestParam(value = URDEP_DEP_SROK_WAIT_RETURN_PARAMETER) String srokWaitReturn,
                               @RequestParam(value = URDEP_DEP_LIMIT_PARAMETER) String limit,
                               @RequestParam(value = URDEP_DEP_TYPE_CONTRACT_PARAMETER) String contract,
                               @RequestParam(value = URDEP_DEP_ADDITIONAL_INCOME_PARAMETER) String additionalIncome,
                               @RequestParam(value = URDEP_DEP_KONTR_MAX_STAV_PARAMETER) String kontrMaxStav,
                               @RequestParam(value = URDEP_DEP_CURRENCY_PARAMETER) String currency,
                               @RequestParam(value = URDEP_DEP_STAV_POROG_PARAMETER) String stavPorog) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"+
                Urdep.builder()
                        .parentId(parentId)
                        .code(code)
                        .name(name)
                        .decreaseStav(decreaseStav)
                        .prodStav(prodStav)
                        .depSumbl(depSumbl)
                        .srok(srok)
                        .type(type)
                        .srVozvrat(srVozvrat)
                        .porogSum(porogSum)
                        .sumSpis(sumSpis)
                        .maxSrok(maxSrok)
                        .stavSpis(stavSpis)
                        .uslRastor(uslRastor)
                        .bloc(bloc)
                        .sumdog(sumdog)
                        .allowAddition(allowAddition)
                        .banDeys(banDeys)
                        .stavRast(stavRast)
                        .depStavka(depStavka)
                        .goal(goal)
                        .shkalaStav(shkalaStav)
                        .kol(kol)
                        .nachProc(nachProc)
                        .procRast(procRast)
                        .maxStav(maxStav)
                        .maxLimit(maxLimit)
                        .takeAllow(takeAllow)
                        .minSrok(minSrok)
                        .stavRastVal(stavRastVal)
                        .srokWaitReturn(srokWaitReturn)
                        .limit(limit)
                        .contract(contract)
                        .additionalIncome(additionalIncome)
                        .kontrMaxStav(kontrMaxStav)
                        .currency(currency)
                        .stavPorog(stavPorog)
                        .build());
        urdepService.create(Urdep.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .decreaseStav(decreaseStav)
                .prodStav(prodStav)
                .depSumbl(depSumbl)
                .srok(srok)
                .type(type)
                .srVozvrat(srVozvrat)
                .porogSum(porogSum)
                .sumSpis(sumSpis)
                .maxSrok(maxSrok)
                .stavSpis(stavSpis)
                .uslRastor(uslRastor)
                .bloc(bloc)
                .sumdog(sumdog)
                .allowAddition(allowAddition)
                .banDeys(banDeys)
                .stavRast(stavRast)
                .depStavka(depStavka)
                .goal(goal)
                .shkalaStav(shkalaStav)
                .kol(kol)
                .nachProc(nachProc)
                .procRast(procRast)
                .maxStav(maxStav)
                .maxLimit(maxLimit)
                .takeAllow(takeAllow)
                .minSrok(minSrok)
                .stavRastVal(stavRastVal)
                .srokWaitReturn(srokWaitReturn)
                .limit(limit)
                .contract(contract)
                .additionalIncome(additionalIncome)
                .kontrMaxStav(kontrMaxStav)
                .currency(currency)
                .stavPorog(stavPorog)
                .build()
        );
        return new RedirectView(request.getContextPath() + URDEP_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = URDEP_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return urdepService.update(Urdep.fromJSON(data));
    }

    @RequestMapping(value = URDEP_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return urdepService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(URDEP_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_CODE_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_PROC_DECREASE_STAV_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_VID_PROC_STAV_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_SUMBL_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_SROK_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_TYPE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_SR_VOZVRAT_PARAMETER, FieldsType.SELECT_1_2_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_POROG_SUM_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_SUM_SPIS_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_MAX_SROK_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_STAV_SPIS_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_USL_RASTOR_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_BLOC_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_SUMDOG_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_ALLOW_ADDITION_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_BAN_DEYS_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_STAV_RAST_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_STAVKA_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_GOAL_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_SHKALA_STAV_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_KOL_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_TYPE_NACH_PROC_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_PROC_RAST_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_MAX_STAV_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_MAX_LIMIT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_PROC_TAKE_ALLOW_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_MIN_SROK_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_STAV_RAST_VAL_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_SROK_WAIT_RETURN_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_LIMIT_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_TYPE_CONTRACT_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_ADDITIONAL_INCOME_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_KONTR_MAX_STAV_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_CURRENCY_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(URDEP_DEP_STAV_POROG_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
