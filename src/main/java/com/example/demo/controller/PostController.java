package com.example.demo.controller;

import com.example.demo.repository.PostRepository;
import com.example.demo.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository repo;

    public PostController(PostRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", repo.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String create(Post post) {
        return "create";
    }

    @PostMapping("/save")
    public String save(Post post) {
        repo.save(post);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
public String delete(@PathVariable Long id) {
    repo.deleteById(id);
    return "redirect:/";
}

}
