package com.sprinboot.blogapplication.controller;

import com.sprinboot.blogapplication.payload.PostDto;
import com.sprinboot.blogapplication.payload.PostResponse;
import com.sprinboot.blogapplication.service.PostService;
import com.sprinboot.blogapplication.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    private PostService postService;
    //Creating post
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        PostDto savePostDto = postService.createPost(postDto);
        return new ResponseEntity<>(savePostDto, HttpStatus.CREATED);
    }
    // getting all post
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue= AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value ="pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue=AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue =AppConstants.DEFAULT_SORT_DIRECTION,required = false )String sortDir
    ){
        return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);

    }
    //testing
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getllistOfPost(){
        List<PostDto> list= postService.getAllPost();
        return ResponseEntity.ok(list);

    }
    //get post by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
        return ResponseEntity.ok(postService.getPostById(id));

    }
    // update post by id
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@Valid @RequestBody PostDto postDto ,@PathVariable("id") long id){
        return ResponseEntity.ok(postService.updatePost(postDto,id));

    }
    // delete Mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById( @PathVariable("id") long id){
        postService.deletePostById(id);
//        System.out.println("Post is successfully Deleted!");
        return ResponseEntity.ok("Post is successfully Deleted!");
    }
}
