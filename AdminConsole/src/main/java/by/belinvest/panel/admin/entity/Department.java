package by.belinvest.panel.admin.entity;

public class Department {
    private Long id;
    private String name;
    private String shortName;
    private String fDevelop;
    private String headId;
    private Long parentId;
    private String post;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getfDevelop() {
        return fDevelop;
    }

    public void setfDevelop(String fDevelop) {
        this.fDevelop = fDevelop;
    }

    public String getHeadId() {
        return headId;
    }

    public void setHeadId(String headId) {
        this.headId = headId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
