package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.entity.product.TreeElement;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TreeRepository {

    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;

    private static final String NEW = "WITH\n" +
            "    t3 AS (  SELECT id id,\n" +
            "                    hi_id hi_id,\n" +
            "                    name,\n" +
            "                    LEVEL lev\n" +
            "             FROM product_group\n" +
            "             WHERE     LEVEL <= 3\n" +
            "               AND (   (LEVEL = 1 AND (:a1 IS NULL OR id = :a1))\n" +
            "                 OR (LEVEL = 2 AND (:a2 IS NULL OR id = :a2))\n" +
            "                 OR (LEVEL = 3 AND (:a3 IS NULL OR id = :a3)))\n" +
            "             CONNECT BY PRIOR id = hi_id\n" +
            "             START WITH hi_id IS NULL),\n" +
            "    t4 as (select v.*, s.LEV, PRIOR v.ID HI_ID, PRIOR v.IDSTRUCT HI_IDSTRUCT,\n" +
            "             SYS_CONNECT_BY_PATH(to_char(v.VALUE), '/') KEY, \n" +
            "             SUBSTR(SYS_CONNECT_BY_PATH(to_char(PRIOR v.VALUE), '/'),2) HI_KEY\n" +
            "           from PRODUCT_HIER_STRUCT s, PRODUCT_HIER_VALUE v \n" +
            "           where s.ID = v.IDSTRUCT\n" +
            "           CONNECT BY PRIOR s.PRODUCT_HIER_ID = s.PRODUCT_HIER_ID and PRIOR s.LEV = s.LEV-1 and PRIOR v.IDPRODUCT = v.IDPRODUCT \n" +
            "           START WITH s.LEV = 1),\n" +
            "    t5 as (select IDSTRUCT, LEV, VALUE, IDSTRUCT||KEY KEY, CASE WHEN HI_KEY is not NULL then HI_IDSTRUCT || HI_KEY else NULL end HI_KEY, min(id) ID, min(hi_id) HI_ID\n" +
            "             FROM t4 v\n" +
            "           GROUP BY IDSTRUCT,LEV,VALUE,KEY,HI_IDSTRUCT,HI_KEY),\n" +
            "    t1 AS (\n" +
            "        SELECT TO_CHAR (id) id,\n" +
            "               LEV         lev,\n" +
            "               TO_CHAR (hi_id) hi_id,\n" +
            "               name,\n" +
            "               0 typ,\n" +
            "               NULL PRODUCT_HIER_ID,\n" +
            "               ID REAL_ID,\n" +
            "               HI_ID REAL_HI_ID\n" +
            "        FROM t3\n" +
            "        WHERE (hi_id IS NULL OR PRIOR id = hi_id)\n" +
            "        CONNECT BY PRIOR id = hi_id START WITH hi_id IS NULL\n" +
            "        UNION ALL\n" +
            "        SELECT\n" +
            "           '1/'||t5.KEY ID,\n" +
            "           t5.LEV + 3 LEV,\n" +
            "           CASE WHEN HI_KEY is NULL then (SELECT TO_CHAR (product_group)\n" +
            "                             FROM PRODUCT_HIERARCHY\n" +
            "                             WHERE id = s.PRODUCT_HIER_ID)\n" +
            "                else\n" +
            "                  '1/'||HI_KEY\n" +
            "                end HI_ID,\n" +
            "                PKG_HIER.EXEC_SQL (\n" +
            "                       sSQL =>\n" +
            "                               'select '||c.FIELD_TEXT||' from '||c.TABLE_NAME||' where to_char('||c.FIELD_NAME||') = '''\n" +
            "                               ||v.VALUE||'''')\n" +
            "                    name,                \n" +
            "               1 typ,\n" +
            "               s.PRODUCT_HIER_ID,\n" +
            "               s.ID REAL_ID,\n" +
            "               NULL REAL_HI_ID\n" +
            "           from t5, PRODUCT_HIER_STRUCT s, PRODUCT_HIER_VALUE v, PRODUCT_HIER_CRIT c\n" +
            "            where s.ID = t5.IDSTRUCT and v.ID = t5.ID\n" +
            "            AND s.CRIT IS NOT NULL AND s.CRIT = c.ID\n" +
            "        union\n" +
            "        select '2/'||t4.IDPRODUCT||'/'||t4.IDSTRUCT||t4.KEY ID,\n" +
            "           h.LEVEL_QUANT + 4 lev,\n" +
            "           '1/'||t5.key HI_ID,\n" +
            "         PKG_HIER.EXEC_SQL (\n" +
            "                       sSQL =>\n" +
            "                               'select '||g.PRODUCT_NAME||' from '||g.TABLE_NAME||' where '||g.PRODUCT_CODE||' = '''\n" +
            "                               ||p.PRODUCT_CODE||'''') name,\n" +
            "           2 typ,\n" +
            "           p.PRODUCT_HIERARCHY_ID PRODUCT_HIER_ID,\n" +
            "           p.ID,\n" +
            "           NULL\n" +
            "         from t5, t4, PRODUCT_HIER_STRUCT s,PRODUCT_HIER_VALUE v, PRODUCT_HIERARCHY h,product p, product_group g\n" +
            "         where t4.IDSTRUCT||t4.KEY = t5.key\n" +
            "         and s.id = v.IDSTRUCT \n" +
            "         and s.ID = t4.IDSTRUCT and s.PRODUCT_HIER_ID = h.ID and s.LEV = h.LEVEL_QUANT\n" +
            "         and v.idproduct = t4.idproduct\n" +
            "         and p.PRODUCT_HIERARCHY_ID = h.ID\n" +
            "         and p.ID = v.IDPRODUCT\n" +
            "         and g.id = p.PRODUCT_GROUP\n" +
            "    )\n" +
            "SELECT distinct id,\n" +
            "       HI_ID,\n" +
            "       LEV,\n" +
            "       NAME name,\n" +
            "       TYP, -- 0 - группа продуктов, 1 - дерево критериев, 2 - продукты\n" +
            "       REAL_HI_ID,\n" +
            "       REAL_ID,\n" +
            "       PRODUCT_HIER_ID\n" +
            "FROM t1\n" +
            "CONNECT BY PRIOR id = hi_id\n" +
            "START WITH hi_id IS NULL\n" +
            "ORDER BY TYP,LEV";

    private static final String QUERY_GET_HIERARCHY_TREE = "WITH\n" +
            "    t3 AS (  SELECT id id,\n" +
            "                    hi_id hi_id,\n" +
            "                    name,\n" +
            "                    LEVEL lev\n" +
            "             FROM product_group\n" +
            "             WHERE     LEVEL <= 3\n" +
            "               AND (   (LEVEL = 1 AND (:a1 IS NULL OR id = :a1))\n" +
            "                 OR (LEVEL = 2 AND (:a2 IS NULL OR id = :a2))\n" +
            "                 OR (LEVEL = 3 AND (:a3 IS NULL OR id = :a3)))\n" +
            "             CONNECT BY PRIOR id = hi_id\n" +
            "             START WITH hi_id IS NULL),\n" +
            "    t4 as (select v.*, s.LEV, PRIOR v.ID HI_ID, PRIOR v.IDSTRUCT HI_IDSTRUCT,\n" +
            "             SYS_CONNECT_BY_PATH(to_char(v.VALUE), '/') KEY, \n" +
            "             SUBSTR(SYS_CONNECT_BY_PATH(to_char(PRIOR v.VALUE), '/'),2) HI_KEY\n" +
            "           from PRODUCT_HIER_STRUCT s, PRODUCT_HIER_VALUE v \n" +
            "           where s.ID = v.IDSTRUCT\n" +
            "           CONNECT BY PRIOR s.PRODUCT_HIER_ID = s.PRODUCT_HIER_ID and PRIOR s.LEV = s.LEV-1 and PRIOR v.IDPRODUCT = v.IDPRODUCT \n" +
            "           START WITH s.LEV = 1),\n" +
            "    t5 as (select IDSTRUCT, LEV, VALUE, IDSTRUCT||KEY KEY, CASE WHEN HI_KEY is not NULL then HI_IDSTRUCT || HI_KEY else NULL end HI_KEY, min(id) ID, min(hi_id) HI_ID\n" +
            "             FROM t4 v\n" +
            "           GROUP BY IDSTRUCT,LEV,VALUE,KEY,HI_IDSTRUCT,HI_KEY),\n" +
            "    t1 AS (\n" +
            "        SELECT TO_CHAR (id) id,\n" +
            "               LEV         lev,\n" +
            "               TO_CHAR (hi_id) hi_id,\n" +
            "               name,\n" +
            "               0 typ,\n" +
            "               NULL PRODUCT_HIER_ID,\n" +
            "               ID REAL_ID,\n" +
            "               HI_ID REAL_HI_ID\n" +
            "        FROM t3\n" +
            "        WHERE (hi_id IS NULL OR PRIOR id = hi_id)\n" +
            "        CONNECT BY PRIOR id = hi_id START WITH hi_id IS NULL\n" +
            "        UNION ALL\n" +
            "        SELECT\n" +
            "           '1/'||t5.KEY ID,\n" +
            "           t5.LEV + 3 LEV,\n" +
            "           CASE WHEN HI_KEY is NULL then (SELECT TO_CHAR (product_group)\n" +
            "                             FROM PRODUCT_HIERARCHY\n" +
            "                             WHERE id = s.PRODUCT_HIER_ID)\n" +
            "                else\n" +
            "                  '1/'||HI_KEY\n" +
            "                end HI_ID,\n" +
            "                PKG_HIER.EXEC_SQL (\n" +
            "                       sSQL =>\n" +
            "                               'select '||c.FIELD_TEXT||' from '||c.TABLE_NAME||' where to_char('||c.FIELD_NAME||') = '''\n" +
            "                               ||v.VALUE||'''')\n" +
            "                    name,                \n" +
            "               1 typ,\n" +
            "               s.PRODUCT_HIER_ID,\n" +
            "               s.ID REAL_ID,\n" +
            "               NULL REAL_HI_ID\n" +
            "           from t5, PRODUCT_HIER_STRUCT s, PRODUCT_HIER_VALUE v, PRODUCT_HIER_CRIT c, PRODUCT_HIERARCHY h\n" +
            "            where s.ID = t5.IDSTRUCT and v.ID = t5.ID\n" +
            "            AND s.CRIT IS NOT NULL AND s.CRIT = c.ID\n" +
            "            and s.PRODUCT_HIER_ID = h.ID\n" +
            "            and h.ACTIVITY = 1\n" +
            "        union\n" +
            "        select '2/'||t4.IDPRODUCT||'/'||t4.IDSTRUCT||t4.KEY ID,\n" +
            "           h.LEVEL_QUANT + 4 lev,\n" +
            "           '1/'||t5.key HI_ID,\n" +
            "         PKG_HIER.EXEC_SQL (\n" +
            "                       sSQL =>\n" +
            "                               'select '||g.PRODUCT_NAME||' from '||g.TABLE_NAME||' where '||case when g.TABLE_NAME like 'NSI.%' then 'DIMID' else 'ID' end||' = '''\n" +
            "                               ||p.PRODUCT_ID||''' and ROWNUM = 1') name,\n" +
            "           2 typ,\n" +
            "           p.PRODUCT_HIERARCHY_ID PRODUCT_HIER_ID,\n" +
            "           p.ID,\n" +
            "           NULL\n" +
            "         from t5, t4, PRODUCT_HIER_STRUCT s,PRODUCT_HIER_VALUE v, PRODUCT_HIERARCHY h,product p, product_group g\n" +
            "         where t4.IDSTRUCT||t4.KEY = t5.key\n" +
            "         and s.id = v.IDSTRUCT \n" +
            "         and s.ID = t4.IDSTRUCT and s.PRODUCT_HIER_ID = h.ID and s.LEV = h.LEVEL_QUANT\n" +
            "         and v.idproduct = t4.idproduct\n" +
            "         and p.PRODUCT_HIERARCHY_ID = h.ID\n" +
            "         and p.ID = v.IDPRODUCT\n" +
            "         and g.id = p.PRODUCT_GROUP\n" +
            "         and h.ACTIVITY = 1\n" +
            "    )\n" +
            "SELECT distinct id,\n" +
            "       HI_ID,\n" +
            "       LEV,\n" +
            "       NAME name,\n" +
            "       TYP, -- 0 - группа продуктов, 1 - дерево критериев, 2 - продукты\n" +
            "       REAL_HI_ID,\n" +
            "       REAL_ID,\n" +
            "       PRODUCT_HIER_ID\n" +
            "FROM t1\n" +
            "CONNECT BY PRIOR id = hi_id\n" +
            "START WITH hi_id IS NULL\n" +
            "ORDER BY TYP,LEV";

    private static final String GET_PRODUCT_GROUP_5_LEVELS_QUERY = "SELECT id id,\n" +
            "       hi_id HI_ID,\n" +
            "       name,\n" +
            "       LEVEL lev\n" +
            "FROM product_group\n" +
            "WHERE  LEVEL = 1 AND (:a1 IS NULL OR id = :a1)\n" +
            "   OR LEVEL = 2 AND (:a2 IS NULL OR id = :a2)\n" +
            "   OR LEVEL = 3 AND (:a3 IS NULL OR id = :a3)\n" +
            "   OR LEVEL = 4 AND (:a4 IS NULL OR id = :a4)\n" +
            "   OR LEVEL = 5 AND (:a5 IS NULL OR id = :a5)\n" +
            "CONNECT BY PRIOR id = hi_id\n" +
            "START WITH hi_id IS NULL";

    @SuppressWarnings("unchecked")
    public List<TreeElement> getTree(Long pg1, Long pg2, Long pg3){
        List<Tuple> tupleList = entityManager.createNativeQuery(QUERY_GET_HIERARCHY_TREE,Tuple.class)
                .setParameter("a1", new TypedParameterValue(StandardBasicTypes.LONG, pg1))
                .setParameter("a2", new TypedParameterValue(StandardBasicTypes.LONG, pg2))
                .setParameter("a3", new TypedParameterValue(StandardBasicTypes.LONG, pg3))
                .getResultList();
        return tupleList.stream().map(tuple-> TreeElement.builder()
                .id(tuple.get("ID",String.class))
                .hiId(tuple.get("HI_ID", String.class))
                .lev(tuple.get("LEV", BigDecimal.class).byteValue())
                .name(tuple.get("NAME", String.class))
                .typ(tuple.get("TYP", BigDecimal.class).byteValue())
                .realHiId(convertToLong(tuple.get("REAL_HI_ID", BigDecimal.class)))
                .realId(tuple.get("REAL_ID", BigDecimal.class).longValue())
                .prodHierId(convertToLong(tuple.get("PRODUCT_HIER_ID", BigDecimal.class)))
                .child(new ArrayList<>())
                .build()).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public List<TreeElement> getFifthLevelTree(Long pg1, Long pg2, Long pg3, Long pg4, Long pg5){
        List<Tuple> tupleList = entityManager.createNativeQuery(GET_PRODUCT_GROUP_5_LEVELS_QUERY,Tuple.class)
                .setParameter("a1", new TypedParameterValue(StandardBasicTypes.LONG, pg1))
                .setParameter("a2", new TypedParameterValue(StandardBasicTypes.LONG, pg2))
                .setParameter("a3", new TypedParameterValue(StandardBasicTypes.LONG, pg3))
                .setParameter("a4", new TypedParameterValue(StandardBasicTypes.LONG, pg4))
                .setParameter("a5", new TypedParameterValue(StandardBasicTypes.LONG, pg5))
                .getResultList();

        List<TreeElement> treeElementList = tupleList.stream().map(tuple-> TreeElement.builder()
                .id(tuple.get("ID").toString())
                .hiId(String.valueOf(convertToLong(tuple.get("HI_ID", BigDecimal.class))))
                .lev(tuple.get("LEV", BigDecimal.class).byteValue())
                .name(tuple.get("NAME", String.class))
                .typ((byte) 0)
                .child(new ArrayList<>())
                .build()).collect(Collectors.toList());
        treeElementList.forEach(treeElement -> {
            treeElement.setRealId(Long.parseLong(treeElement.getId()));
        });

        return treeElementList;
    }

    private Long convertToLong(BigDecimal bigDecimal){
        if(bigDecimal == null){
            return null;
        }else {
            return bigDecimal.longValue();
        }
    }
}
