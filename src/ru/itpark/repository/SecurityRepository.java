package ru.itpark.repository;

import ru.itpark.domain.User;
import ru.itpark.exception.NoSuchUserException;

import java.util.ArrayList;
import java.util.List;

public class SecurityRepository {
    List<User> users = new ArrayList<>();


    public void add(User user) {
        users.add(user);
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new NoSuchUserException();
    }
}

