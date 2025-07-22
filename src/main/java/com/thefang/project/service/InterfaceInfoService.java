package com.thefang.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thefang.yunapicommon.model.entity.InterfaceInfo;

/**
 * @author Thefang
 * @description 针对表【interface_info(接口信息)】的数据库操作Service
 * @createDate 2025-07-15 15:34:11
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 验证接口信息是否有效
     *
     * @param interfaceInfo 接口信息
     * @param b 是否为创建时校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean b);
}
