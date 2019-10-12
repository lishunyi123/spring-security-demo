package com.lishunyi.security.service.impl;

import com.lishunyi.security.entity.User;
import com.lishunyi.security.repository.UserRepository;
import com.lishunyi.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName UserServiceImpl
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/11 15:40
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/11 15:40
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    private static final Map<Integer, String> ENCODER_TYPE = new HashMap<>(16);

    private static final Map<String, PasswordEncoder> ENCODER_MAP = new HashMap<>(16);

    private static final String PASSWORD_FORMAT = "{%s}%s";

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    static {
        ENCODER_TYPE.put(0, "noop");
        ENCODER_TYPE.put(1, "bcrypt");
        ENCODER_TYPE.put(2, "pbkdf2");
        ENCODER_TYPE.put(3, "scrypt");
        ENCODER_TYPE.put(4, "sha256");
        ENCODER_MAP.put("noop", NoOpPasswordEncoder.getInstance());
        ENCODER_MAP.put("bcrypt", new BCryptPasswordEncoder());
        ENCODER_MAP.put("pbkdf2", new Pbkdf2PasswordEncoder());
        ENCODER_MAP.put("scrypt", new SCryptPasswordEncoder());
        ENCODER_MAP.put("sha256", new StandardPasswordEncoder());
    }

    /**
     * 插入
     *
     * @param user
     */
    @Override
    public void insert(User user) {
        if (exit(user.getUsername())) {
            throw new RuntimeException("用户名已存在！");
        }
        long id = System.currentTimeMillis();
        user.setId(id);
        encryptPassword(user);
        userRepository.insert(user);
    }

    /**
     * 根据名称查询
     *
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 判断用户名已存在
     * @param username
     * @return
     */
    private boolean exit(String username) {
        User user = userRepository.findByUsername(username);
        return (user != null);
    }

    private void encryptPassword(User user) {
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
    }
}
