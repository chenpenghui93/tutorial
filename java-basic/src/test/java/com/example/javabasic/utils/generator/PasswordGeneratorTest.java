package com.example.javabasic.utils.generator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenpenghui
 * @date 2020-10-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordGeneratorTest {
    @Test
    public void test() {
        System.out.println(new PasswordGenerator(15, 4).generateRandomPassword());
    }

}