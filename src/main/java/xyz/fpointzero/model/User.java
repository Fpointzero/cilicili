package xyz.fpointzero.model;

import org.apache.ibatis.session.SqlSession;
import xyz.fpointzero.mapper.UserMapper;
import xyz.fpointzero.util.EmailSender;
import xyz.fpointzero.util.MyBatisUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String avatar;
    private String verification;
    private String verificationTime;

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
            if (user.getPassword().equals(password)) {
//                this.username = user.username;
//                this.phoneNumber = user.phoneNumber;
//                this.email = user.email;
//                this.avatar = user.avatar;
//                this.password = null;
                setUser(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean updateAvatar(String avatar) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.setAvatar(avatar, username);
            sqlSession.commit();
            setAvatar(avatar);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAll(User user) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.setAll(user);
            sqlSession.commit();
            setUser(user);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setUser(User user) {
        if (user.id != null)
            this.id = user.id;
        if (user.username != null)
            this.username = user.username;
        if (user.phoneNumber != null)
            this.phoneNumber = user.phoneNumber;
        if (user.email != null)
            this.email = user.email;
        if (user.avatar != null)
            this.avatar = user.avatar;
        this.password = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getVerification() {
        return verification;
    }

    public String getVerificationTime() {
        return verificationTime;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }
}
