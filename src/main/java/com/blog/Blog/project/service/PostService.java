package com.blog.Blog.project.service;

import com.blog.Blog.project.dto.PostDto;
import com.blog.Blog.project.entity.Post;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPost();

    void createPost(PostDto postDto);

}
