package com.nhnacademy.domain;

public class Users implements User {
    private String id;
    private String pwd;
    private String name;
    private String image;

    public Users(String id, String pwd, String name, String image) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.image = image;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public void setPassword(String password) {
        this.pwd = password;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfileFileName() {
        return this.image;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.name = profileFileName;
    }
}
