package com.chilema.entity;
/**
 * 用户
 * @author Administrator
 *
 */
public class User {
    private String userId;

    private String password;

    private String loginUser;

    private String phone;

    private String email;

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getloginUser() {
        return loginUser;
    }

    public void setloginUser(String loginUser) {
        this.loginUser = loginUser == null ? null : loginUser.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", loginUser=" + loginUser + ", phone=" + phone
				+ ", email=" + email + "]";
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    
}