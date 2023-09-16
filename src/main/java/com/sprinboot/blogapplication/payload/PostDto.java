package com.sprinboot.blogapplication.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    // title should not be null or empty;
    //title should have at least two character
    @NotEmpty
    @Size(min=2,message="Post Title should have al least two character")
    private String title;
    // description should not be null or empty;
    //description should have at least 12 character
    @NotEmpty
    @Size(min=10,message="Post Description should have al least 12 character")
    private String description;
    // content should not be null or empty;
    @NotEmpty
    private String  content;
    private Set<CommentDto> comments;

}
