package by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card;

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
@Table(name = "BPC_DEPT")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BPC_DEPT_ID_DEPT", allocationSize = 1, name = "SEQ")
    @Column(name = "ID_DEPT")
    private Long id;
    @Column(name = "DEPTNAME")
    private String deptName;
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

    public void setBankingProductCard(BankingProductCard bankingProductCard) {
        this.bankingProductCard = bankingProductCard;
    }

    public BankingProductCard getBankingProductCard() {
        return bankingProductCard;
    }

}
