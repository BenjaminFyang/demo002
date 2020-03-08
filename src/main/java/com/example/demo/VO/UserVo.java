package com.example.demo.VO;

import lombok.Data;

/**
 * <用户的返回的信息>
 *
 * @author fangyang
 * @create 2020-03-08
 * @since 1.0.0
 */
@Data
public class UserVo {

    private Long userId;

    private String userName;

    @Override
    public String toString() {
        return "UserVo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
