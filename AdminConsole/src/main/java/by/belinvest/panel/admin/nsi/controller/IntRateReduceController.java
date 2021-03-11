package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.int_rate_reduce.IntRateReduce;
import by.belinvest.panel.admin.nsi.service.IntRateReduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/int_rate_reduce")
public class IntRateReduceController {
    private static final String INT_RATE_REDUCE_CREATE_URL = "/create";
    private static final String INT_RATE_REDUCE_EDIT_URL = "/edit";
    private static final String INT_RATE_REDUCE_REMOVE_URL = "/remove";
    private static final String INT_RATE_REDUCE_DIRECTORY_GET_URL = "/nsi/int_rate_reduce";

    private static final String INT_RATE_REDUCE_ID_PARAMETER = "ID";
    private static final String INT_RATE_REDUCE_NOTE_PARAMETER = "NOTE";
    private static final String INT_RATE_REDUCE_CODE_PARAMETER = "CODE";
    private static final String INT_RATE_REDUCE_NAME_PARAMETER = "NAME";

    private static final String INT_RATE_REDUCE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String INT_RATE_REDUCE_PRIMARY_KEY = "ID";
    private static final String INT_RATE_REDUCE_DOMAIN = "int_rate_reduce";

    @Autowired
    private IntRateReduceService intRateReduceService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(INT_RATE_REDUCE_DIRECTORY_PARAMETER, intRateReduceService.get());
        model.addAttribute("domain",INT_RATE_REDUCE_DOMAIN);
        model.addAttribute("primaryKey",INT_RATE_REDUCE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = INT_RATE_REDUCE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = INT_RATE_REDUCE_NOTE_PARAMETER) String note,
                               @RequestParam(value = INT_RATE_REDUCE_CODE_PARAMETER) String code,
                               @RequestParam(value = INT_RATE_REDUCE_NAME_PARAMETER) String name){

        intRateReduceService.create(IntRateReduce.builder()
                .note(note)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + INT_RATE_REDUCE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = INT_RATE_REDUCE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return intRateReduceService.update(IntRateReduce.fromJSON(data));
    }

    @RequestMapping(value = INT_RATE_REDUCE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return intRateReduceService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(INT_RATE_REDUCE_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(INT_RATE_REDUCE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(INT_RATE_REDUCE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
