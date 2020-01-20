package com.shawn.springblog.service;

import com.shawn.springblog.entity.Comment;

import java.util.List;


public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
