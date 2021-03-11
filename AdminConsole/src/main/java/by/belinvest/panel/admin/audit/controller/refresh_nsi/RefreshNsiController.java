package by.belinvest.panel.admin.audit.controller.refresh_nsi;

import by.belinvest.panel.admin.audit.service.refresh_nsi.LastUpdateService;
import by.belinvest.panel.admin.audit.service.refresh_nsi.RefreshNsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/audit/refresh_nsi")
public class RefreshNsiController {

    @Autowired
    private RefreshNsiService refreshNsiService;

    @Autowired
    private LastUpdateService lastUpdateService;

    private static final String REFRESH_NSI_URL = "/refresh";
    private static final String REFRESH_NSI_MAIN_URL = "/audit/refresh_nsi";
    private static final String REFRESH_NSI_DOMAIN = "refresh_nsi";


    private final String REFRESH_NSI_PAGE = "audit/refresh_nsi";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("domain", REFRESH_NSI_DOMAIN);
        model.addAttribute("lastUpdateTime", lastUpdateService.getLastUpdateDate());
        return REFRESH_NSI_PAGE;
    }
//
//    private String getCurrentDate(){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        return dtf.format(now);
//    }

    @RequestMapping(value = REFRESH_NSI_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request, Model model) {
        refreshNsiService.refreshNsi();
        return new RedirectView(request.getContextPath() + REFRESH_NSI_MAIN_URL);
    }

}
