package com.sprinboot.blogapplication.service;

import com.sprinboot.blogapplication.payload.PostDto;
import com.sprinboot.blogapplication.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost (PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir);
    List<PostDto> getAllPost();
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto , long id);

    void deletePostById(long id);
}
