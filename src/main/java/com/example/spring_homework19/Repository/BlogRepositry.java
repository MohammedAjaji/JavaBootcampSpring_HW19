package com.example.spring_homework19.Repository;

import com.example.spring_homework19.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepositry extends JpaRepository<Blog, Integer> {

    Blog findBlogById(Integer id);

    List<Blog> findAllByTitle(String title);

    List<Blog> findAllByCategory(String category);

}
