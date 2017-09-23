package com.ezio.service;

import com.ezio.domain.Comment;
import com.ezio.domain.Music;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ezio on 2017/9/23.
 */

public interface CommentService {

	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param searchContent
	 * @return
	 */
	List<Comment> searchComment(Integer pageNumber, Integer pageSize, String searchContent);
}
