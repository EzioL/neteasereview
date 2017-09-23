package com.ezio.service;

import java.util.Map;

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
	Map<String, Object> searchMusic(Integer pageNumber, Integer pageSize, String searchContent);
}
