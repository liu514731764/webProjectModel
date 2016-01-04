package com.liuping.user.model;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by liuping on 15/12/9.
 */
@Entity
public class User {
    private String userId;

    @Id
    @javax.persistence.Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userCode;

    @Basic
    @javax.persistence.Column(name = "USER_CODE")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    private String userName;

    @Basic
    @javax.persistence.Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userPhone;

    @Basic
    @javax.persistence.Column(name = "USER_PHONE")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    private String userEmail;

    @Basic
    @javax.persistence.Column(name = "USER_EMAIL")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String isCertification;

    @Basic
    @javax.persistence.Column(name = "IS_CERTIFICATION")
    public String getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(String isCertification) {
        this.isCertification = isCertification;
    }

    private String userSex;

    @Basic
    @javax.persistence.Column(name = "USER_SEX")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    private String userImage;

    @Basic
    @javax.persistence.Column(name = "USER_IMAGE")
    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    private String userCityId;

    @Basic
    @javax.persistence.Column(name = "USER_CITY_ID")
    public String getUserCityId() {
        return userCityId;
    }

    public void setUserCityId(String userCityId) {
        this.userCityId = userCityId;
    }

    private String userBiogUrl;

    @Basic
    @javax.persistence.Column(name = "USER_BIOG_URL")
    public String getUserBiogUrl() {
        return userBiogUrl;
    }

    public void setUserBiogUrl(String userBiogUrl) {
        this.userBiogUrl = userBiogUrl;
    }

    private String introduce;

    @Basic
    @javax.persistence.Column(name = "INTRODUCE")
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    private String loginPwd;

    @Basic
    @javax.persistence.Column(name = "LOGIN_PWD")
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    private String paymentPwd;

    @Basic
    @javax.persistence.Column(name = "PAYMENT_PWD")
    public String getPaymentPwd() {
        return paymentPwd;
    }

    public void setPaymentPwd(String paymentPwd) {
        this.paymentPwd = paymentPwd;
    }

    private String birthday;

    @Basic
    @javax.persistence.Column(name = "BIRTHDAY")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private String remark;

    @Basic
    @javax.persistence.Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private Date createTime;

    @Basic
    @javax.persistence.Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String wechatId;

    @Basic
    @javax.persistence.Column(name = "WECHAT_ID")
    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    private String qqId;

    @Basic
    @javax.persistence.Column(name = "QQ_ID")
    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    private String superId;

    @Basic
    @javax.persistence.Column(name = "SUPER_ID")
    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    private String sinaId;

    @Basic
    @javax.persistence.Column(name = "SINA_ID")
    public String getSinaId() {
        return sinaId;
    }

    public void setSinaId(String sinaId) {
        this.sinaId = sinaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userCode != null ? !userCode.equals(user.userCode) : user.userCode != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPhone != null ? !userPhone.equals(user.userPhone) : user.userPhone != null) return false;
        if (userEmail != null ? !userEmail.equals(user.userEmail) : user.userEmail != null) return false;
        if (isCertification != null ? !isCertification.equals(user.isCertification) : user.isCertification != null)
            return false;
        if (userSex != null ? !userSex.equals(user.userSex) : user.userSex != null) return false;
        if (userImage != null ? !userImage.equals(user.userImage) : user.userImage != null) return false;
        if (userCityId != null ? !userCityId.equals(user.userCityId) : user.userCityId != null) return false;
        if (userBiogUrl != null ? !userBiogUrl.equals(user.userBiogUrl) : user.userBiogUrl != null) return false;
        if (introduce != null ? !introduce.equals(user.introduce) : user.introduce != null) return false;
        if (loginPwd != null ? !loginPwd.equals(user.loginPwd) : user.loginPwd != null) return false;
        if (paymentPwd != null ? !paymentPwd.equals(user.paymentPwd) : user.paymentPwd != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (remark != null ? !remark.equals(user.remark) : user.remark != null) return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;
        if (wechatId != null ? !wechatId.equals(user.wechatId) : user.wechatId != null) return false;
        if (qqId != null ? !qqId.equals(user.qqId) : user.qqId != null) return false;
        if (superId != null ? !superId.equals(user.superId) : user.superId != null) return false;
        if (sinaId != null ? !sinaId.equals(user.sinaId) : user.sinaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (isCertification != null ? isCertification.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userImage != null ? userImage.hashCode() : 0);
        result = 31 * result + (userCityId != null ? userCityId.hashCode() : 0);
        result = 31 * result + (userBiogUrl != null ? userBiogUrl.hashCode() : 0);
        result = 31 * result + (introduce != null ? introduce.hashCode() : 0);
        result = 31 * result + (loginPwd != null ? loginPwd.hashCode() : 0);
        result = 31 * result + (paymentPwd != null ? paymentPwd.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (wechatId != null ? wechatId.hashCode() : 0);
        result = 31 * result + (qqId != null ? qqId.hashCode() : 0);
        result = 31 * result + (superId != null ? superId.hashCode() : 0);
        result = 31 * result + (sinaId != null ? sinaId.hashCode() : 0);
        return result;
    }
}
