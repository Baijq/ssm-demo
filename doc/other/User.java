package com.demo.entity;

import lombok.Data;

/**
 * User
 *
 * @author biubiu
 */
@Data
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String mail;
    private String state;
    private String reward;
}
