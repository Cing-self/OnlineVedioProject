//package com.cjh.onlinevedio.util;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.annotation.Resource;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//public class EmailUtil {
//
////    @Autowired
//    public static JavaMailSenderImpl javaMailSender;
//
//    static {
//        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\source\\OnlineVedioProject\\src\\main\\resource\\spring\\spring-email.xml");
//        javaMailSender = (JavaMailSenderImpl) context.getBean("javaMailSender");
//    }
//    private String setFrom = "cing_self0731@qq.com";
//
//    public void sendEmail(String setTo, String subject, String text){
//            //创建一个邮件对象
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//            //通过helper帮我们设置邮件内容
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//            try {
//                //设置发件人
//                helper.setFrom(setFrom);
//                //设置收件人
//                helper.setTo(setTo);
//                //设置邮件主题
//                helper.setSubject(subject);
//                //设置邮件正文
//                helper.setText(text);
//                //发送邮件
//                javaMailSender.send(mimeMessage);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//
//    }
//}
