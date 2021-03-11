package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.group_loan.GroupLoan;
import by.belinvest.panel.admin.nsi.service.GroupLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/group_loan")
public class GroupLoanController {
    private static final String GROUP_LOAN_CREATE_URL = "/create";
    private static final String GROUP_LOAN_EDIT_URL = "/edit";
    private static final String GROUP_LOAN_REMOVE_URL = "/remove";
    private static final String GROUP_LOAN_DIRECTORY_GET_URL = "/nsi/group_loan";

    private static final String GROUP_LOAN_DIMID_PARAMETER = "DIMID";
    private static final String GROUP_LOAN_PARENTID_PARAMETER = "PARENTID";
    private static final String GROUP_LOAN_CODE_PARAMETER = "CODE";
    private static final String GROUP_LOAN_NAME_PARAMETER = "NAME";

    private static final String GROUP_LOAN_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String GROUP_LOAN_PRIMARY_KEY = "DIMID";
    private static final String GROUP_LOAN_DOMAIN = "group_loan";

    @Autowired
    private GroupLoanService groupLoanService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(GROUP_LOAN_DIRECTORY_PARAMETER, groupLoanService.get());
        model.addAttribute("domain",GROUP_LOAN_DOMAIN);
        model.addAttribute("primaryKey",GROUP_LOAN_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = GROUP_LOAN_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = GROUP_LOAN_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = GROUP_LOAN_CODE_PARAMETER) String code,
                               @RequestParam(value = GROUP_LOAN_NAME_PARAMETER) String name){

        groupLoanService.create(GroupLoan.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + GROUP_LOAN_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = GROUP_LOAN_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return groupLoanService.update(GroupLoan.fromJSON(data));
    }

    @RequestMapping(value = GROUP_LOAN_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return groupLoanService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(GROUP_LOAN_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(GROUP_LOAN_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(GROUP_LOAN_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
