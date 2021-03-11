package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.SendProductView;
import by.belinvest.panel.admin.entity.ViewDto;
import by.belinvest.panel.admin.nsi.service.CurrencyService;
import by.belinvest.panel.admin.nsi.service.StatusProdService;
import by.belinvest.panel.admin.product.service.ProductGroupService;
import by.belinvest.panel.admin.product.service.ProductService;
import by.belinvest.panel.admin.product.service.TreeForUpdateService;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/nsi/product_subview")
public class ProductSubViewController {
    @Autowired
    private ProductGroupService productGroupService;

    @Autowired
    private TreeForUpdateService treeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StatusProdService statusProdService;

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model) {
        model.addAttribute("productGroups",productGroupService.getFifthLevelGroups());
        model.addAttribute("tree", treeService.getFifthTree(null,null,null,null,null,null,null));
        model.addAttribute("currencyList",currencyService.get());
        model.addAttribute("statusList",statusProdService.get());
        return "nsi/product_subview";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/create")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody SendProductView sendProductView){
        AjaxResponseBody result = null;

        try {
            productGroupService.createProductView(sendProductView);
        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            e.printStackTrace();
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody SendProductView sendProductView,@PathVariable String id){
        AjaxResponseBody result = null;

        try {

            productGroupService.updateProductView(sendProductView,Integer.parseInt(id));
        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Успешно изменено");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        AjaxResponseBody result = null;

        try {
            productGroupService.deleteProductView(id);
        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Успешно удалено");
        return ResponseEntity.ok().body(result);
    }

    private String getValueFromJsonStr(String str, String fieldName){
        JsonElement root = new JsonParser().parse(str);
        JsonElement value = root.getAsJsonObject().get(fieldName);
        return value.getAsString();
    }
}
