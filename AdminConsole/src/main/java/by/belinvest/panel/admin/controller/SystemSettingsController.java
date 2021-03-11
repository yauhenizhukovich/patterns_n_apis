package by.belinvest.panel.admin.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.Setting;
import by.belinvest.panel.admin.service.SystemSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SystemSettingsController {

    private static final String SYSTEM_SETTINGS_URL = "/system-settings";
    private static final String SAVE_SETTINGS_URL = "/save-settings";
    private static final String EDIT_SETTINGS_URL = "/edit-settings";
    private static final String GET_AUTH = "/get-auth";

    private String SYSTEM_SETTINGS_JSP_PAGE = "system-settings";

    private final SystemSettingsService settingsService;

    @Autowired
    public SystemSettingsController(SystemSettingsService settingsService) {
        this.settingsService = settingsService;
    }


    @RequestMapping(value = SYSTEM_SETTINGS_URL, method = RequestMethod.GET)
    public String getSystemSettingsPage(Model model) {
        List<Setting> setting = settingsService.getSettings();

        model.addAttribute("settingList", new ArrayList<>(setting));
        return SYSTEM_SETTINGS_JSP_PAGE;
    }

    @RequestMapping(value = EDIT_SETTINGS_URL, method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> editSetting(@RequestBody Setting setting, @RequestParam String settingId) {
        AjaxResponseBody result = null;
        try {
            settingsService.editSettings(setting,settingId);
        } catch (RuntimeException e) {
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("параметр успешно изменился");
        return ResponseEntity.ok().body(result);
    }


    @RequestMapping(value = SAVE_SETTINGS_URL, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addSetting(@RequestBody Setting setting) {
        AjaxResponseBody result = null;
        try {
            settingsService.saveSettings(setting);
        } catch (RuntimeException e) {
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Параметр успешно создался");
        return ResponseEntity.ok().body(result);
    }
}
