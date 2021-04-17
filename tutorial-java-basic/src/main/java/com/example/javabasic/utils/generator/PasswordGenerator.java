package com.example.javabasic.utils.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 随机密码生成器
 *
 * @author chenpenghui
 * @date 2020-10-24
 */
public class PasswordGenerator {
    /**
     * 密码能包含的特殊字符
     */
    private static final char[] allowedSpecialCharactors = {
            '`', '~', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[',
            '{', '}', ']', '\\', '|', ';', ':', '"', '\'', ',', '<', '.', '>', '/', '?'};
    private static final int letterRange = 26;
    private static final int numberRange = 10;
    private static final int spCharactorRange = allowedSpecialCharactors.length;
    private static final Random random = new Random();
    /**
     * 密码的长度
     */
    private int passwordLength;
    /**
     * 密码包含字符的最少种类
     */
    private int minVariousType;

    public PasswordGenerator(int passwordLength, int minVariousType) {
        if (minVariousType > CharactorType.values().length) {
            minVariousType = CharactorType.values().length;
        }
        if (minVariousType > passwordLength) {
            minVariousType = passwordLength;
        }
        this.passwordLength = passwordLength;
        this.minVariousType = minVariousType;
    }

    public String generateRandomPassword() {
        char[] password = new char[passwordLength];
        List<Integer> pwCharsIndex = new ArrayList();
        for (int i = 0; i < password.length; i++) {
            pwCharsIndex.add(i);
        }
        List<CharactorType> takeTypes = new ArrayList(Arrays.asList(CharactorType.values()));
        List<CharactorType> fixedTypes = Arrays.asList(CharactorType.values());
        int typeCount = 0;
        while (pwCharsIndex.size() > 0) {
            // 随机填充一位密码
            int pwIndex = pwCharsIndex.remove(random.nextInt(pwCharsIndex.size()));
            Character c;
            if (typeCount < minVariousType) {
                // 生成不同种类字符
                c = generateCharacter(takeTypes.remove(random.nextInt(takeTypes.size())));
                typeCount++;
            } else {
                // 随机生成所有种类密码
                c = generateCharacter(fixedTypes.get(random.nextInt(fixedTypes.size())));
            }
            password[pwIndex] = c.charValue();
        }
        return String.valueOf(password);
    }

    private Character generateCharacter(CharactorType type) {
        Character c = null;
        int rand;
        switch (type) {
            // 随机小写字母
            case LOWERCASE:
                rand = random.nextInt(letterRange);
                rand += 97;
                c = new Character((char) rand);
                break;
            // 随机大写字母
            case UPPERCASE:
                rand = random.nextInt(letterRange);
                rand += 65;
                c = new Character((char) rand);
                break;
            // 随机数字
            case NUMBER:
                rand = random.nextInt(numberRange);
                rand += 48;
                c = new Character((char) rand);
                break;
            // 随机特殊字符
            case SPECIAL_CHARACTOR:
                rand = random.nextInt(spCharactorRange);
                c = new Character(allowedSpecialCharactors[rand]);
                break;
            default:
        }
        return c;
    }
}

/**
 * 密码值种类:小写字母、大写字母、数字、特殊字符
 */
enum CharactorType {
    LOWERCASE,
    UPPERCASE,
    NUMBER,
    SPECIAL_CHARACTOR
}
