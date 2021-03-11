package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BI_PRODUCTTEAM")
public class BIProductTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_PRODUCTTEAM_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDPRODUCTTEAM")
    private Long id;
    @Column(name = "DEVELOPDEPT")
    private String developDept;
    @Column(name = "PRODUCTMANAGERNAME")
    private String productManagerName;
    @Column(name = "DEVELOPMEMBERDEPT")
    private String developMemberDept;
    @Column(name = "DEVELOPMEMBERNAME")
    private String developMemberName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBI")
    private BusinessInitiative businessInitiative;

    public BusinessInitiative getBusinessInitiative() {
        return businessInitiative;
    }

    public void setBusinessInitiative(BusinessInitiative businessInitiative) {
        this.businessInitiative = businessInitiative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDevelopDept(String developDept) {
        this.developDept = developDept;
    }

    public String getDevelopDept() {
        return developDept;
    }

    public void setProductManagerName(String productManagerName) {
        this.productManagerName = productManagerName;
    }

    public String getProductManagerName() {
        return productManagerName;
    }

    public void setDevelopMemberDept(String developMemberDept) {
        this.developMemberDept = developMemberDept;
    }

    public String getDevelopMemberDept() {
        return developMemberDept;
    }

    public void setDevelopMemberName(String developMemberName) {
        this.developMemberName = developMemberName;
    }

    public String getDevelopMemberName() {
        return developMemberName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BIProductTeam that = (BIProductTeam) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(developDept, that.developDept) &&
                Objects.equals(productManagerName, that.productManagerName) &&
                Objects.equals(developMemberDept, that.developMemberDept) &&
                Objects.equals(developMemberName, that.developMemberName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, developDept, productManagerName, developMemberDept, developMemberName);
    }

}
