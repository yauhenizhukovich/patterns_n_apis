package by.belinvest.panel.admin.catalog.db;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.sql.DataSource;

import by.belinvest.panel.admin.catalog.db.mappers.BPCardMapper;
import by.belinvest.panel.admin.catalog.db.mappers.BusinessInitiativeMapper;
import by.belinvest.panel.admin.catalog.db.mappers.BusinessOfferMapper;
import by.belinvest.panel.admin.catalog.db.mappers.ReestrDB;
import by.belinvest.panel.admin.catalog.db.mappers.ReestrMapper;
import by.belinvest.panel.admin.entity.catalog.BPCard;
import by.belinvest.panel.admin.entity.catalog.BPCardDirectory;
import by.belinvest.panel.admin.entity.catalog.BusinessInitiative;
import by.belinvest.panel.admin.entity.catalog.BusinessInitiativeDirectory;
import by.belinvest.panel.admin.entity.catalog.BusinessOffer;
import by.belinvest.panel.admin.entity.catalog.BusinessOfferDirectory;
import by.belinvest.panel.admin.entity.catalog.Reestr;
import by.belinvest.panel.admin.entity.catalog.ReestrDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static by.belinvest.panel.admin.product.service.constant.ProductConstant.CARD;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.CREDIT;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.DEBIT;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.URCRED;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.URDEP;

@Repository
public class CatalogRepository {

    private static final String GET_INFO_FROM_LOST_BI_DIRECTORY_SQL = "select * from LIST_BI  ";

    private static final String GET_BUSINESSINITIATIVE_FROM_LOST_BI_DIRECTORY_SQL = "select * from businessinitiative where idbi = ?";
    private static final String GET_BUSINESSOFFER_FROM_LOST_BI_DIRECTORY_SQL = "select * from businessoffer where idbo = ?";
    private static final String GET_BPCARD_FROM_LOST_BI_DIRECTORY_SQL = "select * from bpcard where bpid = ?";

    private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplateNsi;

    @Autowired
    public CatalogRepository(@Qualifier("catalogDatasource") DataSource dataSource, @Qualifier("nsiDatasource") DataSource dataSourceNsi) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplateNsi = new JdbcTemplate(dataSourceNsi);
    }

    //@Cacheable("listbi")
    public ReestrDirectory get() {
        ReestrDirectory reestrDirectory = new ReestrDirectory();
        List<ReestrDB> query = jdbcTemplate.query(GET_INFO_FROM_LOST_BI_DIRECTORY_SQL, new ReestrMapper());
        System.out.println(query.size() + "listBi");
        for (ReestrDB r : query) {
            Long productHierId;
            Reestr reestr = getReestrWithoutProducts(r);
            if (r.getProductHierId() != null) {
                productHierId = Long.parseLong(r.getProductHierId());
                System.out.println("prodId=" + productHierId);
                List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                        "select p.ID, p.PRODUCT_ID, pg.TABLE_NAME from PRODUCT p JOIN PRODUCT_GROUP pg ON p.PRODUCT_GROUP=pg.ID where p.PRODUCT_HIERARCHY_ID = " + productHierId)
                        .stream()
                        .limit(100)
                        .collect(Collectors.toList());

                if (!rows.isEmpty()) {
                    System.out.println(rows.get(0));
                    System.out.println(rows.get(1));
                    System.out.println(rows.get(rows.size() - 1));
                }
                if (rows.isEmpty()) {
                    reestrDirectory.getReestrs().add(reestr);
                }
                for (Map row : rows) {
                    Number productId = (BigDecimal) row.get("PRODUCT_ID");
                    String tableName = (String) row.get("TABLE_NAME");
                    Number idProd = (BigDecimal) row.get("ID");

                    String productName = getProductName(productId.longValue(), tableName);
                    System.out.println("productName =" + productName);
                    reestr.setProductId(String.valueOf(idProd));
                    reestr.setProductName(productName);
                    reestrDirectory.getReestrs().add(reestr);
                }
            } else {
                reestrDirectory.getReestrs().add(reestr);
            }
        }
        Set<Reestr> set = new HashSet<>(reestrDirectory.getReestrs());

        System.out.println("setSize=" + reestrDirectory.getReestrs().size());
        List<Reestr> list = set.stream().collect(Collectors.toList());

        Comparator<Reestr> comparator = Comparator.comparing(e -> e.getBusProdCardProductName() == null ? "" : e.getBusProdCardProductName());

        Collections.sort(list, comparator.reversed());
        System.out.println("listsize" + list.size());
        reestrDirectory.getReestrs().clear();
        reestrDirectory.getReestrs().addAll(list);
        System.out.println("finalSize" + reestrDirectory.getReestrs().size());
        return reestrDirectory;
    }

    private String getProductName(Long productId, String tableName) {
        String productName;
        switch (tableName) {
            case CREDIT:
                productName = jdbcTemplate.queryForObject(
                        "select PRODUCT_NAME from CREDIT where ID = " + productId, String.class
                );
                break;
            case URDEP:
                productName = jdbcTemplateNsi.queryForObject(
                        "select NAME from URDEP where DIMID = " + productId, String.class
                );
                break;
            case URCRED:
                productName = jdbcTemplateNsi.queryForObject(
                        "select NAME from URCRED where DIMID = " + productId, String.class
                );
                break;
            case DEBIT:
                productName = jdbcTemplate.queryForObject(
                        "select PRODUCT_NAME from DEBIT where ID = " + productId, String.class
                );
                break;
            case CARD:
                productName = jdbcTemplate.queryForObject(
                        "select NAME from CARD where ID = " + productId, String.class
                );
                break;
            default:
                throw new UnsupportedOperationException("Unsupported table name.");
        }
        return productName;
    }

    public BusinessInitiativeDirectory getBusinessInitiativeById(int id) {
        BusinessInitiativeDirectory businessInitiativeDirectory = new BusinessInitiativeDirectory();

        List<BusinessInitiative> query = jdbcTemplate.query(GET_BUSINESSINITIATIVE_FROM_LOST_BI_DIRECTORY_SQL,
                new Object[] {id},
                new BusinessInitiativeMapper());
        for (BusinessInitiative b : query) {
            businessInitiativeDirectory.getBusinessInitiatives().add(b);
        }

        return businessInitiativeDirectory;
    }

    public BusinessOfferDirectory getBusinessOfferById(int id) {
        BusinessOfferDirectory businessInitiativeDirectory = new BusinessOfferDirectory();

        List<BusinessOffer> query = jdbcTemplate.query(GET_BUSINESSOFFER_FROM_LOST_BI_DIRECTORY_SQL,
                new Object[] {id},
                new BusinessOfferMapper());
        for (BusinessOffer o : query) {
            businessInitiativeDirectory.getBusinessOffers().add(o);
        }

        return businessInitiativeDirectory;
    }

    public BPCardDirectory getBPCardById(int id) {
        BPCardDirectory bpCardDirectory = new BPCardDirectory();

        List<BPCard> query = jdbcTemplate.query(GET_BPCARD_FROM_LOST_BI_DIRECTORY_SQL, new Object[] {id}, new BPCardMapper());
        for (BPCard b : query) {
            bpCardDirectory.getBpCards().add(b);
        }

        return bpCardDirectory;
    }

    public String getProductByBpcard(int id) {
        String productName = "";
        try {
            List<String> bpProductNsiName = jdbcTemplate.queryForList("select NSI_NAME from bp_product_line where BPID = " + id + "",
                    String.class);
            List<Integer> bpProductCode = jdbcTemplate.queryForList("select NSI_ID from bp_product_line where BPID = " + id + "",
                    Integer.class);

            if (!bpProductNsiName.isEmpty() && !bpProductCode.isEmpty()) {
                productName = jdbcTemplateNsi.queryForObject("select NAME from " + bpProductNsiName.get(0) + " where CODE = " + bpProductCode
                        .get(0) + "", String.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productName;

    }

    private Reestr getReestrWithoutProducts(ReestrDB r) {
        Reestr reestr = new Reestr();
        String noteId = r.getNoteId();
        if (noteId != null) {
            reestr.setNoteId(noteId);
        }
        String sign = r.getSign();
        if (sign != null) {
            reestr.setSign(sign);
        }
        String busInitId = r.getBusInitId();
        if (busInitId != null) {
            reestr.setBusInitId(busInitId);
        }
        String busInitName = r.getBusInitName();
        if (busInitName != null) {
            reestr.setBusInitName(busInitName);
        }
        String busInitStatus = r.getBusInitStatus();
        if (busInitStatus != null) {
            reestr.setBusInitStatus(busInitStatus);
        }
        String busInitDate = r.getBusInitDate();
        if (busInitDate != null) {
            reestr.setBusInitDate(busInitDate);
        }
        String busOffId = r.getBusOffId();
        if (busOffId != null) {
            reestr.setBusOffId(busOffId);
        }
        String busOffName = r.getBusOffName();
        if (busOffName != null) {
            reestr.setBusOffName(busOffName);
        }
        String busOffStatus = r.getBusOffStatus();
        if (busOffStatus != null) {
            reestr.setBusOffStatus(busOffStatus);
        }
        String busOffDate = r.getBusOffDate();
        if (busOffDate != null) {
            reestr.setBusOffDate(busOffDate);
        }
        String busProdCardId = r.getBusProdCardId();
        if (busProdCardId != null) {
            reestr.setBusProdCardId(busProdCardId);
        }
        String busProdCardProductName = r.getBusProdCardProductName();
        if (busProdCardProductName != null) {
            reestr.setBusProdCardProductName(busProdCardProductName);
        }
        String busProdCardProductStatus = r.getBusProdCardProductStatus();
        if (busProdCardProductStatus != null) {
            reestr.setBusProdCardProductStatus(busProdCardProductStatus);
        }

        String productHierId = r.getProductHierId();
        if (busProdCardProductStatus != null) {
            reestr.setProductHierId(productHierId);
        }

        return reestr;
    }

}