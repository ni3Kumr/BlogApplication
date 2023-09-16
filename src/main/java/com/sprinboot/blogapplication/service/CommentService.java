package com.sprinboot.blogapplication.service;

import com.sprinboot.blogapplication.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment (long postId, CommentDto commentDto);
    List<CommentDto> getCommentById(long postId);
    CommentDto getCommentsById(long postId,long id);
    CommentDto updateComment(CommentDto commentDto,long postId,long id );
     void deleteCommentById(long postId, long id);
}
