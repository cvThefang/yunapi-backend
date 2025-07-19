package com.thefang.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * ID请求
 *
 * @author thefang
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}