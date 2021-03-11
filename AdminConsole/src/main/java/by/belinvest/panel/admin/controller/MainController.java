package by.belinvest.panel.admin.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class MainController {

    private static final String MAIN_PAGE_URL = "/";
    private static final String GET_AUTH = "/get-auth";

    private String MAIN_JSP_PAGE = "index";

    @RequestMapping(value = MAIN_PAGE_URL, method = RequestMethod.GET)
    public String getMainPage() {
        return MAIN_JSP_PAGE;
    }

}
