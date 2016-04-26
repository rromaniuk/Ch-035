package com.crsms.dto;

import com.crsms.domain.Role;
import com.crsms.domain.TeacherRequest;
import com.crsms.domain.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.googlecode.jmapper.annotations.JMap;

public class UserJsonDto {

    @JMap
    private Long id;
    @JMap
    private String email;
    @JMap
    private String password;
    @JMap
    private boolean isEnabled;
    @JsonIgnore
    private UserInfo userInfo;
    @JsonIgnore
    private Role role;
    @JsonIgnore
    private TeacherRequest teacherRequest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public TeacherRequest getTeacherRequest() {
        return teacherRequest;
    }

    public void setTeacherRequest(TeacherRequest teacherRequest) {
        this.teacherRequest = teacherRequest;
    }
}
