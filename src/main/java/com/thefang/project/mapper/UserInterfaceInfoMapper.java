package com.thefang.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thefang.yunapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * @author Thefang
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
 * @createDate 2025-07-19 22:14:46
 * @Entity com.thefang.project.model.entity.UserInterfaceInfo
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    /**
     * 获取调用次数最多的接口信息
     *
     * @param limit topN
     * @return 接口信息列表
     */
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




