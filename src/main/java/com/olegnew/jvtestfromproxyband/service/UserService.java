package com.olegnew.jvtestfromproxyband.service;

import com.olegnew.jvtestfromproxyband.model.User;
import java.util.List;

public interface UserService {
    List<User> finfAll();

    User add(User user);

    User update(User user);

    void remove(String id);
}
