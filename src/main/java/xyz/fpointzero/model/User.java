package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.UserMapper;
import xyz.fpointzero.util.EmailSender;
import xyz.fpointzero.util.MyBatisUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class User {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String very;
    private String time;

    public boolean login() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 调用数据访问接口的方法进行数据操作
//            User entity = mapper.getById(1);
            User user = null;
            if (username == null)
                user = mapper.getByEmail(email);
            else
                user = mapper.getByUsername(username);

//            System.out.println(user.password + "-" + password);
            if (user.password.equals(password))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }
}
