package xyz.fpointzero.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {
        // 邮箱账户信息
        String senderEmail = "781381449@qq.com";
        String senderPassword = "wsnazaxxnkalbfeb";

        // 收件人信息
        String recipientEmail = args[0];

        // 邮件主题和内容
        String emailSubject = "验证码";
        String emailContent = args[1];

        // 邮件服务器配置
        String smtpHost = "smtp.qq.com";
        int smtpPort = 587;

        try {
            // 设置邮件服务器属性
            Properties props = new Properties();
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", smtpPort);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // 其他 QQ 邮箱特定配置
            props.put("mail.smtp.ssl.trust", smtpHost);  // 添加信任的主机

            // 创建Session对象
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, senderPassword);
                }
            });

            // 创建邮件消息
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(emailSubject);
            message.setText(emailContent);

            // 发送邮件
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
