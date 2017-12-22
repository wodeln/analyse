package com.bolean.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class Folder implements Serializable {
    private Integer folderId;

    /**
     * 权限(菜单)名称
     */
    private String folderName;

    private String icoStr;

    private String keyName;

    /**
     * 父ID
     */
    private Integer parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态 0:删除 1:锁定 2:正常
     */
    private int status;

    /**
     * 地址
     */
    private String url;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 添加人id
     */
    private Integer createId;

    /**
     * 添加人姓名
     */
    private String createName;

    /**
     * 更新人id
     */
    private Integer updateId;

    /**
     * 更新人姓名
     */
    private String updateName;

    /**
     * 备注
     */
    private String memo;

    private List<Folder> childFolders;

    private static final long serialVersionUID = 1L;

    public List<Folder> getChildFolders() {
        return childFolders;
    }

    public void setChildFolders(List<Folder> childFolders) {
        this.childFolders = childFolders;
    }

    public String getIcoStr() {
        return icoStr;
    }

    public void setIcoStr(String icoStr) {
        this.icoStr = icoStr;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", folderId=").append(folderId);
        sb.append(", folderName=").append(folderName);
        sb.append(", keyName=").append(keyName);
        sb.append(", parentId=").append(parentId);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", url=").append(url);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateName=").append(updateName);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}