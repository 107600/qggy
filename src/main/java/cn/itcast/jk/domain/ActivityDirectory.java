package cn.itcast.jk.domain;

import java.io.Serializable;

public class ActivityDirectory {
    private Integer id;
    private String activityCategory;
    private Integer parentId;
    private Integer rank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityCategory() {
        return activityCategory;
    }

    public void setActivityCategory(String activityCategory) {
        this.activityCategory = activityCategory;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "ActivityDirectoryController{" +
                "id=" + id +
                ", activityCategory='" + activityCategory + '\'' +
                ", parentId=" + parentId +
                ", rank=" + rank +
                '}';
    }
}
