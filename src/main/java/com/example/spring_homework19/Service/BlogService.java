package com.example.spring_homework19.Service;


import com.example.spring_homework19.ApiException.ApiException;
import com.example.spring_homework19.Model.Blog;
import com.example.spring_homework19.Repository.BlogRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepositry blogRepositry;

    public List<Blog> getBlogs(){
        return blogRepositry.findAll();
    }

    public void addBlog(Blog blog){
        blogRepositry.save(blog);
    }

    public void updateBlog(Integer id, Blog blog){
        Blog oldBlog = blogRepositry.findBlogById(id);

        if (oldBlog == null){
            throw new ApiException("Cannot Find Blog with this ID");
        }

        oldBlog.setTitle(blog.getTitle());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setBody(blog.getBody());

        blogRepositry.save(oldBlog);

    }

    public void deleteBlog(Integer id){
        Blog blog = blogRepositry.findBlogById(id);
        if (blog == null){
            throw new ApiException("Cannot Find Blog with this ID");
        }
        blogRepositry.delete(blog);
    }

    public Blog getBlogById(Integer id){
        Blog blog = blogRepositry.findBlogById(id);
        if (blog == null){
            throw new ApiException("Cannot Find Blog with this ID");
        }
        return blog;
    }

    public List<Blog> getBlogByTitle(String title){
        List<Blog> blogs = blogRepositry.findAllByTitle(title);
        if (blogs.isEmpty()){
            throw new ApiException("Cannot Find Blog with this Title");
        }
        return blogs;
    }

    public List<Blog>  getBlogByCategory(String category){
        List<Blog> blogs = blogRepositry.findAllByCategory(category);
        if (blogs.isEmpty()){
            throw new ApiException("Cannot Find Blog with this Category");
        }
        return blogs;
    }

    public void publishBlog(Integer id){
        Blog blog = blogRepositry.findBlogById(id);

        if (blog == null){
            throw new ApiException("Cannot Find Blog with this ID");
        }

        if (blog.getIsPublished()){
            throw new ApiException("Blog already published");
        }
        blog.setIsPublished(true);
        blogRepositry.save(blog);
    }

    public void unPublishBlog(Integer id){
        Blog blog = blogRepositry.findBlogById(id);

        if (blog == null){
            throw new ApiException("Cannot Find Blog with this ID");
        }

        if (!blog.getIsPublished()){
            throw new ApiException("Blog already not published");
        }
        blog.setIsPublished(false);
        blogRepositry.save(blog);
    }


}
