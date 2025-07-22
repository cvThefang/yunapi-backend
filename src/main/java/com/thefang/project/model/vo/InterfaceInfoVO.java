package com.thefang.project.model.vo;

import com.thefang.yunapicommon.model.entity.InterfaceInfo;
import lombok.Data;

/**
 * @Description 接口信息封装视图
 * @Author Thefang
 * @Create 2025/7/22
 */
@Data
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 调用次数
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;
}
