package com.codegym.reposiotry;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(nativeQuery = true, value = "select * from blog where category_id=:param")
    List<Blog> searchBlogByCategoryId(@Param("param")int keyword);
//    @Query(nativeQuery = true, value = "select * form blog where title=:paramString")
//    List<Blog> searchBlogByTitle(@Param("paramString") String title);
//    @Query(nativeQuery = true, value = "select * from blog where title like=:%param%")
//    List<Blog> searchBlogsByTitleContaining(@Param("param")String title);
List<Blog> searchBlogsByTitleContaining(String title);
}
