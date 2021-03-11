package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.nsi_007.Nsi007;
import by.belinvest.panel.admin.nsi.service.Nsi007Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/nsi_007")
public class Nsi007Controller {

    private static final String NSI_007_CREATE_URL = "/create";
    private static final String NSI_007_EDIT_URL = "/edit";
    private static final String NSI_007_REMOVE_URL = "/remove";
    private static final String NSI_007_DIRECTORY_GET_URL = "/nsi/nsi_007";

    private static final String NSI_007_DIMID_PARAMETER = "DIMID";
    private static final String NSI_007_CODE_PARAMETER = "CODE";
    private static final String NSI_007_NAME_PARAMETER = "NAME";
    private static final String NSI_007_NAME_SWIFT_PARAMETER = "NAME_SWIFT";
    private static final String NSI_007_BORDER_STATE_PARAMETER = "BORDER_STATE";
    private static final String NSI_007_RATING_VALUTA_PARAMETER = "RATING_VALUTA";
    private static final String NSI_007_CODE_SWIFT_PARAMETER = "CODE_SWIFT";
    private static final String NSI_007_RATING_NACVAL = "RATING_NACVAL";
    private static final String NSI_007_SIGN_OESR_PARAMETER = "SIGN_OESR";
    private static final String NSI_007_OFFSHOR_ZONE_PARAMETER = "OFFSHOR_ZONE";
    private static final String NSI_007_SIGN_EU_PARAMETER = "SIGN_EU";
    private static final String NSI_007_SIGNS_CORRUPTION_PARAMETER = "SIGNS_CORRUPTION";
    private static final String NSI_007_HAZARDOUS_REGION_PARAMETER = "HAZARDOUS_REGION";
    private static final String NSI_007_CODE_VALUTA_PARAMETER = "CODE_VALUTA";
    private static final String NSI_007_ISO_ALPHA3_CODE_PARAMETER = "ISO_ALPHA3_CODE";
    private static final String NSI_007_GROUP_COUNTRY_PARAMETER = "GROUP_COUNTRY";


    private static final String NSI_007_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String NSI_007_PRIMARY_KEY = "DIMID";
    private static final String NSI_007_DOMAIN = "nsi_007";

    @Autowired
    private Nsi007Service nsi007Service;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(NSI_007_DIRECTORY_PARAMETER, nsi007Service.get());
        model.addAttribute("domain", NSI_007_DOMAIN);
        model.addAttribute("primaryKey", NSI_007_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = NSI_007_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = NSI_007_CODE_PARAMETER) String code,
                               @RequestParam(value = NSI_007_NAME_PARAMETER) String name,
                               @RequestParam(value = NSI_007_NAME_SWIFT_PARAMETER) String nameSwift,
                               @RequestParam(value = NSI_007_BORDER_STATE_PARAMETER) String borderState,
                               @RequestParam(value = NSI_007_RATING_VALUTA_PARAMETER) String ratingValuta,
                               @RequestParam(value = NSI_007_CODE_SWIFT_PARAMETER) String codeSwift,
                               @RequestParam(value = NSI_007_RATING_NACVAL) String ratingNacval,
                               @RequestParam(value = NSI_007_SIGN_OESR_PARAMETER) String signOesr,
                               @RequestParam(value = NSI_007_OFFSHOR_ZONE_PARAMETER) String offshorZone,
                               @RequestParam(value = NSI_007_SIGN_EU_PARAMETER) String signEu,
                               @RequestParam(value = NSI_007_SIGNS_CORRUPTION_PARAMETER) String signsCorruption,
                               @RequestParam(value = NSI_007_HAZARDOUS_REGION_PARAMETER) String hazardousRegion,
                               @RequestParam(value = NSI_007_CODE_VALUTA_PARAMETER) String codeValuta,
                               @RequestParam(value = NSI_007_ISO_ALPHA3_CODE_PARAMETER) String isoAlpha3Code,
                               @RequestParam(value = NSI_007_GROUP_COUNTRY_PARAMETER) String groupCountry) {

        nsi007Service.create(Nsi007.builder()
                .code(code)
                .name(name)
                .nameSwift(nameSwift)
                .borderState(borderState)
                .ratingValuta(ratingValuta)
                .codeSwift(codeSwift)
                .ratingNacval(ratingNacval)
                .signOesr(signOesr)
                .offshorZone(offshorZone)
                .signEu(signEu)
                .signsCorruption(signsCorruption)
                .hazardousRegion(hazardousRegion)
                .codeValuta(codeValuta)
                .isoAlpha3Code(isoAlpha3Code)
                .groupCountry(groupCountry)
                .build()
        );
        return new RedirectView(request.getContextPath() + NSI_007_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = NSI_007_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return nsi007Service.update(Nsi007.fromJSON(data));
    }

    @RequestMapping(value = NSI_007_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return nsi007Service.remove(id);
    }

    private Map<String, String> getFieldsType() {
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(NSI_007_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_NAME_SWIFT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_BORDER_STATE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_RATING_VALUTA_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_CODE_SWIFT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_RATING_NACVAL, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_SIGN_OESR_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_OFFSHOR_ZONE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_SIGN_EU_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_SIGNS_CORRUPTION_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_HAZARDOUS_REGION_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_CODE_VALUTA_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(NSI_007_ISO_ALPHA3_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(NSI_007_GROUP_COUNTRY_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
