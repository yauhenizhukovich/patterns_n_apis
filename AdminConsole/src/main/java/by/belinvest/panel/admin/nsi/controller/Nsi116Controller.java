package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.nsi_116.Nsi116;
import by.belinvest.panel.admin.nsi.service.Nsi116Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/nsi_116")
public class Nsi116Controller {

    private static final String NSI_116_CREATE_URL = "/create";
    private static final String NSI_116_EDIT_URL = "/edit";
    private static final String NSI_116_REMOVE_URL = "/remove";
    private static final String NSI_116_DIRECTORY_GET_URL = "/nsi/nsi_116";

    private static final String NSI_116_DIMID_PARAMETER = "DIMID";
    private static final String NSI_116_PARENTID_PARAMETER = "PARENTID";
    private static final String NSI_116_CODE_PARAMETER = "CODE";
    private static final String NSI_116_NAME_PARAMETER = "NAME";
    private static final String NSI_116_NSI_116_SH_VD_PARAMETER = "NSI_116_SH_VD";
    private static final String NSI_116_NSI_116_GROUP_NUM_PARAMETER = "NSI_116_GROUP_NUM";
    private static final String NSI_116_NSI_116_TARIF_PARAMETER = "NSI_116_TARIF";
    private static final String NSI_116_NSI_116_OP_PARAMETER = "NSI_116_OP";
    private static final String NSI_116_NSI_116_DATE_CLOSE_NACVAL = "NSI_116_DATE_CLOSE";
    private static final String NSI_116_NSI_116_TUNN_PARAMETER = "NSI_116_TUNN";
    private static final String NSI_116_NSI_116_AVALIABLE_FOR_DBO_PARAMETER = "NSI_116_AVALIABLE_FOR_DBO";
    private static final String NSI_116_NSI_116_TMIN_PARAMETER = "NSI_116_TMIN";
    private static final String NSI_116_NSI_116_NOPAY_PARAMETER = "NSI_116_NOPAY";
    private static final String NSI_116_NSI_116_SH_VO_PARAMETER = "NSI_116_SH_VO";
    private static final String NSI_116_NSI_116_TYPE_TARIF_PARAMETER = "NSI_116_TYPE_TARIF";
    private static final String NSI_116_ISO_NSI_116_DATE_OPEN_PARAMETER = "NSI_116_DATE_OPEN";
    private static final String NSI_116_NSI_116_SH_OP_PARAMETER = "NSI_116_SH_OP";
    private static final String NSI_116_NSI_116_PACK_GROUP_PARAMETER = "NSI_116_PACK_GROUP";
    private static final String NSI_116_NSI_116_VAL_PARAMETER = "NSI_116_VAL";
    private static final String NSI_116_NSI_116_SH_NP_PARAMETER = "NSI_116_SH_NP";
    private static final String NSI_116_NSI_NSI_116_TMAX_PARAMETER = "NSI_116_TMAX";
    private static final String NSI_116_NSI_116_TPODR_PARAMETER = "NSI_116_TPODR";
    private static final String NSI_116_NSI_116_TYPE_ITEM_PARAMETER = "NSI_116_TYPE_ITEM";
    private static final String NSI_116_NSI_116_TVAL_PARAMETER = "NSI_116_TVAL";


    private static final String NSI_116_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String NSI_116_PRIMARY_KEY = "DIMID";
    private static final String NSI_116_DOMAIN = "nsi_116";

    @Autowired
    private Nsi116Service nsi116Service;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(NSI_116_DIRECTORY_PARAMETER, nsi116Service.get());
        model.addAttribute("domain", NSI_116_DOMAIN);
        model.addAttribute("primaryKey", NSI_116_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = NSI_116_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = NSI_116_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = NSI_116_CODE_PARAMETER) String code,
                               @RequestParam(value = NSI_116_NAME_PARAMETER) String name,
                               @RequestParam(value = NSI_116_NSI_116_SH_VD_PARAMETER) String nsi116ShVd,
                               @RequestParam(value = NSI_116_NSI_116_GROUP_NUM_PARAMETER) String nsi116GroupNum,
                               @RequestParam(value = NSI_116_NSI_116_TARIF_PARAMETER) String nsi116Tarif,
                               @RequestParam(value = NSI_116_NSI_116_OP_PARAMETER) String nsi116Op,
                               @RequestParam(value = NSI_116_NSI_116_DATE_CLOSE_NACVAL) String nsi116DateClose,
                               @RequestParam(value = NSI_116_NSI_116_TUNN_PARAMETER) String nsi116Tunn,
                               @RequestParam(value = NSI_116_NSI_116_AVALIABLE_FOR_DBO_PARAMETER) String nsi116AvaliableForDbo,
                               @RequestParam(value = NSI_116_NSI_116_TMIN_PARAMETER) String nsi116Tmin,
                               @RequestParam(value = NSI_116_NSI_116_NOPAY_PARAMETER) String nsi116Nopay,
                               @RequestParam(value = NSI_116_NSI_116_SH_VO_PARAMETER) String nsi116ShVo,
                               @RequestParam(value = NSI_116_NSI_116_TYPE_TARIF_PARAMETER) String nsi116TypeTarif,
                               @RequestParam(value = NSI_116_ISO_NSI_116_DATE_OPEN_PARAMETER) String nsi116DateOpen,
                               @RequestParam(value = NSI_116_NSI_116_SH_OP_PARAMETER) String nsi116ShOp,
                               @RequestParam(value = NSI_116_NSI_116_PACK_GROUP_PARAMETER) String nsi116PackGroup,
                               @RequestParam(value = NSI_116_NSI_116_VAL_PARAMETER) String nsi116Val,
                               @RequestParam(value = NSI_116_NSI_116_SH_NP_PARAMETER) String nsi116ShNp,
                               @RequestParam(value = NSI_116_NSI_NSI_116_TMAX_PARAMETER) String nsi116Tmax,
                               @RequestParam(value = NSI_116_NSI_116_TPODR_PARAMETER) String nsi116Tpodr,
                               @RequestParam(value = NSI_116_NSI_116_TYPE_ITEM_PARAMETER) String nsi116TypeItem,
                               @RequestParam(value = NSI_116_NSI_116_TVAL_PARAMETER) String nsi116Tval) {

        nsi116Service.create(Nsi116.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .nsi116ShVd(nsi116ShVd)
                .nsi116GroupNum(nsi116GroupNum)
                .nsi116Tarif(nsi116Tarif)
                .nsi116Op(nsi116Op)
                .nsi116DateClose(nsi116DateClose)
                .nsi116Tunn(nsi116Tunn)
                .nsi116AvaliableForDbo(nsi116AvaliableForDbo)
                .nsi116Tmin(nsi116Tmin)
                .nsi116Nopay(nsi116Nopay)
                .nsi116ShVo(nsi116ShVo)
                .nsi116TypeTarif(nsi116TypeTarif)
                .nsi116DateOpen(nsi116DateOpen)
                .nsi116ShOp(nsi116ShOp)
                .nsi116PackGroup(nsi116PackGroup)
                .nsi116Val(nsi116Val)
                .nsi116ShNp(nsi116ShNp)
                .nsi116Tmax(nsi116Tmax)
                .nsi116Tpodr(nsi116Tpodr)
                .nsi116TypeItem(nsi116TypeItem)
                .nsi116Tval(nsi116Tval)
                .build()
        );
        return new RedirectView(request.getContextPath() + NSI_116_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = NSI_116_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@" + data);
        return nsi116Service.update(Nsi116.fromJSON(data));
    }

    @RequestMapping(value = NSI_116_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return nsi116Service.remove(id);
    }

    private Map<String, String> getFieldsType() {
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(NSI_116_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_116_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_SH_VD_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_GROUP_NUM_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_TARIF_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_OP_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_DATE_CLOSE_NACVAL, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_TUNN_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_AVALIABLE_FOR_DBO_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_TMIN_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_NOPAY_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_SH_VO_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_TYPE_TARIF_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        fieldsMap.put(NSI_116_ISO_NSI_116_DATE_OPEN_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_SH_OP_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_PACK_GROUP_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_VAL_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_SH_NP_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_NSI_116_TMAX_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_TPODR_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_TYPE_ITEM_PARAMETER, FieldsType.SELECT_3_PARAMS_FIELD_TYPE);
        fieldsMap.put(NSI_116_NSI_116_TVAL_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
