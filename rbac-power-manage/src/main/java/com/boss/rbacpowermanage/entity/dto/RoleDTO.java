package com.boss.rbacpowermanage.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:57
 * @Description
 */
@Data
public class RoleDTO {

    private Integer rId;

    private String rName;

    private String rDesc;

    private List<MenuDTO> menuDTOList;
}
