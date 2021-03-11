package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.nsi.dep_currency.DepCurrency;
import by.belinvest.panel.admin.entity.nsi.dep_product_line.DepProductLine;
import by.belinvest.panel.admin.nsi.db.CredProdLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/nsi/cred_product_line")
public class CredProductLineController {
    private static final String DEPFL_PRODUCT_LINE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String DEPFL_PRODUCT_LINE_EDIT_URL = "/edit";
    private static final String DEPFL_PRODUCT_LINE_REMOVE_URL = "/remove";

    @Autowired
    private CredProdLineRepository credProdLineRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        System.out.println("controller1");
        model.addAttribute(DEPFL_PRODUCT_LINE_DIRECTORY_PARAMETER, credProdLineRepository.get());
        System.out.println("controller2");

        return "nsi/credProdLine";
    }



    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {
            DepProductLine depProductLine =  DepProductLine.builder()
                    .name(map.get("name"))
                    .build();

            //  listRepository.create(depProductLine,textAreaNsi);
            credProdLineRepository.create(depProductLine,map.get("textAreaNsi"));

        }catch (Exception e){
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.ok().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = DEPFL_PRODUCT_LINE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return credProdLineRepository.update(DepProductLine.fromJSON(data));
    }

    @RequestMapping(value = DEPFL_PRODUCT_LINE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return credProdLineRepository.remove(id);
    }



}
