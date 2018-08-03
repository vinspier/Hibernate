package com.fxb.forum;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class MessageInformation {
    private int id;
    private String comment;
    private String topicName;
    private String categoryName;

    public MessageInformation(int id,String comment,String topicName,String categoryName){
        super();
        this.id = id;
        this.comment = comment;
        this.topicName = topicName;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
