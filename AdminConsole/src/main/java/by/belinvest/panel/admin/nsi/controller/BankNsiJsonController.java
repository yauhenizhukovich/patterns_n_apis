package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.nsi.bank_nsi_json.BankNsiJson;
import by.belinvest.panel.admin.nsi.service.BankNsiJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/nsi/bank_nsi_json")
public class BankNsiJsonController {

    private static final String BANK_NSI_JSON_CREATE_URL = "/create";
    private static final String BANK_NSI_JSON_EDIT_URL = "/edit";
    private static final String BANK_NSI_JSON_REMOVE_URL = "/remove";
    private static final String BANK_NSI_JSON_GET_URL = "/nsi/bank_nsi_json";

    private static final String BANK_NSI_JSON_ID_PARAMETER = "ID";
    private static final String BANK_NSI_JSON_JSON_TABLE_PARAMETER = "JSON_TABLE";
    private static final String BANK_NSI_JSON_NOTE_PARAMETER = "NOTE";
    private static final String BANK_NSI_JSON_NAME_PARAMETER = "NAME";
    private static final String BANK_NSI_JSON_DATE_LOAD_PARAMETER = "DATE_LOAD";
    private static final String BANK_NSI_JSON_URL_SRV_PARAMETER = "URL_SRV";
    private static final String BANK_NSI_JSON_XML_TABLE_PARAMETER = "XML_TABLE";
    private static final String BANK_NSI_JSON_SQL_TEXT_PARAMETER = "SQL_TEXT";

    private static final String BANK_NSI_JSON_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BANK_NSI_JSON_PRIMARY_KEY = "ID";
    private static final String BANK_NSI_JSON_DOMAIN = "bank_nsi_json";

    @Autowired
    private BankNsiJsonService bankNsiJsonService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(BANK_NSI_JSON_DIRECTORY_PARAMETER, bankNsiJsonService.get());
        model.addAttribute("domain",BANK_NSI_JSON_DOMAIN);
        model.addAttribute("primaryKey",BANK_NSI_JSON_PRIMARY_KEY);
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = BANK_NSI_JSON_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BANK_NSI_JSON_JSON_TABLE_PARAMETER) String jsonTable,
                               @RequestParam(value = BANK_NSI_JSON_NAME_PARAMETER) String name,
                               @RequestParam(value = BANK_NSI_JSON_NOTE_PARAMETER) String note,
                               @RequestParam(value = BANK_NSI_JSON_URL_SRV_PARAMETER) String urlSvr,
                               @RequestParam(value = BANK_NSI_JSON_DATE_LOAD_PARAMETER) String dateLoad,
                               @RequestParam(value = BANK_NSI_JSON_XML_TABLE_PARAMETER) String xmlTable,
                               @RequestParam(value = BANK_NSI_JSON_SQL_TEXT_PARAMETER) String sqlText) {

        bankNsiJsonService.create(BankNsiJson.builder()
                .dateLoad(dateLoad)
                .jsonTable(jsonTable)
                .name(name)
                .note(note)
                .sqlText(sqlText)
                .urlSrv(urlSvr)
                .xmlTable(xmlTable)
                .build()
        );
        return new RedirectView(request.getContextPath() + BANK_NSI_JSON_GET_URL);
    }

    @RequestMapping(value = BANK_NSI_JSON_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return bankNsiJsonService.update(BankNsiJson.fromJSON(data));
    }

    @RequestMapping(value = BANK_NSI_JSON_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return bankNsiJsonService.remove(id);
    }
}

