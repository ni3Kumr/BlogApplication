//package com.sprinboot.blogapplication.mapper;
//
//import com.sprinboot.blogapplication.entity.Post;
//import com.sprinboot.blogapplication.payload.PostDto;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PostMapper {
//    @Autowired
//    private static ModelMapper mapper;
//     // map to Postdto
//    public static PostDto mapToPostDto(Post post){
//
//          PostDto postDto =  mapper.map(post, PostDto.class);
//
//
////        PostDto postDto = new PostDto();
////                postDto.setId(post.getId());
////                postDto.setTitle(post.getTitle());
////                postDto.setDescription(post.getDescription());
////                postDto.setContent(post.getContent());
//////              postDto.setComments(post.getComments());
//        return postDto;
//
//    }
//    // map to post
//    public static Post mapToPost(PostDto postDto){
//        Post post = mapper.map(postDto,Post.class);
////        Post post = new Post();
////        post.setId(postDto.getId());
////        post.setTitle(postDto.getTitle());
////        post.setDescription(postDto.getDescription());
////        post.setContent(postDto.getContent());
//////        post.setComments(postDto.getComments());
//
//        return post;
//
//
//    }
//}
