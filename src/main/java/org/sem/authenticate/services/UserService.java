package org.sem.authenticate.services;

import org.sem.authenticate.models.User;
import org.sem.authenticate.models.UserDAO;
import org.sem.utils.sercurity.MD5Utils;

public class UserService {
    public UserDAO userDAO = new UserDAO();

    public Boolean registerUser(
            String userName,
            String password,
            String email
    ) {
        try {
            userDAO.findByUserName(userName).orElseThrow(
                    () -> new RuntimeException("This user has exists!")
            );

            User user = new User(
                    null,
                    userName,
                    MD5Utils.encode(password),
                    email
            );

            userDAO.save(user);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User login(
            String userName,
            String password
    ) {
        try {
            User user = userDAO.getUserAuth(userName, MD5Utils.encode(password)).orElseThrow(
                    () -> new RuntimeException("Wrong username or password!")
            );

            if (user != null) return user;
        } catch (Exception e) {
            return null;
        }

        return null;
    }
}
