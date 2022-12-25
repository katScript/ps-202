package org.sem.authenticate.services;

import org.sem.authenticate.models.User;
import org.sem.authenticate.models.UserDAO;
import org.sem.utils.sercurity.MD5Utils;

import java.util.Optional;

public class UserService {
    public UserDAO userDAO = new UserDAO();

    public User registerUser(
            String userName,
            String password,
            String email
    ) {
        try {
            if (!userName.matches("^[a-zA-Z0-9]+$"))
                throw new RuntimeException("Username not valid");

            User loadUser = userDAO.findByUserName(userName).orElse(null);

            if (loadUser != null)
                throw new RuntimeException("User had exists!");

            User user = new User(
                    null,
                    userName,
                    MD5Utils.encode(password),
                    email
            );

            return userDAO.save(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> login(
            String userName,
            String password
    ) {
        try {
            User user = userDAO.getUserAuth(userName, MD5Utils.encode(password)).orElseThrow(
                    () -> new RuntimeException("Wrong username or password!")
            );

            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
