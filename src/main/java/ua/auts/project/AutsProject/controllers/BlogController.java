package ua.auts.project.AutsProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.auts.project.AutsProject.models.Post;
import ua.auts.project.AutsProject.repo.PostRepository;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/add")
    public String blogPostAdd(@RequestParam String title,
                              @RequestParam String announce,
                              @RequestParam String text,
                              Model model) {
        Post post = new Post(title, announce, text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/{id}")
    public String blogDetails(@PathVariable(value = "id") Long postId, Model model) {
        if (!postRepository.existsById(postId)) {
            return "redirect:/blog";
        }

        Optional<Post> post = postRepository.findById(postId);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }
}
