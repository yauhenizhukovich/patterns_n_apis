package by.belinvest.panel.admin.audit.controller.log_acc;

import by.belinvest.panel.admin.audit.service.log_acc.LogAccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/audit/log_acc")
public class LogAccController {

    private static final String DIRECTORY_PARAMETER = "logAccDirectory";

    private final LogAccService logAccService;


    private final String DIRECTORY_PAGE = "audit/log_acc";

    @Autowired
    public LogAccController(LogAccService logAccService) {
        this.logAccService = logAccService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getLogAccDirectory(Model model) {
        model.addAttribute(DIRECTORY_PARAMETER, logAccService.get());
        return DIRECTORY_PAGE;
    }

}