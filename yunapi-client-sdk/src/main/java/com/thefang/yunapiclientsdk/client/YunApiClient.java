package com.thefang.yunapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.thefang.yunapiclientsdk.model.User;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.thefang.yunapiclientsdk.utils.SignUtils.genSign;


/**
 * @Description 调用第三方接口的客户端
 * @Author Thefang
 * @Create 2025/7/17
 */
public class YunApiClient {

    private String accessKey;

    private String secretKey;

    private static final String GATEWAY_HOST = "http://localhost:8090";

    public YunApiClient(String accessKey, String secretKey) {
        this.secretKey = secretKey;
        this.accessKey = accessKey;
    }

    public String getNameByGet(String name) {
        // 可以单独传入HTTP参数,这样参数会自动做URL编码,拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getUserNameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .charset(StandardCharsets.UTF_8)
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    /**
     * 获取请求头
     *
     * @param body
     * @return
     */
    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("accessKey", accessKey);
        // 切记：秘钥一定不能发送到客户端，否则容易泄露
        headerMap.put("secretKey", secretKey);
        headerMap.put("nonce", RandomUtil.randomNumbers(4));
        // URL 编码 body
        String encodedBody = null;
        try {
            encodedBody = URLEncoder.encode(body, String.valueOf(StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        headerMap.put("body", encodedBody);
        headerMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        headerMap.put("sign", genSign(body, secretKey));
        return headerMap;
    }
}
