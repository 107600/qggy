package cn.itcast.jk.domain;

public class CraftsmanDomain {
    private Integer id;
    private String domainName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   /*   原错误，导致前台接受到的数据为domainNanme
        public String getDomainNanme() {
        return domainName;
    }*/

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public String toString() {
        return "CraftsmanDomain{" +
                "id=" + id +
                ", domainName='" + domainName + '\'' +
                '}';
    }
}
