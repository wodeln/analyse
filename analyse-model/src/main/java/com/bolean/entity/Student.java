package com.bolean.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name = "tb_student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private Long classId;

    private String headImg;

    private Integer studentAliId;

    private String hProvince;

    private String hDistrict;

    private String hAddress;

    private String nowAddress;

    private String contactNum;

    private String contactName;

    /**
     * 状态 0:删除 1:锁定 2:正常
     */
    private Integer status;

    /**
     * 学生年龄
     */
    private Integer studentAge;

    /**
     * 学生身份证号码
     */
    private String studentCardNum;

    /**
     * 学号
     */
    private String studentCode;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 性别 1:男 2:女
     */
    private Integer studentSex;

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
    private Long createId;

    /**
     * 添加人姓名
     */
    private String createName;

    /**
     * 更新人id
     */
    private Long updateId;

    /**
     * 更新人姓名
     */
    private String updateName;

    /**
     * 班级名称
     */
    @Transient
    private String className;

    /**
     * 备注
     */
    private String memo;

    /**
     * 1：在校  0：离校
     */
    private Integer isin;

    private Integer isIn;

    private static final long serialVersionUID = 1L;

    public Integer getStudentAliId() {
        return studentAliId;
    }

    public void setStudentAliId(Integer studentAliId) {
        this.studentAliId = studentAliId;
    }

    public String gethProvince() {
        return hProvince;
    }

    public void sethProvince(String hProvince) {
        this.hProvince = hProvince;
    }

    public String gethDistrict() {
        return hDistrict;
    }

    public void sethDistrict(String hDistrict) {
        this.hDistrict = hDistrict;
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setStudentSex(Integer studentSex) {
        this.studentSex = studentSex;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentCardNum() {
        return studentCardNum;
    }

    public void setStudentCardNum(String studentCardNum) {
        this.studentCardNum = studentCardNum;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(int studentSex) {
        this.studentSex = studentSex;
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

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
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

    public Integer getIsin() {
        return isin;
    }

    public void setIsin(Integer isin) {
        this.isin = isin;
    }

    public Integer getIsIn() {
        return isIn;
    }

    public void setIsIn(Integer isIn) {
        this.isIn = isIn;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", classId=").append(classId);
        sb.append(", headImg=").append(headImg);
        sb.append(", status=").append(status);
        sb.append(", studentAge=").append(studentAge);
        sb.append(", studentCardNum=").append(studentCardNum);
        sb.append(", studentCode=").append(studentCode);
        sb.append(", studentName=").append(studentName);
        sb.append(", studentSex=").append(studentSex);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateName=").append(updateName);
        sb.append(", memo=").append(memo);
        sb.append(", isin=").append(isin);
        sb.append(", isIn=").append(isIn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}