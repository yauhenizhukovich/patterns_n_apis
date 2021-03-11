package by.compit.yauheni.zhukovich.weblogic_users.service.model;

public class User {

    private String name;
    private String email;
    private String description;
    private String departmentNumber;
    private String position;
    private String displayName;
    private String telephone;
    private String manager;
    private String managerDepartment;
    private String managerPosition;
    private String managerName;
    private String curator;
    private String curatorDepartment;
    private String curatorPosition;
    private String curatorName;

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public String getCuratorDepartment() {
        return curatorDepartment;
    }

    public void setCuratorDepartment(String curatorDepartment) {
        this.curatorDepartment = curatorDepartment;
    }

    public String getCuratorPosition() {
        return curatorPosition;
    }

    public void setCuratorPosition(String curatorPosition) {
        this.curatorPosition = curatorPosition;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerDepartment() {
        return managerDepartment;
    }

    public void setManagerDepartment(String managerDepartment) {
        this.managerDepartment = managerDepartment;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setManagerPosition(String managerPosition) {
        this.managerPosition = managerPosition;
    }

    public String getManagerPosition() {
        return managerPosition;
    }

}
