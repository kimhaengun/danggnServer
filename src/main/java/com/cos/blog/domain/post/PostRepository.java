package com.cos.blog.domain.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.domain.location.Location;

public interface PostRepository extends JpaRepository<Post, Integer> {

	
	@Query(value = "SELECT * FROM post where gu=?1 order by createDate desc",nativeQuery = true)
	List<Post> m구별게시물검색(String gu);
	
//	@Modifying
//	@Query(value = "update post set count = count+1 where id = ?1",nativeQuery = true)
//	Post m조회수증가(int id);
}

