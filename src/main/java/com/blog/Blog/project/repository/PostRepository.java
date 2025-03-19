package com.blog.Blog.project.repository;

import com.blog.Blog.project.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
//     List<Post> findAllPost();
     Optional<Post> findByUrl(String url);
}

