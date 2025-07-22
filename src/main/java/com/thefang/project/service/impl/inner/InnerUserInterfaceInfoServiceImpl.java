package com.thefang.project.service.impl.inner;

import com.thefang.project.service.UserInterfaceInfoService;
import com.thefang.yunapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Thefang
 * @Create 2025/7/21
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public int getLeftNum(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.getLeftNum(interfaceInfoId, userId);
    }
}
