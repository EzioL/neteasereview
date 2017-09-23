package com.ezio.repository;

import com.ezio.domain.Music;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Ezio on 2017/9/23.
 */
public interface  MusicRepository extends ElasticsearchRepository<Music,Long> {
	@Override
	Page<Music> findAll(Pageable pageable);
}
