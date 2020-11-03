package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.bo.UserBO;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<UserBO> userBOS = new ArrayList<>();
    {
        userBOS.add(new UserBO(1,"xiaozhang","147258","xiaozhang@qq.com"));
    }

    public void createUser(User user) {
        int index = userBOS.size()+1;
        UserBO userBO = UserBO.builder().id(index)
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail()).build();
        userBOS.add(userBO);
    }
}
