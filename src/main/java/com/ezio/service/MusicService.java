package com.ezio.service;

import com.ezio.domain.Music;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Ezio on 2017/9/23.
 */
public interface MusicService {

	/**
	 *
	 * @param pageNumber
	 * @param pageSize
	 * @param searchContent
	 * @return
	 */
	List<Music> searchMusic(Integer pageNumber, Integer pageSize, String searchContent);
}
