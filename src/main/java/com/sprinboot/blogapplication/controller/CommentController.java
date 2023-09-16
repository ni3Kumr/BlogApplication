package com.sprinboot.blogapplication.controller;

import com.sprinboot.blogapplication.payload.CommentDto;
import com.sprinboot.blogapplication.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment (@PathVariable( value="postId") long id ,@Valid  @RequestBody CommentDto commentDto){
        CommentDto commentDto1 =  commentService.createComment(id,commentDto);
        return  new ResponseEntity<>(commentDto1, HttpStatus.CREATED);
    }
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getAllCommentById(@PathVariable (value="postId") long postId){
        return ResponseEntity.ok(commentService.getCommentById(postId));
    }
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentsById(@PathVariable("postId") long postId,@PathVariable("id") long id){
        return ResponseEntity.ok(commentService.getCommentsById(postId,id));
    }
    // update comment api
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@Valid @RequestBody CommentDto commentDto,@PathVariable("postId") long postId,@PathVariable("id") long id ){
        CommentDto commentDto1 = commentService.updateComment(commentDto,postId,id);
        return ResponseEntity.ok(commentDto1);
    }
     @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteCommentById(@PathVariable("postId")long postId,@PathVariable("id") long id){
        commentService.deleteCommentById(postId,id);
        return ResponseEntity.ok("Comment is Successfully Deleted");
    }


}
