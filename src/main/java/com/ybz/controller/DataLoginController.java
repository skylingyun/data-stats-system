package com.ybz.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.ybz.utils.DataResult;
import com.ybz.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 登录
 *
 * @author zhangybt
 * @create 2017年10月12日 15:19
 **/
@RestController
@RequestMapping("/dataLogin")
public class DataLoginController {

//    @Autowired
//    private Producer producer;

//    @RequestMapping("captcha.jpg")
//    public void captcha(HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("Cache-Control", "no-store, no-cache");
//        response.setContentType("image/jpeg");
//
//        //生成文字验证码
//        String text = producer.createText();
//        //生成图片验证码
//        BufferedImage image = producer.createImage(text);
//        //保存到shiro session
//        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
//
//        ServletOutputStream out = response.getOutputStream();
//        ImageIO.write(image, "jpg", out);
//    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST) //String captcha String username, String password
    public DataResult login(@RequestBody Map<String, String> map) throws IOException {
//        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//        if (!captcha.equalsIgnoreCase(kaptcha)) {
//            return DataResult.error("验证码不正确");
//        }

        try {
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            String password= new Sha256Hash(map.get("password")).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(map.get("username"), password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return DataResult.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return DataResult.error(e.getMessage());
        } catch (LockedAccountException e) {
            return DataResult.error(e.getMessage());
        } catch (AuthenticationException e) {
            return DataResult.error("账户验证失败");
        }

        return DataResult.ok();
    }

    /**
     * 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }

}
