package com.chilema.entity;
/**
 * 评论
 * @author Administrator
 *
 */
public class Comment {
    private String commentId;

    private String shopId;

    private String userId;

    private String comment;

    private Integer star;

    public String getcommentId() {
        return commentId;
    }

    public void setcommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getshopId() {
        return shopId;
    }

    public void setshopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}