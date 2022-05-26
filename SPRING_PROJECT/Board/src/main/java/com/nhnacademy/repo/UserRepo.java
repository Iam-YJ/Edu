package com.nhnacademy.repo;

import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepo implements UserRepository{
    private List<User> userList = new ArrayList<>();

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public void modify(User user) {
        for(User originUser:userList){
            if(originUser.getId().equals(user.getId())){
                originUser.setName(user.getName());
                originUser.setPassword(user.getPassword());
                originUser.setProfileFileName(user.getProfileFileName());
            }
        }
    }

    @Override
    public void remove(String id) {
        for(Iterator<User> iterator = userList.iterator(); iterator.hasNext();){
            User user = iterator.next();
            if(user.getId().equals(id)){
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public User getUser(String id) {
        for(User user:userList){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userList;
    }

    @Override
    public long getSize() {
        return userList.size();
    }
}
