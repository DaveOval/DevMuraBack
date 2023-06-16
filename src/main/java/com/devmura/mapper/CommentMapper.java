package com.devmura.mapper;

import com.devmura.dto.CommentDto;
import com.devmura.entity.Comment;

public abstract class CommentMapper {

    public static CommentDto mapToCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setName(comment.getUser().getName());
        commentDto.setLastName(comment.getUser().getLastName());
        commentDto.setUsername(comment.getUser().getUsername());
        commentDto.setImg(comment.getUser().getProfile().getImg());
        return commentDto;
    }
}
