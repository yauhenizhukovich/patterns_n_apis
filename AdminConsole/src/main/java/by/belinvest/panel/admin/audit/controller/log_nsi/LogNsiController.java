package by.belinvest.panel.admin.audit.controller.log_nsi;

import by.belinvest.panel.admin.audit.service.log_nsi.LogNsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/audit/log_nsi")
public class LogNsiController {


    private static final String LOG_NSI_DIRECTORY = "logNsiDirectory";

    private final LogNsiService logNsiService;

    private final String DIRECTORY_PAGE = "audit/log_nsi";

    @Autowired
    public LogNsiController(LogNsiService logNsiService) {
        this.logNsiService = logNsiService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getLogNsiDirectory(Model model) {
        model.addAttribute(LOG_NSI_DIRECTORY, logNsiService.getLogNsi());
        return DIRECTORY_PAGE;
    }

}

