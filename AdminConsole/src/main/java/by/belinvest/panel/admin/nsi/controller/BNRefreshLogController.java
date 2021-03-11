package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.bn_refresh_log.BNRefreshLog;
import by.belinvest.panel.admin.nsi.service.BNRefreshLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/nsi/bn_refresh_log")
public class BNRefreshLogController {

    private static final String BN_REFRESH_LOG_CREATE_URL = "/create";
    private static final String BN_REFRESH_LOG_EDIT_URL = "/edit";
    private static final String BN_REFRESH_LOG_REMOVE_URL = "/remove";
    private static final String BN_REFRESH_LOG_DIRECTORY_GET_URL = "/nsi/bn_refresh_log";

    private static final String BN_REFRESH_LOG_NAME_PARAMETER = "NAME";
    private static final String BN_REFRESH_LOG_STARTDATE_PARAMETER = "STARTDATE";
    private static final String BN_REFRESH_LOG_ENDDATE_PARAMETER = "ENDDATE";
    private static final String BN_REFRESH_LOG_CNTRECINS_PARAMETER = "CNTRECINS";
    private static final String BN_REFRESH_LOG_CNTRECUPD_PARAMETER = "CNTRECUPD";
    private static final String BN_REFRESH_LOG_CNTRECDEL_PARAMETER = "CNTRECDEL";
    private static final String BN_REFRESH_LOG_NOTE_PARAMETER = "NOTE";

    private static final String BN_REFRESH_LOG_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BN_REFRESH_LOG_PRIMARY_KEY = "NAME";
    private static final String BN_REFRESH_LOG_DOMAIN = "bn_refresh_log";

    @Autowired
    private BNRefreshLogService bnRefreshLogService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(BN_REFRESH_LOG_DIRECTORY_PARAMETER, bnRefreshLogService.get());
        model.addAttribute("domain",BN_REFRESH_LOG_DOMAIN);
        model.addAttribute("primaryKey",BN_REFRESH_LOG_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = BN_REFRESH_LOG_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BN_REFRESH_LOG_STARTDATE_PARAMETER) String startDate,
                               @RequestParam(value = BN_REFRESH_LOG_ENDDATE_PARAMETER) String endDate,
                               @RequestParam(value = BN_REFRESH_LOG_CNTRECINS_PARAMETER) String cIns,
                               @RequestParam(value = BN_REFRESH_LOG_CNTRECUPD_PARAMETER) String cUpd,
                               @RequestParam(value = BN_REFRESH_LOG_CNTRECDEL_PARAMETER) String cDel,
                               @RequestParam(value = BN_REFRESH_LOG_NOTE_PARAMETER) String note) {

        bnRefreshLogService.create(BNRefreshLog.builder()
                .startDate(startDate)
                .endDate(endDate)
                .cntrecIns(cIns)
                .cntrecUpd(cUpd)
                .cntrecDel(cDel)
                .note(note)
                .build()
        );
        return new RedirectView(request.getContextPath() + BN_REFRESH_LOG_DIRECTORY_GET_URL);
    }
    @RequestMapping(value = BN_REFRESH_LOG_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        System.out.println(data);

        return bnRefreshLogService.update(BNRefreshLog.fromJSON(data));
    }

    @RequestMapping(value = BN_REFRESH_LOG_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return bnRefreshLogService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BN_REFRESH_LOG_STARTDATE_PARAMETER, FieldsType.DATE_FIELD_TYPE);
        fieldsMap.put(BN_REFRESH_LOG_ENDDATE_PARAMETER, FieldsType.DATE_FIELD_TYPE);
        fieldsMap.put(BN_REFRESH_LOG_CNTRECINS_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(BN_REFRESH_LOG_CNTRECUPD_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(BN_REFRESH_LOG_CNTRECDEL_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(BN_REFRESH_LOG_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
