package by.belinvest.panel.admin.product.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.product.ProductGroup;
import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import by.belinvest.panel.admin.product.dto.LevelHierarchyDTO;
import by.belinvest.panel.admin.product.service.LevelHierarchyService;
import by.belinvest.panel.admin.product.service.ProductGroupService;
import by.belinvest.panel.admin.product.service.ProductHierarchyService;
import by.belinvest.panel.admin.product.service.ValidateService;
import by.belinvest.panel.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/product_hierarchy")
public class ProductHierarchyController {
    private static final String GET_PRODUCT_HIERARCHY_VIEW = "product/product_hierarchy";
    private static final String GET_USERS_URL_JSON = "/get_user_names";

    @Autowired
    private ProductHierarchyService productHierarchyService;
    @Autowired
    private ProductGroupService productGroupService;
    @Autowired
    private LevelHierarchyService levelHierarchyService;
    @Autowired
    private ValidateService validateService;


    @RequestMapping(method = RequestMethod.GET,value = "/by_group")
    public String getGetProductHierarchyByGroup(Model model, @RequestParam(required = false) Long firstLevelProductGroup,
                                                @RequestParam(required = false) Long secondLevelProductGroup,
                                                @RequestParam(required = false) Long thirdLevelProductGroup)
    {
        model.addAttribute("productGroups",productGroupService.getProductGroupTreeDTOList());
        model.addAttribute("productHierarchyList",productHierarchyService.getProductHierarchyByProductGroups(firstLevelProductGroup,secondLevelProductGroup,thirdLevelProductGroup));

        return GET_PRODUCT_HIERARCHY_VIEW;
    }

    @GetMapping
    public String getProductHierarchy(Model model){
        model.addAttribute("productGroups",productGroupService.getProductGroupTreeDTOList());
        model.addAttribute("productHierarchyList",productHierarchyService.getProductHierarchyByProductGroups(null,null,null));
        return GET_PRODUCT_HIERARCHY_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/group_data")
    @ResponseBody
    public LevelHierarchyDTO getHierarchyLevel(@RequestBody Map<String,String> parameters){
        return levelHierarchyService.getLevelHierarchy(Long.parseLong(parameters.get("productGroupId")));
    }

    @RequestMapping(method = RequestMethod.POST,value = "/create")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ProductHierarchy productHierarchy){

        AjaxResponseBody result = null;
        boolean response;
        try {
            productHierarchy.setUserId(0);
            response =  true;
            if (productHierarchy.getId() == null) {
                productHierarchyService.create(productHierarchy);
            }else {
                productHierarchyService.update(productHierarchy);
            }

        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        if (!response){
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/validate_create")
    @ResponseBody
    public String validateCreate(@RequestBody Map<String,String> parameters){
        return validateService.validateCreateProductHierarchy(
                Long.parseLong(parameters.get("productGroupId")),
                Long.parseLong(parameters.get("lineId")),
                Integer.parseInt(parameters.get("activity"))
        );
    }
    @RequestMapping(method = RequestMethod.POST,value = "/validate_update")
    @ResponseBody
    public String validateUpdate(@RequestBody Map<String,String> parameters){
        return validateService.validateUpdateProductHierarchy(
                Long.parseLong(parameters.get("productGroupId")),
                Long.parseLong(parameters.get("lineId")),
                Integer.parseInt(parameters.get("activity")),
                Long.parseLong(parameters.get("id"))
        );
    }


    @RequestMapping(method = RequestMethod.POST,value = "/get_hierarchy_by_name")
    @ResponseBody
    public boolean getProductHierarchyByName(@RequestBody ProductGroup productGroup){
        List<ProductHierarchy> list = productHierarchyService.getProductHierarchyByName(productGroup.getName());
        return list.isEmpty();
    }

}
