package com.cdut.Pojo;

/**
 * 用户详细信息
 */
public class UserInfo {
    private String userId;
    private String username;
    private String sex;
    private String email;
    private String address;
    private String phone;
    private Integer grade;

    public UserInfo(String userId, String username, String sex, String email, String address, String phone, Integer grade) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.grade = grade;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", grade=" + grade +
                '}';
    }
}
