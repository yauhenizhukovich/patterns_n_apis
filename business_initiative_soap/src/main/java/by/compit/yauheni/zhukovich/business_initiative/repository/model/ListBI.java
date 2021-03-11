package by.compit.yauheni.zhukovich.business_initiative.repository.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LIST_BI")
public class ListBI {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_LIST_BI_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "ID")
    private Long id;
    @Column(name = "BUSINESSINITIATIVE_ID")
    private Long biId;
    @Column(name = "BUSINESSINITIATIVE_NAME")
    private String biName;
    @Column(name = "BUSINESSINITIATIVE_DATE")
    private LocalDate biDate;
    @Column(name = "BUSINESSINITIATIVE_STATUS")
    private String biStatus;
    @Column(name = "BUSINESSOFFER_ID")
    private Long boId;
    @Column(name = "BUSINESSOFFER_NAME")
    private String boName;
    @Column(name = "BUSINESSOFFER_DATE")
    private LocalDate boDate;
    @Column(name = "BUSINESSOFFER_STATUS")
    private String boStatus;
    @Column(name = "BPCARD_ID")
    private Long bpcId;
    @Column(name = "BPCARD_PRODUCTNAME")
    private String bpcName;
    @Column(name = "BPCARD_PRODUCTSTATUS")
    private String bpcStatus;

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public String getBoName() {
        return boName;
    }

    public void setBoName(String boName) {
        this.boName = boName;
    }

    public LocalDate getBoDate() {
        return boDate;
    }

    public void setBoDate(LocalDate boDate) {
        this.boDate = boDate;
    }

    public String getBoStatus() {
        return boStatus;
    }

    public void setBoStatus(String boStatus) {
        this.boStatus = boStatus;
    }

    public void setBiName(String name) {
        this.biName = name;
    }

    public String getBiName() {
        return biName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBiDate(LocalDate date) {
        this.biDate = date;
    }

    public LocalDate getBiDate() {
        return biDate;
    }

    public void setBiStatus(String status) {
        this.biStatus = status;
    }

    public String getBiStatus() {
        return biStatus;
    }

    public void setBiId(Long biId) {
        this.biId = biId;
    }

    public Long getBiId() {
        return biId;
    }

    public void setBpcName(String bpcName) {
        this.bpcName = bpcName;
    }

    public String getBpcName() {
        return bpcName;
    }

    public void setBpcStatus(String bpcStatus) {
        this.bpcStatus = bpcStatus;
    }

    public String getBpcStatus() {
        return bpcStatus;
    }

    public void setBpcId(Long bpcId) {
        this.bpcId = bpcId;
    }

    public Long getBpcId() {
        return bpcId;
    }

}
