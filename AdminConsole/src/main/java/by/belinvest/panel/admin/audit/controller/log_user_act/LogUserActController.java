package by.belinvest.panel.admin.audit.controller.log_user_act;

import by.belinvest.panel.admin.audit.controller.AuditLog;
import by.belinvest.panel.admin.audit.service.log_user_act.LogUserActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/audit/log_user_act")
public class LogUserActController implements AuditLog {

    private static final String DIRECTORY_PARAMETER = "logUserActDirectory";

    private final LogUserActService logUserActService;


    private final String DIRECTORY_PAGE = "audit/log_user_act";

    @Autowired
    public LogUserActController(LogUserActService logUserActService) {
        this.logUserActService = logUserActService;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String getLogUserActDirectory(Model model) {
        model.addAttribute(DIRECTORY_PARAMETER, logUserActService.get());
        return DIRECTORY_PAGE;
    }
}