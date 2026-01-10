package com.xn.lmx.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    实体类
    ORM 框架
    实体类需要进行封装，编写Get与Set方法
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private int uId;            // User_ID
    private String uName;       // User_Name
    private String uPassword;   // User_Password
    private String uGender;     // User_Gender
    private String uPhone;      // User_Phone
    private String uGroup;      // User_Group
//
//    public int getuId() {
//        return uId;
//    }
//
//    public void setuId(int uId) {
//        this.uId = uId;
//    }
//
//    public String getuName() {
//        return uName;
//    }
//
//    public void setuName(String uName) {
//        this.uName = uName;
//    }
//
//    public String getuPassword() {
//        return uPassword;
//    }
//
//    public void setuPassword(String uPassword) {
//        this.uPassword = uPassword;
//    }
//
//    public String getuGender() {
//        return uGender;
//    }
//
//    public void setuGender(String uGender) {
//        this.uGender = uGender;
//    }
//
//    public String getuPhone() {
//        return uPhone;
//    }
//
//    public void setuPhone(String uPhone) {
//        this.uPhone = uPhone;
//    }
//
//    public String getuGroup() {
//        return uGroup;
//    }
//
//    public void setuGroup(String uGroup) {
//        this.uGroup = uGroup;
//    }
}
