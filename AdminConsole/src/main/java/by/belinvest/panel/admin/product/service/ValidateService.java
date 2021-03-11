package by.belinvest.panel.admin.product.service;

import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ValidateService {
    @Autowired
    private ProductHierarchyService productHierarchyService;

    public String validateCreateProductHierarchy(Long productGroupId,Long lineId,Integer activity){
        Map<String,Object> map = new HashMap<>();
        map.put("response",true);
        Gson response = new Gson();

        if(activity == 1){
            List<ProductHierarchy> listHierarchiesWithOneLine = productHierarchyService.findAllByProductGroupIdAndLineId(productGroupId, lineId);

            if(!listHierarchiesWithOneLine.isEmpty()){
                for (ProductHierarchy productHierarchy:listHierarchiesWithOneLine) {
                    if(productHierarchy.getActivity() == 1){
                        map.put("message","Активная иерархия для этой линейки уже существует");
                        map.put("response",false);
                        return response.toJson(map);
                    }
                }
            }
        }

        return response.toJson(map);
    }

    public String validateUpdateProductHierarchy(Long productGroupId,Long lineId,Integer activity,Long id){
        Map<String,Object> map = new HashMap<>();
        map.put("response",true);
        Gson response = new Gson();

        if(activity == 1){
            List<ProductHierarchy> listHierarchiesWithOneLine = productHierarchyService.findAllByProductGroupIdAndLineId(productGroupId, lineId)
                    .stream()
                    .filter(el -> el.getId() != id)
                    .collect(Collectors.toList());

            if(!listHierarchiesWithOneLine.isEmpty()){
                for (ProductHierarchy productHierarchy:listHierarchiesWithOneLine) {
                    if(productHierarchy.getActivity() == 1){
                        map.put("message","Активная иерархия для этой линейки уже существует");
                        map.put("response",false);
                        return response.toJson(map);
                    }
                }
            }
        }

        return response.toJson(map);
    }


}
