package com.sprinboot.blogapplication.service;

import com.sprinboot.blogapplication.entity.Comment;
import com.sprinboot.blogapplication.entity.Post;
import com.sprinboot.blogapplication.exception.BlogApiException;
import com.sprinboot.blogapplication.exception.ResourceNotFoundException;
import com.sprinboot.blogapplication.payload.CommentDto;
import com.sprinboot.blogapplication.repository.CommentRepository;
import com.sprinboot.blogapplication.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper mapper;
    //creating comment for Dto
    public CommentDto createComment (long postId,CommentDto commentDto){

//         Comment comment = CommentMapper.mapToEntity(commentDto);
           Comment comment = mapper.map(commentDto,Comment.class);


        // retrive post entity by id;

         Post post =  postRepository.findById((int) postId).orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));
         comment.setPost(post);
         Comment savedComment = commentRepository.save(comment);
         CommentDto savedCommentDto = mapper.map(savedComment,CommentDto.class);

        return savedCommentDto;
    }
    public List<CommentDto> getCommentById(long postId){
        List<Comment> commentList = commentRepository.findByPostId(postId);
        List<CommentDto> commentDtos = commentList.stream().map((list)->mapper.map(list,CommentDto.class)).collect(Collectors.toList());
        return commentDtos;

    }

    public CommentDto getCommentsById(long postId,long id){
        Post post =  postRepository.findById((int) postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));


        Comment comment = commentRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("comment","id",id));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogApiException(HttpStatus.BAD_REQUEST,"comment does not found");

        }
        CommentDto commentDto =mapper.map(comment,CommentDto.class);

        return commentDto;
    }
    public CommentDto updateComment(CommentDto commentDto,long postId,long commentId){

        Post post = postRepository.findById((int) postId).orElseThrow(()->new ResourceNotFoundException("post","id",postId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("post","id",commentId));
        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogApiException(HttpStatus.BAD_REQUEST,"Comment does not belong to the post");
        }

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        Comment savedComment = commentRepository.save(comment);
//        comment.setId(commentDto.getId());

        return mapper.map(savedComment,CommentDto.class);
    }
    public void deleteCommentById(long postId,long commentId){
        Post post = postRepository.findById((int) postId).orElseThrow(()->new ResourceNotFoundException("post","id",postId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("post","id",commentId));
        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogApiException(HttpStatus.BAD_REQUEST,"Comment does not belong to the post");
        }

        commentRepository.deleteById(commentId);

    }
}
