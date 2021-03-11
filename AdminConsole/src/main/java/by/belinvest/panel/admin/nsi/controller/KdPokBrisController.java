package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.kd_pok_bris.KdPokBris;
import by.belinvest.panel.admin.nsi.service.KdPokBrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/kd_pok_bris")
public class KdPokBrisController {
    private static final String KD_POK_BRIS_CREATE_URL = "/create";
    private static final String KD_POK_BRIS_EDIT_URL = "/edit";
    private static final String KD_POK_BRIS_REMOVE_URL = "/remove";
    private static final String KD_POK_BRIS_DIRECTORY_GET_URL = "/nsi/kd_pok_bris";

    private static final String KD_POK_BRIS_DIMID_PARAMETER = "DIMID";
    private static final String KD_POK_BRIS_LIST_KD_PRODUCTS_PARAMETER = "LIST_KD_PRODUCTS";
    private static final String KD_POK_BRIS_CODE_PARAMETER = "CODE";
    private static final String KD_POK_BRIS_NAME_PARAMETER = "NAME";
    private static final String KD_POK_BRIS_CHECK_TOPPDN_REZERV_PARAMETER = "CHECK_TOPPDN_REZERV";
    private static final String KD_POK_BRIS_RESERVE_PERSENT_FOR_KD_PARAMETER = "RESERVE_PERSENT_FOR_KD";



    private static final String KD_POK_BRIS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String KD_POK_BRIS_PRIMARY_KEY = "DIMID";
    private static final String KD_POK_BRIS_DOMAIN = "kd_pok_bris";

    @Autowired
    private KdPokBrisService kdPokBrisService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(KD_POK_BRIS_DIRECTORY_PARAMETER, kdPokBrisService.get());
        model.addAttribute("domain",KD_POK_BRIS_DOMAIN);
        model.addAttribute("primaryKey",KD_POK_BRIS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = KD_POK_BRIS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = KD_POK_BRIS_LIST_KD_PRODUCTS_PARAMETER) String listKdProducts,
                               @RequestParam(value = KD_POK_BRIS_CODE_PARAMETER) String code,
                               @RequestParam(value = KD_POK_BRIS_NAME_PARAMETER) String name,
                               @RequestParam(value = KD_POK_BRIS_RESERVE_PERSENT_FOR_KD_PARAMETER) String reservePersentForKd,
                               @RequestParam(value = KD_POK_BRIS_CHECK_TOPPDN_REZERV_PARAMETER) String checkToppdnRezerv) {

        kdPokBrisService.create(KdPokBris.builder()
                .code(code)
                .name(name)
                .listKdProducts(listKdProducts)
                .reservePersentForKd(reservePersentForKd)
                .checkToppdnRezerv(checkToppdnRezerv)
                .build()
        );
        return new RedirectView(request.getContextPath() + KD_POK_BRIS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = KD_POK_BRIS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return kdPokBrisService.update(KdPokBris.fromJSON(data));
    }

    @RequestMapping(value = KD_POK_BRIS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return kdPokBrisService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(KD_POK_BRIS_LIST_KD_PRODUCTS_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(KD_POK_BRIS_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(KD_POK_BRIS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(KD_POK_BRIS_RESERVE_PERSENT_FOR_KD_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(KD_POK_BRIS_CHECK_TOPPDN_REZERV_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
