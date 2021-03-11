package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.nsi.bank.Bank;
import by.belinvest.panel.admin.nsi.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/nsi/banks")
public class BankController {

    private static final String BANK_CREATE_URL = "/create";
    private static final String BANK_EDIT_URL = "/edit";
    private static final String BANK_REMOVE_URL = "/remove";
    private static final String BANK_DIRECTORY_GET_URL = "/nsi/banks";

    private static final String BANK_CODE_PARAMETER = "code";
    private static final String BANK_NAME_PARAMETER = "name";
    private static final String BANK_PRYAM_PARAMETER = "banksPryam";
    private static final String BANK_REGION_PARAMETER = "banksRegion";
    private static final String BANK_OLD_CODE_PARAMETER = "banksOldCode";
    private static final String BANK_BICISO_PARAMETER = "banksBiciso";
    private static final String BANK_RANG_PARAMETER = "banksRang";
    private static final String BANK_KOD_GB_PARAMETER = "banksKodGb";
    private static final String BANK_KOD_AUTU_PARAMETER = "banksKodAutu";
    private static final String BANK_ADDRESS_PARAMETER = "banksAddress";
    private static final String BANK_KOD_TYPE_PARAMETER = "banksKodType";
    private static final String BANK_KOD_SOATO_PARAMETER = "banksKodSoato";
    private static final String BANK_KOD_STATUS_PARAMETER = "banksKodStatu";
    private static final String BANK_PHONE_PARAMETER = "banksPhone";

    private static final String BANK_DIRECTORY_PARAMETER = "bankDirectory";

    private final BankService bankService;


    private final String NSI_BANK_DIRECTORY_PAGE = "nsi/banks";

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getBankDirectory(Model model) {
        model.addAttribute(BANK_DIRECTORY_PARAMETER, bankService.get());
        return NSI_BANK_DIRECTORY_PAGE;
    }

    @RequestMapping(value = BANK_CREATE_URL, method = RequestMethod.POST)
    public RedirectView createBankEntry(HttpServletRequest request,
                                        @RequestParam(value = BANK_CODE_PARAMETER) String code,
                                        @RequestParam(value = BANK_NAME_PARAMETER) String name,
                                        @RequestParam(value = BANK_PRYAM_PARAMETER, required = false) String banksPryam,
                                        @RequestParam(value = BANK_REGION_PARAMETER, required = false) String banksRegion,
                                        @RequestParam(value = BANK_OLD_CODE_PARAMETER, required = false) String banksOldCode,
                                        @RequestParam(value = BANK_BICISO_PARAMETER, required = false) String banksBiciso,
                                        @RequestParam(value = BANK_RANG_PARAMETER, required = false) String banksRang,
                                        @RequestParam(value = BANK_KOD_GB_PARAMETER, required = false) String banksKodGb,
                                        @RequestParam(value = BANK_KOD_AUTU_PARAMETER, required = false) String banksKodAutu,
                                        @RequestParam(value = BANK_ADDRESS_PARAMETER, required = false) String banksAddress,
                                        @RequestParam(value = BANK_KOD_TYPE_PARAMETER, required = false) String banksKodType,
                                        @RequestParam(value = BANK_KOD_SOATO_PARAMETER, required = false) String banksKodSoato,
                                        @RequestParam(value = BANK_KOD_STATUS_PARAMETER, required = false) String banksKodStatu,
                                        @RequestParam(value = BANK_PHONE_PARAMETER, required = false) String banksPhone) {

        bankService.create(new Bank(
                null,
                code,
                name,
                banksPryam,
                banksRegion,
                banksOldCode,
                banksBiciso,
                banksRang,
                banksKodGb,
                banksKodAutu,
                banksAddress,
                banksKodType,
                banksKodSoato,
                banksKodStatu,
                banksPhone)
        );

        return new RedirectView(request.getContextPath() + BANK_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BANK_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean editBankDirectoryEntries(@RequestBody Bank bank) {

        return bankService.update(bank);
    }

    @RequestMapping(value = BANK_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean removeBankDirectory(@RequestBody String id) {

        return bankService.remove(id);
    }

}
