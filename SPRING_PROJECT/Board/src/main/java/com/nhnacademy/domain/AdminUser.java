package com.nhnacademy.domain;

public class AdminUser implements User{

    private Users adminUsers;

    public AdminUser(Users adminUsers) {
        this.adminUsers = adminUsers;
    }

    @Override
    public String getId() {
        return adminUsers.getId();
    }

    @Override
    public void setId(String id) {
        adminUsers.setId(id);
    }

    @Override
    public String getPassword() {
        return adminUsers.getPassword();
    }

    @Override
    public void setPassword(String password) {
        adminUsers.setPassword(password);
    }

    @Override
    public String getName() {
        return adminUsers.getName();
    }

    @Override
    public void setName(String name) {
        adminUsers.setName(name);
    }

    @Override
    public String getProfileFileName() {
        return adminUsers.getProfileFileName();
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        adminUsers.setProfileFileName(profileFileName);
    }
}
