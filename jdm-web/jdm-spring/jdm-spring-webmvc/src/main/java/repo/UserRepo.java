/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class UserRepo {

    private List<User> users;

    public UserRepo() {
        users = new ArrayList<>();
        User user1 = new User(1, "老王", 55);
        users.add(user1);
        User user2 = new User(2, "老张", 54);
        users.add(user2);
        User user3 = new User(3, "老李", 57);
        users.add(user3);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public int deleteUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return 1;
            }
        }
        return 0;
    }

}
