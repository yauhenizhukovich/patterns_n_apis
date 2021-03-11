package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.spis_scan_doc.SpisScanDoc;
import by.belinvest.panel.admin.nsi.service.SpisScanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/spis_scan_doc")
public class SpisScanDocController {

    private static final String SPIS_SCAN_DOC_CREATE_URL = "/create";
    private static final String SPIS_SCAN_DOC_EDIT_URL = "/edit";
    private static final String SPIS_SCAN_DOC_REMOVE_URL = "/remove";
    private static final String SPIS_SCAN_DOC_DIRECTORY_GET_URL = "/nsi/spis_scan_doc";

    private static final String SPIS_SCAN_DOC_DIMID_PARAMETER = "DIMID";
    private static final String SPIS_SCAN_DOC_PARENTID_PARAMETER = "PARENTID";
    private static final String SPIS_SCAN_DOC_CODE_PARAMETER = "CODE";
    private static final String SPIS_SCAN_DOC_NAME_PARAMETER = "NAME";
    private static final String SPIS_SCAN_DOC_SCAN_PAC_PARAMETER = "SCAN_PAC";
    private static final String SPIS_SCAN_DOC_SCAN_TYPE_PARAMETER = "SCAN_TYPE";
    private static final String SPIS_SCAN_DOC_DZ_VID_ZAL_PARAMETER = "DZ_VID_ZAL";
    private static final String SPIS_SCAN_DOC_DZ_PREDMET_PARAMETER = "DZ_PREDMET";
    private static final String SPIS_SCAN_DOC_DZ_VID_OBESP_PARAMETER = "DZ_VID_OBESP";

    private static final String SPIS_SCAN_DOC_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String SPIS_SCAN_DOC_PRIMARY_KEY = "DIMID";
    private static final String SPIS_SCAN_DOC_DOMAIN = "spis_scan_doc";

    @Autowired
    private SpisScanDocService scanDocService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(SPIS_SCAN_DOC_DIRECTORY_PARAMETER, scanDocService.get());
        model.addAttribute("domain", SPIS_SCAN_DOC_DOMAIN);
        model.addAttribute("primaryKey", SPIS_SCAN_DOC_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = SPIS_SCAN_DOC_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = SPIS_SCAN_DOC_PARENTID_PARAMETER) String parentid,
                               @RequestParam(value = SPIS_SCAN_DOC_NAME_PARAMETER) String name,
                               @RequestParam(value = SPIS_SCAN_DOC_CODE_PARAMETER) String code,
                               @RequestParam(value = SPIS_SCAN_DOC_SCAN_PAC_PARAMETER) String scanPac,
                               @RequestParam(value = SPIS_SCAN_DOC_SCAN_TYPE_PARAMETER) String scanType,
                               @RequestParam(value = SPIS_SCAN_DOC_DZ_VID_ZAL_PARAMETER) String dzVidZal,
                               @RequestParam(value = SPIS_SCAN_DOC_DZ_PREDMET_PARAMETER) String dzPredmet,
                               @RequestParam(value = SPIS_SCAN_DOC_DZ_VID_OBESP_PARAMETER) String dzVidObesp) {

        scanDocService.create(SpisScanDoc.builder()
                .parentid(parentid)
                .code(code)
                .name(name)
                .scanPac(scanPac)
                .scanType(scanType)
                .dzVidZal(dzVidZal)
                .dzPredmet(dzPredmet)
                .dzVidObesp(dzVidObesp)
                .build()
        );
        return new RedirectView(request.getContextPath() + SPIS_SCAN_DOC_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = SPIS_SCAN_DOC_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return scanDocService.update(SpisScanDoc.fromJSON(data));
    }

    @RequestMapping(value = SPIS_SCAN_DOC_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return scanDocService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(SPIS_SCAN_DOC_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(SPIS_SCAN_DOC_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(SPIS_SCAN_DOC_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(SPIS_SCAN_DOC_SCAN_PAC_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(SPIS_SCAN_DOC_SCAN_TYPE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(SPIS_SCAN_DOC_DZ_VID_ZAL_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(SPIS_SCAN_DOC_DZ_PREDMET_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(SPIS_SCAN_DOC_DZ_VID_OBESP_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
