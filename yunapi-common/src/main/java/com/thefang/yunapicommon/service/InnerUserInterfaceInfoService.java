package com.thefang.yunapicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thefang.yunapicommon.model.entity.UserInterfaceInfo;

/**
 * @author Thefang
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
 * @createDate 2025-07-19 22:14:46
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口计数
     *
     * @param interfaceInfoId 接口ID
     * @param userId          用户ID
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 查询剩余调用次数
     *
     * @param interfaceInfoId 接口ID
     * @param userId          用户ID
     * @return
     */
    int getLeftNum(long interfaceInfoId, long userId);
}
