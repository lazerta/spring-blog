package com.shawn.springblog.repository;

import com.shawn.springblog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);

    @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);

    Page<Blog> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content, Pageable pageable);


    @Transactional
    @Modifying
    @Query("update Blog b set b.viewsCount = b.viewsCount+1 where b.id = :id")
    int updateViews(Long id);

    @Query("select function('to_char',b.updateTime,'YYYY') as year from Blog b group by function('to_char',b.updateTime,'YYYY') order by year desc ")
    List<String> findGroupYear();

    @Query("select b from Blog b where function('to_char',b.updateTime,'YYYY') = ?1")
    List<Blog> findByYear(String year);
}
