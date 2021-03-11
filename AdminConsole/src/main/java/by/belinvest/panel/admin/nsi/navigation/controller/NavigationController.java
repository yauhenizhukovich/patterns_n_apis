package by.belinvest.panel.admin.nsi.navigation.controller;

import by.belinvest.panel.admin.nsi.navigation.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/nsi")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;


    private final  String NSI_BANK_DIRECTORY_PAGE = "nsi/main_nsi";

    @RequestMapping(method = RequestMethod.GET)
    public String getBankDirectory(Model model) {
        model.addAttribute("tablesDescription", navigationService.getTables());
        return NSI_BANK_DIRECTORY_PAGE;
    }
}
