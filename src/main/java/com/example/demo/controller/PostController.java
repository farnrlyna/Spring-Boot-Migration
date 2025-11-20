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

    // HOME PAGE (list all posts)
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", repo.findAll());
        return "home";
    }

    // SHOW CREATE PAGE
    @GetMapping("/create")
    public String create(Post post) {
        return "create";
    }

    // SAVE NEW POST
    @PostMapping("/save")
    public String save(Post post) {
        repo.save(post);
        return "redirect:/";
    }

    // SHOW EDIT PAGE
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Post post = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + id));
        model.addAttribute("post", post);
        return "edit";
    }

    // UPDATE POST
    @PostMapping("/update")
    public String update(Post post) {
        repo.save(post);
        return "redirect:/";
    }

    // DELETE POST
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
