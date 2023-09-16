package com.sprinboot.blogapplication.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long id;
    // name should not be null or empty;
    //name should have at least two character
    @NotEmpty(message="Name should not be null and empty")
    private String name;
    // email should not be null or empty;
    //email should have at least two character
    @NotEmpty(message="must be valid EMAIL ")
    private String email;
    // BODY should not be null or empty;
    //BODY should have at least 10 character
    @NotEmpty
    @Size(min=10,message="comment Body have at least 10 character ")
    private String body;


}
