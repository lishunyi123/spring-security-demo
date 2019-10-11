package com.lishunyi.securitylogindb.service;

import com.lishunyi.securitylogindb.entity.User;

/**
 * @InterfaceName UserService
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/11 15:35
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/11 15:35
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 插入
     * @param user
     */
    void insert(User user);

    /**
     * 根据名称查询
     * @param username
     * @return
     */
    User findByUsername(String username);
}
