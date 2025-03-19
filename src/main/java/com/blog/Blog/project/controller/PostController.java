package com.blog.Blog.project.controller;

import com.blog.Blog.project.dto.PostDto;
import com.blog.Blog.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/admin/posts")
    public String findAllPost(Model model) {
        List<PostDto> postDtos = postService.findAllPost();
        model.addAttribute("listOfPost", postDtos);
        return "/admin/posts";
    }

    @GetMapping("/admin/posts/newposts")
    public String postForm(Model model){
        PostDto postDto = new PostDto();
        model.addAttribute("post", postDto);
        return "admin/create-form";
    }

    @PostMapping("/admin/posts")
    public String createPost(@ModelAttribute PostDto postDto){
        postDto.setUrl(getUrl(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/admin/posts";
    }

    public static String getUrl(String postTitle){
        String title = postTitle.trim().toLowerCase();
        String url = title.replace("\\s+","-");
        url.replaceAll("[^A-Za-z0-9]","-");
        return url;
    }

}
