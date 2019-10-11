package com.lishunyi.securitylogindb.service.impl;

import com.lishunyi.securitylogindb.entity.User;
import com.lishunyi.securitylogindb.repository.UserRepository;
import com.lishunyi.securitylogindb.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
