package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.nsi.balans2.Balans2;
import by.belinvest.panel.admin.nsi.service.Balans2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/nsi/balans2")
public class Balans2Controller {


    private static final String BALANS2_CREATE_URL = "/create";
    private static final String BALANS2_EDIT_URL = "/edit";
    private static final String BALANS2_REMOVE_URL = "/remove";
    private static final String BALANS2_DIRECTORY_GET_URL = "/nsi/balans2";

    private static final String BALANS_DIM_ID_PARAMETER = "dimId";
    private static final String BALANS_SCODE_1_PARAMETER = "scode1";
    private static final String BALANS_SCODE_2_PARAMETER = "scode2";
    private static final String BALANS_SCODE_3_PARAMETER = "scode3";
    private static final String BALANS_SCODE_4_PARAMETER = "scode4";
    private static final String BALANS_NAME_PARAMETER = "name";
    private static final String BALANS_ACC_AP_PARAMETER = "accAp";
    private static final String BALANS_ACC_OP_PARAMETER = "accOc";
    private static final String BALANS_ACC_PN_PARAMETER = "accPn";
    private static final String BALANS_AUDIT_CODE_PARAMETER = "auditCode";
    private static final String BALANS_BL_CL_BANK_PARAMETER = "blClBank";
    private static final String BALANS_BL_DEFAULT_PARAMETER = "blDefault";
    private static final String BALANS_BL_FORM_NAME_PARAMETER = "blFormName";
    private static final String BALANS_BL_NO_PARAMETER = "blNo";
    private static final String BALANS_BL_REQU_PARAMETER = "blRequ";
    private static final String BALANS_CA_OC_PARAMETER = "caOc";
    private static final String BALANS_RA_OC_PARAMETER = "raOc";
    private static final String BALANS_CLOSE_PARAMETER = "close";

    private static final String BALANS2_DIRECTORY_PARAMETER = "balans2Directory";

    private final Balans2Service balans2Service;

    private String NSI_BALANS2_DIRECTORY_PAGE = "nsi/balans2";

    @Autowired
    public Balans2Controller(Balans2Service balans2Service) {
        this.balans2Service = balans2Service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getBalans2Directory(Model model) {
        model.addAttribute(BALANS2_DIRECTORY_PARAMETER, balans2Service.get());

        return NSI_BALANS2_DIRECTORY_PAGE;
    }

    @RequestMapping(value = BALANS2_CREATE_URL, method = RequestMethod.POST)
    public RedirectView createBalans2Entry(HttpServletRequest request,
                                           @RequestParam(value = BALANS_DIM_ID_PARAMETER) String dimId,
                                           @RequestParam(value = BALANS_SCODE_1_PARAMETER) String scode1,
                                           @RequestParam(value = BALANS_SCODE_2_PARAMETER) String scode2,
                                           @RequestParam(value = BALANS_SCODE_3_PARAMETER) String scode3,
                                           @RequestParam(value = BALANS_SCODE_4_PARAMETER) String scode4,
                                           @RequestParam(value = BALANS_NAME_PARAMETER, required = false) String name,
                                           @RequestParam(value = BALANS_ACC_AP_PARAMETER, required = false) String accAp,
                                           @RequestParam(value = BALANS_ACC_OP_PARAMETER, required = false) String accOc,
                                           @RequestParam(value = BALANS_ACC_PN_PARAMETER, required = false) String accPn,
                                           @RequestParam(value = BALANS_AUDIT_CODE_PARAMETER, required = false) String auditCode,
                                           @RequestParam(value = BALANS_BL_CL_BANK_PARAMETER, required = false) String blClBank,
                                           @RequestParam(value = BALANS_BL_DEFAULT_PARAMETER, required = false) String blDefault,
                                           @RequestParam(value = BALANS_BL_FORM_NAME_PARAMETER, required = false) String blFormName,
                                           @RequestParam(value = BALANS_BL_NO_PARAMETER, required = false) String blNo,
                                           @RequestParam(value = BALANS_BL_REQU_PARAMETER, required = false) String blRequ,
                                           @RequestParam(value = BALANS_CA_OC_PARAMETER, required = false) String caOc,
                                           @RequestParam(value = BALANS_RA_OC_PARAMETER, required = false) String raOc,
                                           @RequestParam(value = BALANS_CLOSE_PARAMETER, required = false) String close) {

        balans2Service.create(new Balans2(
                null,
                dimId,
                scode1,
                scode2,
                scode3,
                scode4,
                name,
                accAp,
                accOc,
                accPn,
                auditCode,
                blClBank,
                blDefault,
                blFormName,
                blNo,
                blRequ,
                caOc,
                raOc,
                close)
        );

        return new RedirectView(request.getContextPath() + BALANS2_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BALANS2_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean editBalans2DirectoryEntries(@RequestBody Balans2 balans2) {

        return balans2Service.update(balans2);
    }

    @RequestMapping(value = BALANS2_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean removeBalans2Directory(@RequestBody String id) {

        return balans2Service.remove(id);
    }

}
