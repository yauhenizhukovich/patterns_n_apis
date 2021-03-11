package by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi;

import java.math.BigDecimal;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "URDEP")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UrDep {

    @Id
    @Column(name = "DIMID")
    private Long dimid;
    @Column(name = "PARENTID")
    private Long parentid;
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DEP_PROC_DECREASE_STAV")
    private BigDecimal depProcDecreaseStav;
    @Column(name = "DEP_VID_PROC_STAV")
    private Long depVidProcStav;
    @Column(name = "DEP_SUMBL")
    private BigDecimal depSumbl;
    @Column(name = "DEP_SROK")
    private String depSrok;
    @Column(name = "DEP_TYPE")
    private Long depType;
    @Column(name = "DEP_SR_VOZVRAT")
    private Integer depSrVozvrat;
    @Column(name = "DEP_POROG_SUM")
    private BigDecimal depPorogSum;
    @Column(name = "DEP_SUM_SPIS")
    private BigDecimal depSumSpis;
    @Column(name = "DEP_MAX_SROK")
    private String depMaxSrok;
    @Column(name = "DEP_STAV_SPIS")
    private Boolean depStavSpis;
    @Column(name = "DEP_USL_RASTOR")
    private Boolean depUslRastor;
    @Column(name = "DEP_BLOC")
    private Boolean depBloc;
    @Column(name = "DEP_SUMDOG")
    private BigDecimal depSumdog;
    @Column(name = "DEP_ALLOW_ADDITION")
    private Boolean depAllowAddition;
    @Column(name = "DEP_BAN_DEYS")
    private String depBanDeys;
    @Column(name = "DEP_STAV_RAST")
    private Long depStavRast;
    @Column(name = "DEP_STAVKA")
    private BigDecimal depStavka;
    @Column(name = "DEP_GOAL")
    private String depGoal;
    @Column(name = "DEP_SHKALA_STAV")
    private Boolean depShkalaStav;
    @Column(name = "DEP_KOL")
    private Boolean depKol;
    @Column(name = "DEP_TYPE_NACH_PROC")
    private String depTypeNachProc;
    @Column(name = "DEP_PROC_RAST")
    private BigDecimal depProcRast;
    @Column(name = "DEP_MAX_STAV")
    private BigDecimal depMaxStav;
    @Column(name = "DEP_MAX_LIMIT")
    private String depMaxLimit;
    @Column(name = "DEP_PROC_TAKE_ALLOW")
    private BigDecimal depProcTakeAllow;
    @Column(name = "DEP_MIN_SROK")
    private String depMinSrok;
    @Column(name = "DEP_STAV_RAST_VAL")
    private BigDecimal depStavRastVal;
    @Column(name = "DEP_SROK_WAIT_RETURN")
    private String depSrokWaitReturn;
    @Column(name = "DEP_LIMIT")
    private Boolean depLimit;
    @Column(name = "DEP_TYPE_CONTRACT")
    private Boolean depTypeContract;
    @Column(name = "DEP_ADDITIONAL_INCOME")
    private Boolean depAdditionalIncome;
    @Column(name = "DEP_KONTR_MAX_STAV")
    private Boolean depKontrMaxStav;
    @Column(name = "DEP_CURRENCY")
    private Long depCurrency;
    @Column(name = "DEP_STAV_POROG")
    private BigDecimal depStavPorog;

    public Long getDimid() {
        return dimid;
    }

    public void setDimid(Long dimid) {
        this.dimid = dimid;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDepProcDecreaseStav() {
        return depProcDecreaseStav;
    }

    public void setDepProcDecreaseStav(BigDecimal depProcDecreaseStav) {
        this.depProcDecreaseStav = depProcDecreaseStav;
    }

    public Long getDepVidProcStav() {
        return depVidProcStav;
    }

    public void setDepVidProcStav(Long depVidProcStav) {
        this.depVidProcStav = depVidProcStav;
    }

    public BigDecimal getDepSumbl() {
        return depSumbl;
    }

    public void setDepSumbl(BigDecimal depSumbl) {
        this.depSumbl = depSumbl;
    }

    public String getDepSrok() {
        return depSrok;
    }

    public void setDepSrok(String depSrok) {
        this.depSrok = depSrok;
    }

    public Long getDepType() {
        return depType;
    }

    public void setDepType(Long depType) {
        this.depType = depType;
    }

    public Integer getDepSrVozvrat() {
        return depSrVozvrat;
    }

    public void setDepSrVozvrat(Integer depSrVozvrat) {
        this.depSrVozvrat = depSrVozvrat;
    }

    public BigDecimal getDepPorogSum() {
        return depPorogSum;
    }

    public void setDepPorogSum(BigDecimal depPorogSum) {
        this.depPorogSum = depPorogSum;
    }

    public BigDecimal getDepSumSpis() {
        return depSumSpis;
    }

    public void setDepSumSpis(BigDecimal depSumSpis) {
        this.depSumSpis = depSumSpis;
    }

    public String getDepMaxSrok() {
        return depMaxSrok;
    }

    public void setDepMaxSrok(String depMaxSrok) {
        this.depMaxSrok = depMaxSrok;
    }

    public Boolean getDepStavSpis() {
        return depStavSpis;
    }

    public void setDepStavSpis(Boolean depStavSpis) {
        this.depStavSpis = depStavSpis;
    }

    public Boolean getDepUslRastor() {
        return depUslRastor;
    }

    public void setDepUslRastor(Boolean depUslRastor) {
        this.depUslRastor = depUslRastor;
    }

    public Boolean getDepBloc() {
        return depBloc;
    }

    public void setDepBloc(Boolean depBloc) {
        this.depBloc = depBloc;
    }

    public BigDecimal getDepSumdog() {
        return depSumdog;
    }

    public void setDepSumdog(BigDecimal depSumdog) {
        this.depSumdog = depSumdog;
    }

    public Boolean getDepAllowAddition() {
        return depAllowAddition;
    }

    public void setDepAllowAddition(Boolean depAllowAddition) {
        this.depAllowAddition = depAllowAddition;
    }

    public String getDepBanDeys() {
        return depBanDeys;
    }

    public void setDepBanDeys(String depBanDeys) {
        this.depBanDeys = depBanDeys;
    }

    public Long getDepStavRast() {
        return depStavRast;
    }

    public void setDepStavRast(Long depStavRast) {
        this.depStavRast = depStavRast;
    }

    public BigDecimal getDepStavka() {
        return depStavka;
    }

    public void setDepStavka(BigDecimal depStavka) {
        this.depStavka = depStavka;
    }

    public String getDepGoal() {
        return depGoal;
    }

    public void setDepGoal(String depGoal) {
        this.depGoal = depGoal;
    }

    public Boolean getDepShkalaStav() {
        return depShkalaStav;
    }

    public void setDepShkalaStav(Boolean depShkalaStav) {
        this.depShkalaStav = depShkalaStav;
    }

    public Boolean getDepKol() {
        return depKol;
    }

    public void setDepKol(Boolean depKol) {
        this.depKol = depKol;
    }

    public String getDepTypeNachProc() {
        return depTypeNachProc;
    }

    public void setDepTypeNachProc(String depTypeNachProc) {
        this.depTypeNachProc = depTypeNachProc;
    }

    public BigDecimal getDepProcRast() {
        return depProcRast;
    }

    public void setDepProcRast(BigDecimal depProcRast) {
        this.depProcRast = depProcRast;
    }

    public BigDecimal getDepMaxStav() {
        return depMaxStav;
    }

    public void setDepMaxStav(BigDecimal depMaxStav) {
        this.depMaxStav = depMaxStav;
    }

    public String getDepMaxLimit() {
        return depMaxLimit;
    }

    public void setDepMaxLimit(String depMaxLimit) {
        this.depMaxLimit = depMaxLimit;
    }

    public BigDecimal getDepProcTakeAllow() {
        return depProcTakeAllow;
    }

    public void setDepProcTakeAllow(BigDecimal depProcTakeAllow) {
        this.depProcTakeAllow = depProcTakeAllow;
    }

    public String getDepMinSrok() {
        return depMinSrok;
    }

    public void setDepMinSrok(String depMinSrok) {
        this.depMinSrok = depMinSrok;
    }

    public BigDecimal getDepStavRastVal() {
        return depStavRastVal;
    }

    public void setDepStavRastVal(BigDecimal depStavRastVal) {
        this.depStavRastVal = depStavRastVal;
    }

    public String getDepSrokWaitReturn() {
        return depSrokWaitReturn;
    }

    public void setDepSrokWaitReturn(String depSrokWaitReturn) {
        this.depSrokWaitReturn = depSrokWaitReturn;
    }

    public Boolean getDepLimit() {
        return depLimit;
    }

    public void setDepLimit(Boolean depLimit) {
        this.depLimit = depLimit;
    }

    public Boolean getDepTypeContract() {
        return depTypeContract;
    }

    public void setDepTypeContract(Boolean depTypeContract) {
        this.depTypeContract = depTypeContract;
    }

    public Boolean getDepAdditionalIncome() {
        return depAdditionalIncome;
    }

    public void setDepAdditionalIncome(Boolean depAdditionalIncome) {
        this.depAdditionalIncome = depAdditionalIncome;
    }

    public Boolean getDepKontrMaxStav() {
        return depKontrMaxStav;
    }

    public void setDepKontrMaxStav(Boolean depKontrMaxStav) {
        this.depKontrMaxStav = depKontrMaxStav;
    }

    public Long getDepCurrency() {
        return depCurrency;
    }

    public void setDepCurrency(Long depCurrency) {
        this.depCurrency = depCurrency;
    }

    public BigDecimal getDepStavPorog() {
        return depStavPorog;
    }

    public void setDepStavPorog(BigDecimal depStavPorog) {
        this.depStavPorog = depStavPorog;
    }

}

