package com.nhnacademy.domain;

public class GeneralUser implements User {
    private Users generalUsers;

    public GeneralUser(Users generalUsers) {
        this.generalUsers = generalUsers;
    }

    @Override
    public String getId() {
        return generalUsers.getId();
    }

    @Override
    public void setId(String id) {
        generalUsers.setId(id);
    }

    @Override
    public String getPassword() {
        return generalUsers.getPassword();
    }

    @Override
    public void setPassword(String password) {
        generalUsers.setPassword(password);
    }

    @Override
    public String getName() {
        return generalUsers.getName();
    }

    @Override
    public void setName(String name) {
        generalUsers.setName(name);
    }

    @Override
    public String getProfileFileName() {
        return generalUsers.getProfileFileName();
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        generalUsers.setProfileFileName(profileFileName);
    }
}
