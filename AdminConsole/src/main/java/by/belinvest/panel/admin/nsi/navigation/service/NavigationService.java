package by.belinvest.panel.admin.nsi.navigation.service;

import by.belinvest.panel.admin.entity.nsi.Tables;
import by.belinvest.panel.admin.nsi.navigation.db.NavigationRepository;
import by.belinvest.panel.admin.util.Constants;
import javafx.scene.control.Tab;
import org.aspectj.apache.bcel.classfile.ConstantString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NavigationService {

    @Autowired
    private NavigationRepository navigationRepository;

    public Tables getTables() {

        List<String> sortedList = Constants.getList();

        
        Tables tables = navigationRepository.getTables();
        Map<String, String> map = tables.getTables();
        Map<String, String> sortedMap = new LinkedHashMap<>();
        sortedMap.put("business_line","Бизнес-направление");
        sortedMap.put("product_class","Класс продукта");
        sortedMap.put("product_group","Группа продукта");
        sortedMap.put("product_view","Вид продукта");
        sortedMap.put("product_subview","Подвид продукта");



        sortedMap.put("cred_product_line","Справочник линеек кредитных продуктов (для бизнес-направления = Корпоративный)");
        sortedMap.put("credfl_product_line","Справочник линеек кредитных продуктов (для бизнес-направления = Розничный)");
        sortedMap.put("card_product_line","Справочник линеек карточных продуктов (для бизнес-направления = Розничный)");

        sortedMap.put("dep_product_line","Справочник линеек депозитных продуктов (для бизнес-направления = Корпоративный)");
        sortedMap.put("depfl_product_line","Справочник линеек депозитных продуктов (для бизнес-направления = Розничный)");

        sortedMap.put("depfl_currency","Справочник валют депозита (для бизнес-направления = Розничный)");
        sortedMap.put("dep_currency","Справочник валют депозита (для бизнес-направления = Корпоративный)");

        sortedMap.put("depfl_terms","Справочник сроков депозита (для бизнес-направления = Розничный)");
        sortedMap.put("dep_terms","Справочник сроков депозита (для бизнес-направления = Корпоративный)");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sortedList.contains(entry.getKey())){
                sortedMap.put(entry.getKey(),entry.getValue());
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!sortedMap.containsKey(entry.getKey())){
                sortedMap.put(entry.getKey(),entry.getValue());
            }
        }
        tables.setTables(sortedMap);

        return tables;
    }
}
