package com.lishunyi.security.repository;

import com.lishunyi.security.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @InterfaceName UserRepository
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/11 15:31
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/11 15:31
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);
}
