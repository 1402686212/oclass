package com.student.oclass.model;

/**
 * 判断题的数据结构,用于绑定列表
 * @author huangyebiaoke
 * @email huangyebiaoke@outlook.com
 */
public class JudgeItem {
    private String title;
    private Boolean isTrue;

    public JudgeItem(String title, Boolean isTrue) {
        this.title = title;
        this.isTrue = isTrue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getTrue() {
        return isTrue;
    }

    public void setTrue(Boolean aTrue) {
        isTrue = aTrue;
    }
}
