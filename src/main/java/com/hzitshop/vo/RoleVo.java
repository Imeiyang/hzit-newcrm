package com.hzitshop.vo;

/**
 * Created by xianyaoji on 2017/7/8.
 */
public class RoleVo {
    /**
     * id自动增长
     */
    private Integer id;
    private String role;
    /**
     * 角色描述
     */
    private String description;
    
    /**
     * 0:不可用,1:可用:默认不可用
     */
    private Integer available;

    public RoleVo() {
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
