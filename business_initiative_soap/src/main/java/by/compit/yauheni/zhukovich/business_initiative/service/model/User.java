package by.compit.yauheni.zhukovich.business_initiative.service.model;

public class User {

    private String name;
    private String email;
    private String description;
    private String departmentNumber;

    public User(String name, String email, String description, String departmentNumber) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.departmentNumber = departmentNumber;
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

}
