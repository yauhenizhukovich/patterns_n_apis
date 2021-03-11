package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.entity.catalog.BPCard;
import by.belinvest.panel.admin.entity.nsi.dep_product_line.DepProductLine;
import by.belinvest.panel.admin.entity.nsi.depfl_product_line.DepflProductLine;
import by.belinvest.panel.admin.nsi.service.DepflProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/depfl_product_line")
public class DepflProductLineController {
    private static final String DEPFL_PRODUCT_LINE_CREATE_URL = "/create";
    private static final String DEPFL_PRODUCT_LINE_EDIT_URL = "/edit";
    private static final String DEPFL_PRODUCT_LINE_REMOVE_URL = "/remove";
    private static final String DEPFL_PRODUCT_LINE_DIRECTORY_GET_URL = "/nsi/depfl_product_line";

    private static final String DEPFL_PRODUCT_LINE_CODE_PARAMETER = "CODE";
    private static final String DEPFL_PRODUCT_LINE_NAME_PARAMETER = "NAME";

    private static final String DEPFL_PRODUCT_LINE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String DEPFL_PRODUCT_LINE_PRIMARY_KEY = "CODE";
    private static final String DEPFL_PRODUCT_LINE_DOMAIN = "depfl_product_line";

    @Autowired
    private DepflProductLineService depflProductLineService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(DEPFL_PRODUCT_LINE_DIRECTORY_PARAMETER, depflProductLineService.get());
        model.addAttribute("domain",DEPFL_PRODUCT_LINE_DOMAIN);
        model.addAttribute("primaryKey",DEPFL_PRODUCT_LINE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = DEPFL_PRODUCT_LINE_CREATE_URL, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody HashMap<String,String> map) {
        AjaxResponseBody result = null;
        try {
            depflProductLineService.create(DepflProductLine.builder()
                            .name(map.get("name"))
                            .build(),
                    map.get("textarea")
            );
        }catch (Exception e){
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = DEPFL_PRODUCT_LINE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return depflProductLineService.update(DepflProductLine.fromJSON(data));
    }

    @RequestMapping(value = DEPFL_PRODUCT_LINE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return depflProductLineService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(DEPFL_PRODUCT_LINE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }

    @RequestMapping(value = "/get-pbCard", method = RequestMethod.GET)
    @ResponseBody
    public List<BPCard> getPbCard()  {
        return depflProductLineService.getBPCard();
    }

    @RequestMapping(value = "/get-pbCard2", method = RequestMethod.GET)
    @ResponseBody
    public List<BPCard> getPbCard2()  {
        return depflProductLineService.getBPCard2();
    }



    @RequestMapping(value = "/get-pbCard-by-nsi-id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BPCard getPbCard(@PathVariable String id)  {
        return depflProductLineService.getBPCardById(id);
    }


}
