package com.thefang.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thefang.project.model.entity.UserInterfaceInfo;

/**
 * @author Thefang
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
 * @createDate 2025-07-19 22:14:46
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 验证接口信息是否有效
     *
     * @param userInterfaceInfo 接口信息
     * @param b                 是否为创建时校验
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean b);


    /**
     * 调用接口计数
     *
     * @param interfaceInfoId 接口ID
     * @param userId          用户ID
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

}
