package com.cos.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.domain.user.User;
import com.cos.blog.web.dto.post.PostSaveReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	@Transactional
	public Post 중고거래글쓰기(Post post) {
		return postRepository.save(post);
	}

	@Transactional(readOnly = true)
	public List<Post> 구별게시물검색(String gu) {
		return postRepository.m구별게시물검색(gu);
	}

//	@Transactional(readOnly = true)
//	public Post 게시물상세보기(int id){
//		
//		return postRepository.findById(id).orElseThrow(() -> {
//			return new IllegalArgumentException();
//		});
//	}
	
	@Transactional
	public Post 게시물상세보기(int id){
		Post post = postRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException();
		});
		//조회수 증가 요거만 추가
		post.setCount(post.getCount()+1);
		
		//관심클릭하면 숫자증가
		int likeCount = post.getLike().size();
		post.setFavorite(likeCount);
		
//		post.getLike().forEach((like)->{
//			if(like.getUser().getId()== userId) {
//				post.setFavoriteState(true);
//			}
//		});
		return post;
	}
//	
//	@Transactional
//	public Post 조회수증가(int id) {
//		// TODO Auto-generated method stub
//		return postRepository.m조회수증가(id);
//	}
}
