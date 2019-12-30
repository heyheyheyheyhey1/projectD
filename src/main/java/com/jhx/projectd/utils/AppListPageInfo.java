package com.jhx.projectd.utils;

public class AppListPageInfo {
    String querySoftwareName;
    Integer queryStatusId;
    Integer queryFlatformId;
    Integer queryCategoryLevel1Id;
    Integer queryCategoryLevel2Id;
    Integer queryCategoryLevel3Id;
    Integer devId;
    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public String getQuerySoftwareName() {
        return querySoftwareName;
    }

    public void setQuerySoftwareName(String querySoftwareName) {
        this.querySoftwareName = querySoftwareName;
    }

    public Integer getQueryStatusId() {
        return queryStatusId;
    }

    public void setQueryStatusId(Integer queryStatusId) {
        this.queryStatusId = queryStatusId;
    }

    public Integer getQueryFlatformId() {
        return queryFlatformId;
    }

    public void setQueryFlatformId(Integer queryFlatformId) {
        this.queryFlatformId = queryFlatformId;
    }

    public Integer getQueryCategoryLevel1Id() {
        return queryCategoryLevel1Id;
    }

    public void setQueryCategoryLevel1Id(Integer queryCategoryLevel1Id) {
        this.queryCategoryLevel1Id = queryCategoryLevel1Id;
    }

    public Integer getQueryCategoryLevel2Id() {
        return queryCategoryLevel2Id;
    }

    public void setQueryCategoryLevel2Id(Integer queryCategoryLevel2Id) {
        this.queryCategoryLevel2Id = queryCategoryLevel2Id;
    }

    public Integer getQueryCategoryLevel3Id() {
        return queryCategoryLevel3Id;
    }

    public void setQueryCategoryLevel3Id(Integer queryCategoryLevel3Id) {
        this.queryCategoryLevel3Id = queryCategoryLevel3Id;
    }

    @Override
    public String toString() {
        return "AppListPageInfo{" +
                "querySoftwareName='" + querySoftwareName + '\'' +
                ", queryStatusId=" + queryStatusId +
                ", queryFlatformId=" + queryFlatformId +
                ", queryCategoryLevel1Id=" + queryCategoryLevel1Id +
                ", queryCategoryLevel2Id=" + queryCategoryLevel2Id +
                ", queryCategoryLevel3Id=" + queryCategoryLevel3Id +
                '}';
    }
}
