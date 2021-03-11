package by.belinvest.panel.admin.service;

import by.belinvest.panel.admin.entity.Setting;

import java.util.List;
import java.util.Set;

public interface SystemSettingsService {

    List<Setting> getSettings();

    boolean editSettings(Setting setting,String id);
    boolean saveSettings(Setting setting);

}
