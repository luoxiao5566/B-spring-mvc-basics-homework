package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();
    {
        users.add(new User("xiaozhang","147258","xiaozhang@qq.com"));
    }

    public void createUser(User user) {
        users.add(user);
    }
}
