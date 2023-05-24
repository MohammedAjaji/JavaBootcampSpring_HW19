package com.example.spring_homework19.Controller;

import com.example.spring_homework19.Model.Blog;
import com.example.spring_homework19.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getBlogs(){
       List<Blog> blogs = blogService.getBlogs();
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog){
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("Blog Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog, @PathVariable Integer id){
        blogService.updateBlog(id, blog);
        return ResponseEntity.status(200).body("Blog Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("Blog Deleted :(");
    }

    @GetMapping("get-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
      Blog blog = blogService.getBlogById(id);

        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        List<Blog> blogs = blogService.getBlogByTitle(title);
        return ResponseEntity.status(200).body(blogs);
    }

    @GetMapping("get-category/{category}")
    public ResponseEntity getBlogByCategory(@PathVariable String category){
        List<Blog> blogs = blogService.getBlogByCategory(category);
        return ResponseEntity.status(200).body(blogs);
    }

    @PutMapping("publish/{id}")
    public ResponseEntity publishBlog(@PathVariable Integer id){
        blogService.publishBlog(id);
        return ResponseEntity.status(200).body("Blog has been published :)");
    }

    @PutMapping("unpublish/{id}")
    public ResponseEntity unpublishBlog(@PathVariable Integer id){
        blogService.unPublishBlog(id);
        return ResponseEntity.status(200).body("Blog has been unpublished :)");
    }
}
