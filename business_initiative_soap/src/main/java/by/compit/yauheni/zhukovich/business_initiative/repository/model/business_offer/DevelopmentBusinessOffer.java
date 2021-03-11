package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer;

import java.time.LocalDate;
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
@Table(name = "BO_ONDEVELOPMENT")
public class DevelopmentBusinessOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_ONDEVELOPMENT_IDDEV", allocationSize = 1, name = "SEQ")
    @Column(name = "IDDEV")
    private Long id;
    @Column(name = "DEVPHASE")
    private String devPhase;
    @Column(name = "DEPTNAME")
    private String deptName;
    @Column(name = "EMPPOSITION")
    private String empPosition;
    @Column(name = "EMPName")
    private String empName;
    @Column(name = "EMPLOGIN")
    private String empLogin;
    @Column(name = "DLG_DEPTNAME")
    private String dlgDeptName;
    @Column(name = "DLG_EMPPOSITION")
    private String dlgEmpPosition;
    @Column(name = "DLG_EMPName")
    private String dlgEmpName;
    @Column(name = "DLG_EMPLOGIN")
    private String dlgEmpLogin;
    @Column(name = "RESULT")
    private String result;
    @Column(name = "DATETO")
    private LocalDate dateTo;
    @Column(name = "DATENOM")
    private LocalDate dateNom;
    @Column(name = "COMMENTS")
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;

    public BusinessOffer getBusinessOffer() {
        return businessOffer;
    }

    public void setBusinessOffer(BusinessOffer businessOffer) {
        this.businessOffer = businessOffer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDevPhase(String devPhase) {
        this.devPhase = devPhase;
    }

    public String getDevPhase() {
        return devPhase;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpLogin(String empLogin) {
        this.empLogin = empLogin;
    }

    public String getEmpLogin() {
        return empLogin;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateNom(LocalDate dateNom) {
        this.dateNom = dateNom;
    }

    public LocalDate getDateNom() {
        return dateNom;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public String getDlgDeptName() {
        return dlgDeptName;
    }

    public void setDlgDeptName(String dlgDeptName) {
        this.dlgDeptName = dlgDeptName;
    }

    public String getDlgEmpPosition() {
        return dlgEmpPosition;
    }

    public void setDlgEmpPosition(String dlgEmpPosition) {
        this.dlgEmpPosition = dlgEmpPosition;
    }

    public String getDlgEmpName() {
        return dlgEmpName;
    }

    public void setDlgEmpName(String dlgEmpName) {
        this.dlgEmpName = dlgEmpName;
    }

    public String getDlgEmpLogin() {
        return dlgEmpLogin;
    }

    public void setDlgEmpLogin(String dlgEmpLogin) {
        this.dlgEmpLogin = dlgEmpLogin;
    }

}
