package com.thefang.yunapicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thefang.yunapicommon.model.entity.InterfaceInfo;

/**
 * @author Thefang
 * @description 针对表【interface_info(接口信息)】的数据库操作Service
 * @createDate 2025-07-15 15:34:11
 */
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数）
     */
    InterfaceInfo getInterfaceInfo(String url, String method);
}
