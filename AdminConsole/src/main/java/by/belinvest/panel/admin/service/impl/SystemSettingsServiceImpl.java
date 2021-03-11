package by.belinvest.panel.admin.service.impl;

import by.belinvest.panel.admin.settings.db.SystemSettingsRepository;
import by.belinvest.panel.admin.entity.Setting;
import by.belinvest.panel.admin.service.SystemSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SystemSettingsServiceImpl implements SystemSettingsService {

    @Autowired
    private  SystemSettingsRepository settingsRepository;



    @Override
    public List<Setting> getSettings() {
        return settingsRepository.getSettings();
    }


    @Override
    public boolean editSettings(Setting setting,String id) {
        return settingsRepository.editSettings(setting,id);
    }

    @Override
    public boolean saveSettings(Setting setting) {
        return settingsRepository.saveSettings(setting);
    }
}
