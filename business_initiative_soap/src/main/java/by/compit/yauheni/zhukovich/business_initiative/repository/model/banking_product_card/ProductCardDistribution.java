package by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card;

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
@Table(name = "BPC_DISTRIBUTION")
public class ProductCardDistribution {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BPC_DISTRIBUTION_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "ID_DISTRIBUTION")
    private Long id;
    @Column(name = "DEPTNAME")
    private String deptName;
    @Column(name = "EMPLOYEEPOSITION")
    private String employeePosition;
    @Column(name = "EMPLOYEENAME")
    private String employeeName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BPID")
    private BankingProductCard bankingProductCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setBankingProductCard(BankingProductCard bankingProductCard) {
        this.bankingProductCard = bankingProductCard;
    }

    public BankingProductCard getBankingProductCard() {
        return bankingProductCard;
    }

}
