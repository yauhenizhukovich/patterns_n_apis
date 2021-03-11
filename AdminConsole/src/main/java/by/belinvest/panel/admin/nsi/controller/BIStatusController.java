package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.bi_status.BIStatus;
import by.belinvest.panel.admin.nsi.service.BIStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
    @RequestMapping(value = "/nsi/bi_status")
    public class BIStatusController {

        private static final String BI_STATUS_CREATE_URL = "/create";
        private static final String BI_STATUS_EDIT_URL = "/edit";
        private static final String BI_STATUS_REMOVE_URL = "/remove";
        private static final String BI_STATUS_DIRECTORY_GET_URL = "/nsi/bi_status";

        private static final String BI_STATUS_CODE_PARAMETER = "CODE";
        private static final String BI_STATUS_NAME_PARAMETER = "NAME";

        private static final String BI_STATUS_DIRECTORY_PARAMETER = "directoryDTO";
        private static final String BI_STATUS_PRIMARY_KEY = "CODE";
        private static final String BI_STATUS_DOMAIN = "bi_status";

        @Autowired
        private BIStatusService biStatusService;

        private String DIRECTORY_PAGE = "nsi/directory";

        @RequestMapping(method = RequestMethod.GET)
        public String get(Model model) {
            model.addAttribute(BI_STATUS_DIRECTORY_PARAMETER, biStatusService.get());
            model.addAttribute("domain", BI_STATUS_DOMAIN);
            model.addAttribute("primaryKey", BI_STATUS_PRIMARY_KEY);
            model.addAttribute("fields", getFieldsType());
            model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
        }

        @RequestMapping(value = BI_STATUS_CREATE_URL, method = RequestMethod.POST)
        public RedirectView create(HttpServletRequest request,
                                   @RequestParam(value = BI_STATUS_NAME_PARAMETER) String name) {

            biStatusService.create(BIStatus.builder()
                    .name(name)
                    .build()
            );
            return new RedirectView(request.getContextPath() + BI_STATUS_DIRECTORY_GET_URL);
        }

        @RequestMapping(value = BI_STATUS_EDIT_URL, method = RequestMethod.POST)
        @ResponseBody
        public boolean edit(@RequestBody HashMap<String, String> data) {
            return biStatusService.update(BIStatus.fromJSON(data));
        }

        @RequestMapping(value = BI_STATUS_REMOVE_URL, method = RequestMethod.POST)
        @ResponseBody
        public boolean remove(@RequestBody String id) {
            return biStatusService.remove(id);
        }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BI_STATUS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }

    }