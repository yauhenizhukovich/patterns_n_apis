package by.belinvest.panel.admin.product.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.product.ProductGroup;
import by.belinvest.panel.admin.product.controller.model.Data;
import by.belinvest.panel.admin.product.dto.LevelUpdateData;
import by.belinvest.panel.admin.product.dto.ProductLine;
import by.belinvest.panel.admin.product.service.ProductGroupService;
import by.belinvest.panel.admin.product.service.ProductHierarchyService;
import by.belinvest.panel.admin.product.service.ProductService;
import by.belinvest.panel.admin.product.service.ProductSynchronizer;
import by.belinvest.panel.admin.product.service.TreeForUpdateService;
import by.belinvest.panel.admin.product.service.exception.BRISRequestStatusFieldException;
import by.belinvest.panel.admin.product.service.exception.UrException;
import by.belinvest.panel.admin.product.service.handler.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static by.belinvest.panel.admin.product.service.model.Status.getStatus;
import static by.belinvest.panel.admin.product.service.model.Status.setStatus;

@Controller
@RequestMapping("/hierarchy_update")
public class UpdateHierarchyController {

    private static final String GET_HIERARCHY_UPDATE_VIEW = "product/hierarchy_update";

    @Autowired
    private TreeForUpdateService treeService;

    @Autowired
    private ProductGroupService productGroupService;

    @Autowired
    private ProductHierarchyService productHierarchyService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSynchronizer productSynchronizer;

    @RequestMapping(method = RequestMethod.POST, value = "/checkLine")
    @ResponseBody
    public boolean isLineExist(@RequestBody Map<String, Object> map) {
        //return productHierarchyService.isLineExist(Long.parseLong(map.get("productGroupId").toString()),map.get("productLine").toString());
        return productHierarchyService.isValueUsed(
                Long.parseLong(map.get("hierarchyId").toString()),
                Long.parseLong(map.get("productStructId").toString()),
                Long.parseLong(map.get("value").toString())
        );
    }

    @RequestMapping(method = RequestMethod.POST, value = "/line")
    public String getGetProductHierarchyLine(Model model, @RequestBody Map<String, Object> map) {
        model.addAttribute("tree", treeService.getThirdLevelTree(null, null, null, null));
        model.addAttribute("productGroups", productGroupService.getProductGroupTreeDTOList());
        model.addAttribute("hierarchies", productHierarchyService.findAllNamesAndId());
        model.addAttribute("fullProductHierarchyDTO",
                productHierarchyService.findById(Long.parseLong(map.get("productHierId").toString())));
        return GET_HIERARCHY_UPDATE_VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public String getGetProduct(Model model, @RequestParam String productId) {
        Long prodId = Long.parseLong(productId);
        model.addAttribute("tree", treeService.getThirdLevelTree(null, null, null, null));
        model.addAttribute("productGroups", productGroupService.getProductGroupTreeDTOList());
        model.addAttribute("hierarchies", productHierarchyService.findAllNamesAndId());
        model.addAttribute("product", productService.getProductById(prodId));
        return GET_HIERARCHY_UPDATE_VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_hierarchy")
    public String getGetProductHierarchyByGroup(Model model, @RequestParam Long hierarchyId) {
        model.addAttribute("tree", treeService.getThirdLevelTree(null, null, null, null));
        model.addAttribute("productGroups", productGroupService.getProductGroupTreeDTOList());
        model.addAttribute("hierarchies", productHierarchyService.findAllNamesAndId());
        model.addAttribute("fullProductHierarchyDTO", productHierarchyService.findById(hierarchyId));
        return GET_HIERARCHY_UPDATE_VIEW;
    }

    @GetMapping
    public String getProductHierarchy(Model model) {
        model.addAttribute("tree", treeService.getThirdLevelTree(null, null, null, null));
        model.addAttribute("productGroups", productGroupService.getProductGroupTreeDTOList());
        model.addAttribute("hierarchies", productHierarchyService.findAllNamesAndId());
        return GET_HIERARCHY_UPDATE_VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tree")
    public String getTree(@RequestParam(required = false) Long firstLevelProductGroup,
            @RequestParam(required = false) Long secondLevelProductGroup,
            @RequestParam(required = false) Long thirdLevelProductGroup,
            @RequestParam(required = false) String lineName,
            Model model) {
        model.addAttribute("tree",
                treeService.getThirdLevelTree(firstLevelProductGroup, secondLevelProductGroup, thirdLevelProductGroup, lineName));
        model.addAttribute("productGroups", productGroupService.getProductGroupTreeDTOList());
        model.addAttribute("hierarchies", productHierarchyService.findAllNamesAndId());
        return GET_HIERARCHY_UPDATE_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/get_hierarchies_by_group")
    @ResponseBody
    public List<ProductLine> getProductHierarchyByGroup(@RequestBody ProductGroup productGroup) {
        return productHierarchyService.findProductLines(productGroup.getId());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    @ResponseBody
    public Integer updateHierarchyLevel(@RequestBody LevelUpdateData levelUpdateData) {
        return productService.updateHierarchyLevel(levelUpdateData);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create-product")
    @ResponseBody
    public Long createProduct(@RequestBody LevelUpdateData levelUpdateData) {
        return productService.createProduct(levelUpdateData).getId();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/synchronize")
    @ResponseBody
    public ResponseEntity<?> synchronizeProducts(@RequestBody Data data) {
        setStatus(null);
        setStatusIfNotNull(data);
        System.out.println(getStatus());
        AjaxResponseBody result;
        String resultOfSynchronizing;
        try {
            resultOfSynchronizing = productSynchronizer.synchronize(
                    data.getProductsId().stream()
                            .map(Long::parseLong)
                            .collect(Collectors.toList())
            );
        } catch (BRISRequestStatusFieldException | UrException e) {
            result = new AjaxResponseBody(e.getMessage());
            return ResponseEntity.ok().body(result);
        }
        String errors = RestTemplateResponseErrorHandler.errors;
        if (!errors.equals("")) {
            result = new AjaxResponseBody(errors);
            ResponseEntity<AjaxResponseBody> body = ResponseEntity.badRequest().body(result);
            RestTemplateResponseErrorHandler.errors = "";
            setStatus(null);
            return body;
        }
        result = new AjaxResponseBody(resultOfSynchronizing);
        setStatus(null);
        return ResponseEntity.ok().body(result);
    }

    private void setStatusIfNotNull(@RequestBody Data data) {
        String stringStatus = data.getStatus();
        if (stringStatus != null) {
            setStatus(stringStatus);
        }
    }

}
