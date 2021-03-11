package by.belinvest.panel.admin.audit.controller.log_sys_event;

import by.belinvest.panel.admin.audit.service.log_sys_event.LogSysEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/audit/log_sys_event")
public class LogSysEventController {

    private static final String DIRECTORY_PARAMETER = "logSysEventDirectory";

    private final LogSysEventService logSysEventService;


    private  final String DIRECTORY_PAGE = "audit/log_sys_event";

    @Autowired
    public LogSysEventController(LogSysEventService logSysEventService) {
        this.logSysEventService = logSysEventService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getLogSysEventDirectory(Model model) {
        model.addAttribute(DIRECTORY_PARAMETER, logSysEventService.get());
        return DIRECTORY_PAGE;
    }

}