package com.boss.rbacpowermanage.entity.dto;

import lombok.Data;

import javax.management.relation.Role;
import java.util.List;

/**
 * @Author 黄杰峰
 * @Date 2020/7/27 0027 15:56
 * @Description
 */
@Data
public class UserDTO {

    private Integer uId;

    private String uName;

    private String uPassword;

    private String uPhone;

    private String uSex;

    private String uEmail;

    private List<RoleDTO> roleDTOList;
}
