package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative;

import java.math.BigDecimal;
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
@Table(name = "BI_PROJECTEDEXPENSES")
public class ProjectedExpenses {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_PROJECTEDEXPENSES_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDPROJECTEDEXPENSES")
    private Long id;
    @Column(name = "EXPENSESTYPES")
    private String expensesType;
    @Column(name = "EXPENCESSIZE")
    private BigDecimal expensesSize;
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

    public void setExpensesType(String expensesType) {
        this.expensesType = expensesType;
    }

    public String getExpensesType() {
        return expensesType;
    }

    public void setExpensesSize(BigDecimal expensesSize) {
        this.expensesSize = expensesSize;
    }

    public BigDecimal getExpensesSize() {
        return expensesSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectedExpenses that = (ProjectedExpenses) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(expensesType, that.expensesType) &&
                Objects.equals(expensesSize, that.expensesSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expensesType, expensesSize);
    }

}
