package com.star.learningapplication.room.model.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "token")
    public String token;

    @ColumnInfo(name = "phoneNo")
    public String phoneNo;

    public String passwood;

    /**
     * @author Aloha
     * @date 2020/10/20 23:27
     * @explain rsa秘钥
     */
    public String rsaKey;

    /**
     * @author Aloha
     * @date 2020/10/20 23:26
     * @explain 谷歌验证码动态密码
     */
    public String authCode;

    /**
     * @author Aloha
     * @date 2020/11/20 15:49
     * @explain 用户转账户名
     */
    public String transferUserName;

    /**
     * @author Aloha
     * @date 2020/11/26 14:19
     * @explain 币商标识，boolean  币商为true，普通用户为false
     */
    public boolean merchant;

    public User(String phoneNo, String passwood, String token, boolean merchant) {
        this.token = token;
        this.phoneNo = phoneNo;
        this.passwood = passwood;
        this.merchant = merchant;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPasswood() {
        return passwood;
    }

    public void setPasswood(String passwood) {
        this.passwood = passwood;
    }

    public String getRsaKey() {
        return rsaKey;
    }

    public void setRsaKey(String rsaKey) {
        this.rsaKey = rsaKey;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getTransferUserName() {
        return transferUserName;
    }

    public void setTransferUserName(String transferUserName) {
        this.transferUserName = transferUserName;
    }

    public boolean isMerchant() {
        return merchant;
    }

    public void setMerchant(boolean merchant) {
        this.merchant = merchant;
    }
}
