package com.thefang.yunapicommon.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.thefang.yunapicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author thefang
 */
public interface InnerUserService {

    /**
     * 数据库中查是否已分配给用户秘钥（accessKey）
     *
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
