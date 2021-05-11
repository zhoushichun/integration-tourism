package com.ifm.test;


import cn.hutool.core.util.RandomUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");

        int i = RandomUtil.randomInt(1, 100);

        System.out.println(i);

    }
}
