package com.sprinboot.blogapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "Posts",
          uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "title"
                })
          })
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String  description;
    @Column(nullable = false)
    private String content;
    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;
//
//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }

//    public Post(Long id, String title, String description, String content) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.content = content;
//    }
}
