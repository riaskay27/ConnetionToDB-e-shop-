package com.mainacad.dao;

import com.mainacad.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private static List<User> users;

    @BeforeAll
    static void setPreConditions(){
        users=new ArrayList<>();
    }
    @Test
    void save() {
        User user=new User("testLogin","testPass","testName","testLastname","testEmail","12345");
        UserDAO.save(user);
        users.add(user);
        assertNotNull(user.getId());
    }
    @Test
    void update() {
       User user=new User("testLogin","testPass","testName","testLastname","testEmail","12345");
        User savedUser=UserDAO.save(user);
        users.add(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals("testPass",savedUser.getPassword());

        user.setId(savedUser.getId());
        user.setPassword("newPass");
        User updatedUser=UserDAO.update(user);

        assertNotNull(updatedUser);
        //assertNotEquals(updatedUser.getPassword(),savedUser.getPassword());
        assertEquals("newPass",updatedUser.getPassword());
    }

    @Test
    void getAndDelete() {
        User user=new User("testLogin","testPass","testName","testLastname","testEmail","12345");
        UserDAO.save(user);
        assertNotNull(user.getId());
        User targetUser=UserDAO.getById(user.getId());
        UserDAO.delete(targetUser.getId());
        targetUser=UserDAO.getById(user.getId());
        assertNull(targetUser);


    }
    @AfterAll
    static void deleteTestData(){

        users.forEach(it->UserDAO.delete(it.getId()));
    }
}