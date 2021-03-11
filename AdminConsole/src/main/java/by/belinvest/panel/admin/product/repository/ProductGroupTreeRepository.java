package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.product.dto.ProductGroupTreeDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class ProductGroupTreeRepository {
    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;

    private static final String GET_PRODUCT_GROUP_3_LEVELS_QUERY = "SELECT id, hi_id, name, LEVEL lev, CONNECT_BY_ISLEAF AS leaf, table_name, nsi_table " +
            "FROM product_group " +
            "WHERE level <= 3 " +
            "CONNECT BY PRIOR id = hi_id START WITH hi_id IS NULL";

    private static final String GET_PRODUCT_GROUP_5_LEVELS_QUERY = "SELECT id id,\n" +
            "       hi_id hi_id,\n" +
            "       name,\n" +
            "       LEVEL lev,\n" +
            "       TABLE_NAME\n" +
            "FROM product_group\n" +
            "CONNECT BY PRIOR id = hi_id\n" +
            "START WITH hi_id IS NULL";

    @SuppressWarnings("unchecked")
    public List<ProductGroupTreeDTO> getThirdLevelProductGroupTree() {
        List<Tuple> tupleList = entityManager.createNativeQuery(GET_PRODUCT_GROUP_3_LEVELS_QUERY, Tuple.class).getResultList();
        return tupleList.stream().map(tuple ->
                ProductGroupTreeDTO.builder()
                        .id((tuple.get("ID",BigDecimal.class)).longValue())
                        .hiId(convertToLong(tuple.get("HI_ID",BigDecimal.class)))
                        .leaf((tuple.get("LEAF",BigDecimal.class)).byteValue())
                        .lev((tuple.get("LEV",BigDecimal.class)).byteValue())
                        .name(tuple.get("NAME",String.class))
                        .tableName(Optional.ofNullable(tuple.get("TABLE_NAME",String.class)).orElse(null))
                        .nsiTable(Optional.ofNullable(tuple.get("NSI_TABLE",String.class)).orElse(null))
                        .build()
        ).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public List<ProductGroupTreeDTO> getFifthLevelProductGroupTree() {
        List<Tuple> tupleList = entityManager.createNativeQuery(GET_PRODUCT_GROUP_5_LEVELS_QUERY, Tuple.class).getResultList();
        return tupleList.stream().map(tuple ->
                ProductGroupTreeDTO.builder()
                        .id((tuple.get("ID",BigDecimal.class)).longValue())
                        .hiId(convertToLong(tuple.get("HI_ID",BigDecimal.class)))
                        .lev((tuple.get("LEV",BigDecimal.class)).byteValue())
                        .name(tuple.get("NAME",String.class))
                        .tableName(Optional.ofNullable(tuple.get("TABLE_NAME",String.class)).orElse(null))
                        .build()
        ).collect(Collectors.toList());
    }

    private Long convertToLong(BigDecimal bigDecimal){
        if(bigDecimal == null){
            return null;
        }else {
            return bigDecimal.longValue();
        }
    }


}
