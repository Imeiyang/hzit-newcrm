package com.hzitshop.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianyaoji on 2017/7/9.
 */
public class VueTree {
    private String title;//标题
    private boolean expand =false;//是否展开子节点
    private  boolean disabled = false;//禁掉响应
    private boolean disableCheckbox;//禁掉checkbox
    private boolean selected;//是否选中子节点
    private boolean checked=true;//是否勾选
    private List<VueTree> children = new ArrayList<>();//子节点属性数组

    public VueTree() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDisableCheckbox() {
        return disableCheckbox;
    }

    public void setDisableCheckbox(boolean disableCheckbox) {
        this.disableCheckbox = disableCheckbox;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<VueTree> getChildren() {
        return children;
    }

    public void setChildren(List<VueTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "VueTree{" +
                "title='" + title + '\'' +
                ", expand=" + expand +
                ", disabled=" + disabled +
                ", disableCheckbox=" + disableCheckbox +
                ", selected=" + selected +
                ", checked=" + checked +
                ", children=" + children +
                '}';
    }
}
