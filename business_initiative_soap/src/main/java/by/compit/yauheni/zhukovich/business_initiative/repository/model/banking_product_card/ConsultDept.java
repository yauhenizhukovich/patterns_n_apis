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
@Table(name = "BPC_CONSULT_DEPT")
public class ConsultDept {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BPC_CONSULT_DEPT_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "ID_CONSULT_DEPT")
    private Long id;
    @Column(name = "CONSULTDEPTNAME")
    private String consultDeptName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BPID")
    private BankingProductCard bankingProductCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBankingProductCard(BankingProductCard bankingProductCard) {
        this.bankingProductCard = bankingProductCard;
    }

    public BankingProductCard getBankingProductCard() {
        return bankingProductCard;
    }

    public void setConsultDeptName(String consultDeptName) {
        this.consultDeptName = consultDeptName;
    }

    public String getConsultDeptName() {
        return consultDeptName;
    }

}
