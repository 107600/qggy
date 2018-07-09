package cn.itcast.jk.domain;

public class TeacherDomain {
    private Integer id;
    private String domainName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public String toString() {
        return "TeacherDomain{" +
                "id=" + id +
                ", domainName='" + domainName + '\'' +
                '}';
    }
}
