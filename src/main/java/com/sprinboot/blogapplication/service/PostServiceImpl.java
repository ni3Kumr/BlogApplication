package com.sprinboot.blogapplication.service;

import com.sprinboot.blogapplication.entity.Post;
import com.sprinboot.blogapplication.exception.ResourceNotFoundException;
//import com.sprinboot.blogapplication.mapper.PostMapper;
import com.sprinboot.blogapplication.payload.PostDto;
import com.sprinboot.blogapplication.payload.PostResponse;
import com.sprinboot.blogapplication.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository ){
        this.postRepository=postRepository;
    }
    public PostDto createPost(PostDto postDto){
        Post post = modelMapper.map(postDto,Post.class);
       Post savePost =  postRepository.save(post);
       PostDto postDto1 = modelMapper.map(savePost,PostDto.class);

        return postDto1;
    }

    public PostResponse getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir ){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
//        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<Post> posts = postRepository.findAll(pageable);
        List<Post> listOfPosts = posts.getContent();
        List<PostDto> content =listOfPosts.stream()
                .map((list)->modelMapper.map(list,PostDto.class)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);;
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPost() {

        List<Post> postList = postRepository.findAll();
       List<PostDto> postDtoList= postList.stream().map((list)->modelMapper.map(list,PostDto.class)).collect(Collectors.toList());
       return postDtoList;
    }

    public PostDto getPostById(long id){
        Post post = postRepository.findById((int) id).orElseThrow(()-> new ResourceNotFoundException("Post"," id",id));
        return modelMapper.map(post,PostDto.class);
    }
    // update post by Id;
    public PostDto updatePost(PostDto postDto , long id){
        Post post = postRepository.findById((int) id).orElseThrow(()-> new ResourceNotFoundException("Post"," id:",id));
//        PostDto postDto1 = PostMapper.mapToPostDto(post);
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savePost = postRepository.save(post);
        PostDto postDto1 = modelMapper.map(savePost,PostDto.class);
        return postDto1;
    }
    public void deletePostById(long id){
        Post post = postRepository.findById((int) id).orElseThrow(()->
                new ResourceNotFoundException("Post","id : ",id));
        postRepository.deleteById((int) id);

    }
}
