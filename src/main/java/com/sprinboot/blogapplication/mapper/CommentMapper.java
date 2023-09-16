//package com.sprinboot.blogapplication.mapper;
//
//import com.sprinboot.blogapplication.entity.Comment;
//import com.sprinboot.blogapplication.payload.CommentDto;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CommentMapper {
//    @Autowired
//    private static ModelMapper modelMapper;
////    public CommentMapper(ModelMapper modelMapper){
////        this.modelMapper = modelMapper;
////    }
//    public static CommentDto mapToDto(Comment comment) {
//        CommentDto commentDto =modelMapper.map(comment,CommentDto.class);
////        CommentDto commentDto = new CommentDto();
////        commentDto.setId(comment.getId());
////        commentDto.setName(comment.getName());
////        commentDto.setEmail(comment.getEmail());
////        commentDto.setBody(comment.getBody());
//        return commentDto;
//
//    }
//
//    public static Comment mapToEntity(CommentDto commentDto) {
//        Comment comment = modelMapper.map(commentDto,Comment.class);
//
////        Comment comment = new Comment();
////        comment.setId(commentDto.getId());
////        comment.setName(commentDto.getName());
////        comment.setEmail(commentDto.getEmail());
////        comment.setBody(commentDto.getBody());
//        return comment;
//    }
//}
//
//
