package com.blog.Blog.project.service;

import com.blog.Blog.project.dto.PostDto;
import com.blog.Blog.project.entity.Post;
import com.blog.Blog.project.mapper.PostMapper;
import com.blog.Blog.project.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDto> findAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDto postDto) {
        Post posts = PostMapper.mapToPost(postDto);
        postRepository.save(posts);
    }

//    @Override
//    public PostDto createPost(PostDto postDto) {
//        return postRepository.save(postDto);
//    }
}
