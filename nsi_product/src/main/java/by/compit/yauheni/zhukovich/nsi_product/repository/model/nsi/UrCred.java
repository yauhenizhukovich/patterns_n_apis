package by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "URCRED")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UrCred {

    @Id
    @Column(name = "DIMID")
    private Long dimid;
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "UR_TYPE_KRED")
    private String urTypeKred;
    @Column(name = "UR_BUSINESS_CATEGORY")
    private String urBusinessCategory;
    @Column(name = "UR_KD_POK")
    private String urKdPok;
    @Column(name = "UR_FORMA_KRED")
    private String urFormaKred;
    @Column(name = "UR_TYPE_FAK")
    private String urTypeFak;
    @Column(name = "UR_CURRISPOL")
    private String urCurrispol;
    @Column(name = "UR_SROK_OBOR")
    private String urSrokObor;
    @Column(name = "CLOSE_VALUE")
    private String closeValue;
    @Column(name = "CLOSE_DATESTART")
    private String closeDatestart;
    @Column(name = "UR_SROK_DOGOV")
    private String urSrokDogov;
    @Column(name = "UR_CEL_NAZNACH")
    private String urCelNaznach;
    @Column(name = "UR_CURR_KD")
    private String urCurrKd;
    @Column(name = "UR_SROK_PRED")
    private String urSrokPred;
    @Column(name = "UR_USL_PLAT")
    private String urUslPlat;
    @Column(name = "UR_MAXSUMGAR")
    private String urMaxsumgar;
    @Column(name = "UR_FORMA_FAK")
    private String urFormaFak;
    @Column(name = "UR_VID_GAR")
    private String urVidGar;
    @Column(name = "UR_FOR_SDBO")
    private String urForSdbo;
    @Column(name = "PARENTID")
    private Long parentid;

    public Long getDimid() {
        return dimid;
    }

    public void setDimid(Long dimid) {
        this.dimid = dimid;
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

    public String getUrTypeKred() {
        return urTypeKred;
    }

    public void setUrTypeKred(String urTypeKred) {
        this.urTypeKred = urTypeKred;
    }

    public String getUrBusinessCategory() {
        return urBusinessCategory;
    }

    public void setUrBusinessCategory(String urBusinessCategory) {
        this.urBusinessCategory = urBusinessCategory;
    }

    public String getUrKdPok() {
        return urKdPok;
    }

    public void setUrKdPok(String urKdPok) {
        this.urKdPok = urKdPok;
    }

    public String getUrFormaKred() {
        return urFormaKred;
    }

    public void setUrFormaKred(String urFormaKred) {
        this.urFormaKred = urFormaKred;
    }

    public String getUrTypeFak() {
        return urTypeFak;
    }

    public void setUrTypeFak(String urTypeFak) {
        this.urTypeFak = urTypeFak;
    }

    public String getUrCurrispol() {
        return urCurrispol;
    }

    public void setUrCurrispol(String urCurrispol) {
        this.urCurrispol = urCurrispol;
    }

    public String getUrSrokObor() {
        return urSrokObor;
    }

    public void setUrSrokObor(String urSrokObor) {
        this.urSrokObor = urSrokObor;
    }

    public String getCloseValue() {
        return closeValue;
    }

    public void setCloseValue(String closeValue) {
        this.closeValue = closeValue;
    }

    public String getCloseDatestart() {
        return closeDatestart;
    }

    public void setCloseDatestart(String closeDatestart) {
        this.closeDatestart = closeDatestart;
    }

    public String getUrSrokDogov() {
        return urSrokDogov;
    }

    public void setUrSrokDogov(String urSrokDogov) {
        this.urSrokDogov = urSrokDogov;
    }

    public String getUrCelNaznach() {
        return urCelNaznach;
    }

    public void setUrCelNaznach(String urCelNaznach) {
        this.urCelNaznach = urCelNaznach;
    }

    public String getUrCurrKd() {
        return urCurrKd;
    }

    public void setUrCurrKd(String urCurrKd) {
        this.urCurrKd = urCurrKd;
    }

    public String getUrSrokPred() {
        return urSrokPred;
    }

    public void setUrSrokPred(String urSrokPred) {
        this.urSrokPred = urSrokPred;
    }

    public String getUrUslPlat() {
        return urUslPlat;
    }

    public void setUrUslPlat(String urUslPlat) {
        this.urUslPlat = urUslPlat;
    }

    public String getUrMaxsumgar() {
        return urMaxsumgar;
    }

    public void setUrMaxsumgar(String urMaxsumgar) {
        this.urMaxsumgar = urMaxsumgar;
    }

    public String getUrFormaFak() {
        return urFormaFak;
    }

    public void setUrFormaFak(String urFormaFak) {
        this.urFormaFak = urFormaFak;
    }

    public String getUrVidGar() {
        return urVidGar;
    }

    public void setUrVidGar(String urVidGar) {
        this.urVidGar = urVidGar;
    }

    public String getUrForSdbo() {
        return urForSdbo;
    }

    public void setUrForSdbo(String urForSdbo) {
        this.urForSdbo = urForSdbo;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

}

