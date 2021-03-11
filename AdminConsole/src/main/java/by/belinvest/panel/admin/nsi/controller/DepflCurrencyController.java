package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.dep_currency.DepCurrency;
import by.belinvest.panel.admin.entity.nsi.depfl_currency.DepflCurrency;
import by.belinvest.panel.admin.nsi.service.DepflCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/depfl_currency")
public class DepflCurrencyController {
    private static final String DEPFL_CURRENCY_CREATE_URL = "/create";
    private static final String DEPFL_CURRENCY_EDIT_URL = "/edit";
    private static final String DEPFL_CURRENCY_REMOVE_URL = "/remove";
    private static final String DEPFL_CURRENCY_DIRECTORY_GET_URL = "/nsi/depfl_currency";

    private static final String DEPFL_CURRENCY_CODE_PARAMETER = "CODE";
    private static final String DEPFL_CURRENCY_NAME_PARAMETER = "NAME";

    private static final String DEPFL_CURRENCY_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String DEPFL_CURRENCY_PRIMARY_KEY = "CODE";
    private static final String DEPFL_CURRENCY_DOMAIN = "depfl_currency";

    @Autowired
    private DepflCurrencyService depflCurrencyService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(DEPFL_CURRENCY_DIRECTORY_PARAMETER, depflCurrencyService.get());
        model.addAttribute("domain",DEPFL_CURRENCY_DOMAIN);
        model.addAttribute("primaryKey",DEPFL_CURRENCY_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {
            depflCurrencyService.create(DepflCurrency.builder()
                    .name(map.get("name"))
                    .build());
        }catch (Exception e){
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.ok().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = DEPFL_CURRENCY_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return depflCurrencyService.update(DepflCurrency.fromJSON(data));
    }

    @RequestMapping(value = DEPFL_CURRENCY_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return depflCurrencyService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(DEPFL_CURRENCY_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
