package cn.crscube.portal.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncrytedPasswordUtils {
    // Encryte Password with BCryptPasswordEncoder

    /**
     * BCrypt 패스워드 암호화
     * @param password
     * @return encode password값
     */
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

//    public static String passwordEncoder(String userId , String password) {
//        ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
//        return shaPasswordEncoder.encodePassword(password, userId.toUpperCase());
//
//    }

    public static void main(String[] args) {
        String password = "123";
        String encrytedPassword = encrytePassword(password);

        System.out.println("Encryted Password: " + encrytedPassword);
    }
}
