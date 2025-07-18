package com.thefang.yunapiinterface.controller;

import com.thefang.yunapiclientsdk.model.User;
import com.thefang.yunapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Author Thefang
 * @Create 2025/7/16
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "Get Hello, " + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "Post Hello, " + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String body = request.getHeader("body");
        String sign = request.getHeader("sign");
        // todo 实际情况应该是去查询accessKey是否已经分配给用户  一并将secretKey查询出来下面进行校验的时候使用
        if (!"thefang".equals(accessKey)) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        // 校验时间戳，防止重放攻击
        // 时间和当前时间不能超过5分钟，防止时间回拨 1752769353737 1752769300
        if ((System.currentTimeMillis() / 1000) - Long.parseLong(timestamp) > 300000) {
            throw new RuntimeException("无权限");
        }
        // 这里的秘钥实际是要上面查询出来的secretKey
        String secretKey = "lishushu";
        // 使用 UTF-8 解码
        String decodedBody = null;
        try {
            decodedBody = URLDecoder.decode(body, String.valueOf(StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String serverSign = SignUtils.genSign(decodedBody, secretKey);
        if (!serverSign.equals(sign)) {
            throw new RuntimeException("无权限");
        }
        System.out.println(serverSign);
        System.out.println(sign);
        return "JSON Hello, " + user.getUserName();
    }
}
