package by.compit.yauheni.zhukovich.business_initiative.repository.model.change_history;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORY_CHANGE")
public class HistoryChange implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "CTL_TYPE")
    private Integer type;
    @Column(name = "ATTR_NAME")
    private String attributeName;
    @Column(name = "VALUE_OLD")
    private String valueOld;
    @Column(name = "VALUE_NEW")
    private String valueNew;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "CHANGE_DATE")
    private LocalDate changeDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getValueOld() {
        return valueOld;
    }

    public void setValueOld(String valueOld) {
        this.valueOld = valueOld;
    }

    public String getValueNew() {
        return valueNew;
    }

    public void setValueNew(String valueNew) {
        this.valueNew = valueNew;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
