package io.quarkus.samples.petclinic.service;

import graphql.schema.DataFetcher;
import io.quarkus.samples.petclinic.model.Perfume;
import io.quarkus.samples.petclinic.model.User;
import io.quarkus.samples.petclinic.service.Interface.IUserService;

import java.util.List;
import java.util.Map;

public class UserService implements  IUserService{

    @Override
    public User findUserById(Long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataFetcher<List<User>> getAllUsersByQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataFetcher<User> getUserByQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByPasswordResetCode(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Perfume> getCart(List<Long> perfumeIds) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> login(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean registerUser(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean activateUser(String code) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean sendPasswordResetCode(String email) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String passwordReset(String email, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void userSave(String username, Map<String, String> form, User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User updateProfile(String email, User user) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
