package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.freq_issue.FreqIssue;
import by.belinvest.panel.admin.nsi.service.FreqIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/freq_issue")
public class FreqIssueController {
    private static final String FREQ_ISSUE_CREATE_URL = "/create";
    private static final String FREQ_ISSUE_EDIT_URL = "/edit";
    private static final String FREQ_ISSUE_REMOVE_URL = "/remove";
    private static final String FREQ_ISSUE_DIRECTORY_GET_URL = "/nsi/freq_issue";

    private static final String FREQ_ISSUE_ID_PARAMETER = "ID";
    private static final String FREQ_ISSUE_CODE_PARAMETER = "CODE";
    private static final String FREQ_ISSUE_NAME_PARAMETER = "NAME";
    private static final String FREQ_ISSUE_NOTE_PARAMETER = "NOTE";


    private static final String FREQ_ISSUE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String FREQ_ISSUE_PRIMARY_KEY = "ID";
    private static final String FREQ_ISSUE_DOMAIN = "freq_issue";

    @Autowired
    private FreqIssueService freqIssueService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(FREQ_ISSUE_DIRECTORY_PARAMETER, freqIssueService.get());
        model.addAttribute("domain", FREQ_ISSUE_DOMAIN);
        model.addAttribute("primaryKey", FREQ_ISSUE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = FREQ_ISSUE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = FREQ_ISSUE_CODE_PARAMETER) String code,
                               @RequestParam(value = FREQ_ISSUE_NAME_PARAMETER) String name,
                               @RequestParam(value = FREQ_ISSUE_NOTE_PARAMETER) String note) {

        freqIssueService.create(FreqIssue.builder()
                .code(code)
                .name(name)
                .note(note)
                .build()
        );
        return new RedirectView(request.getContextPath() + FREQ_ISSUE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = FREQ_ISSUE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return freqIssueService.update(FreqIssue.fromJSON(data));
    }

    @RequestMapping(value = FREQ_ISSUE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return freqIssueService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(FREQ_ISSUE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(FREQ_ISSUE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(FREQ_ISSUE_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}