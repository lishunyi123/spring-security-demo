package com.lishunyi.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author 李顺仪
 * @CreateDate 2019/10/11 15:28
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/11 15:28
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String username;

    private String password;

    private String nickname;
}
