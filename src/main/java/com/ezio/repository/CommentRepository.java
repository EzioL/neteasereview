package com.ezio.repository;

import com.ezio.domain.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Ezio on 2017/9/23.
 */
public interface CommentRepository extends ElasticsearchRepository<Comment,Long> {
	@Override
	Page<Comment> findAll(Pageable pageable);
}
