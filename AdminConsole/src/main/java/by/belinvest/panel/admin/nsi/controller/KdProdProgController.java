package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.kd_prod_prog.KdProdProg;
import by.belinvest.panel.admin.nsi.service.KdProdProgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/kd_prod_prog")
public class KdProdProgController {
    private static final String KD_PROD_PROG_CREATE_URL = "/create";
    private static final String KD_PROD_PROG_EDIT_URL = "/edit";
    private static final String KD_PROD_PROG_REMOVE_URL = "/remove";
    private static final String KD_PROD_PROG_DIRECTORY_GET_URL = "/nsi/kd_prod_prog";

    private static final String KD_PROD_PROG_DIMID_PARAMETER = "DIMID";
    private static final String KD_PROD_PROG_CODE_PARAMETER = "CODE";
    private static final String KD_PROD_PROG_NAME_PARAMETER = "NAME";
    private static final String KD_PROD_KD_PP_ST_RISK_PARAMETER = "KD_PP_ST_RISK";
    private static final String KD_PROD_KD_PP_TARG_PARAMETER = "KD_PP_TARG";
    private static final String KD_PROD_KD_PP_RM_DEC_PARAMETER = "KD_PP_RM_DEC";
    private static final String KD_PROD_KD_PP_COND_OBLIG_PARAMETER = "KD_PP_COND_OBLIG";
    private static final String KD_PROD_KD_PP_PROD_PARAMETER = "KD_PP_PROD";
    private static final String KD_PROD_KD_PP_TYPE_PARAMETER = "KD_PP_TYPE";
    private static final String KD_PROD_KD_PP_PENYA_VAL_PARAMETER = "KD_PP_PENYA_VAL";
    private static final String KD_PROD_KD_PP_CUR_CLIENT_PARAMETER = "KD_PP_CUR_CLIENT";
    private static final String KD_PROD_KD_PP_FORM_PARAMETER = "KD_PP_FORM";
    private static final String KD_PROD_KD_PP_VID_OBES_PARAMETER = "KD_PP_VID_OBES";
    private static final String KD_PROD_KD_PP_IST_FIN_PARAMETER = "KD_PP_IST_FIN";
    private static final String KD_PROD_KD_PP_DOST_PARAMETER = "KD_PP_DOST";
    private static final String KD_PROD_KD_PP_CUR_BANK_PARAMETER = "KD_PP_CUR_BANK";
    private static final String KD_PROD_KD_PP_MICRO_PARAMETER = "KD_PP_MICRO";
    private static final String KD_PROD_KD_PP_OBOR_PARAMETER = "KD_PP_OBOR";
    private static final String KD_PROD_KD_PP_TARIF_PARAMETER = "KD_PP_TARIF";
    private static final String KD_PROD_KD_PP_TYPE_KR_PARAMETER = "KD_PP_TYPE_KR";
    private static final String KD_PROD_KD_PP_TERM_PARAMETER = "KD_PP_TERM";
    private static final String KD_PROD_KD_PP_DAYS_IN_Y_PARAMETER = "KD_PP_DAYS_IN_Y";

    private static final String KD_PROD_PROG_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String KD_PROD_PROG_PRIMARY_KEY = "DIMID";
    private static final String KD_PROD_PROG_DOMAIN = "kd_prod_prog";

    @Autowired
    private KdProdProgService kdProdProgService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(KD_PROD_PROG_DIRECTORY_PARAMETER, kdProdProgService.get());
        model.addAttribute("domain",KD_PROD_PROG_DOMAIN);
        model.addAttribute("primaryKey",KD_PROD_PROG_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = KD_PROD_PROG_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = KD_PROD_PROG_CODE_PARAMETER) String code,
                               @RequestParam(value = KD_PROD_PROG_NAME_PARAMETER) String name,
                               @RequestParam(value = KD_PROD_KD_PP_ST_RISK_PARAMETER) String kdPpStRisk,
                               @RequestParam(value = KD_PROD_KD_PP_TARG_PARAMETER) String kdPpTarg,
                               @RequestParam(value = KD_PROD_KD_PP_RM_DEC_PARAMETER) String kdPpRmDec,
                               @RequestParam(value = KD_PROD_KD_PP_COND_OBLIG_PARAMETER) String kdPpCondOblig,
                               @RequestParam(value = KD_PROD_KD_PP_PROD_PARAMETER) String kdPpProd,
                               @RequestParam(value = KD_PROD_KD_PP_TYPE_PARAMETER) String kdPpType,
                               @RequestParam(value = KD_PROD_KD_PP_PENYA_VAL_PARAMETER) String kdPpPenyaVal,
                               @RequestParam(value = KD_PROD_KD_PP_CUR_CLIENT_PARAMETER) String kdPpCurClient,
                               @RequestParam(value = KD_PROD_KD_PP_FORM_PARAMETER) String kdPpCurForm,
                               @RequestParam(value = KD_PROD_KD_PP_VID_OBES_PARAMETER) String kdPpVidObes,
                               @RequestParam(value = KD_PROD_KD_PP_IST_FIN_PARAMETER) String kdPpIstFin,
                               @RequestParam(value = KD_PROD_KD_PP_DOST_PARAMETER) String kdPpDost,
                               @RequestParam(value = KD_PROD_KD_PP_CUR_BANK_PARAMETER) String kdPpCurBank,
                               @RequestParam(value = KD_PROD_KD_PP_MICRO_PARAMETER) String kdPpMicro,
                               @RequestParam(value = KD_PROD_KD_PP_OBOR_PARAMETER) String kdPpObor,
                               @RequestParam(value = KD_PROD_KD_PP_TARIF_PARAMETER) String kdPpTarif,
                               @RequestParam(value = KD_PROD_KD_PP_TYPE_KR_PARAMETER) String kdPpTypeKr,
                               @RequestParam(value = KD_PROD_KD_PP_TERM_PARAMETER) String kdPpTerm,
                               @RequestParam(value = KD_PROD_KD_PP_DAYS_IN_Y_PARAMETER) String kdPPDaysInY) {

        kdProdProgService.create(KdProdProg.builder()
                .code(code)
                .name(name)
                .kdPpStRisk(kdPpStRisk)
                .kdPpTarg(kdPpTarg)
                .kdPpRmDec(kdPpRmDec)
                .kdPpCondOblig(kdPpCondOblig)
                .kdPpProd(kdPpProd)
                .kdPpType(kdPpType)
                .kdPpPenyaVal(kdPpPenyaVal)
                .kdPpCurClient(kdPpCurClient)
                .kdPpCurForm(kdPpCurForm)
                .kdPpVidObes(kdPpVidObes)
                .kdPpIstFin(kdPpIstFin)
                .kdPpDost(kdPpDost)
                .kdPpCurBank(kdPpCurBank)
                .kdPpMicro(kdPpMicro)
                .kdPpObor(kdPpObor)
                .kdPpTarif(kdPpTarif)
                .kdPpTypeKr(kdPpTypeKr)
                .kdPpTerm(kdPpTerm)
                .kdPPDaysInY(kdPPDaysInY)
                .build()
        );
        return new RedirectView(request.getContextPath() + KD_PROD_PROG_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = KD_PROD_PROG_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return kdProdProgService.update(KdProdProg.fromJSON(data));
    }

    @RequestMapping(value = KD_PROD_PROG_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return kdProdProgService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(KD_PROD_PROG_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(KD_PROD_PROG_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_ST_RISK_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_TARG_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_RM_DEC_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_COND_OBLIG_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_PROD_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_TYPE_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_PENYA_VAL_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_CUR_CLIENT_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_FORM_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_VID_OBES_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_IST_FIN_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_DOST_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_CUR_BANK_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_MICRO_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_OBOR_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_TARIF_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_TYPE_KR_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_TERM_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_PROD_KD_PP_DAYS_IN_Y_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
