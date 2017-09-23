package com.ezio.service.impl;

import com.ezio.domain.Comment;
import com.ezio.domain.Music;
import com.ezio.service.CommentService;
import com.ezio.service.MusicService;

import java.util.List;

/**
 * Created by Ezio on 2017/9/23.
 */
public class CommentESServiceImpl implements CommentService {

	@Override
	public List<Comment> searchComment(Integer pageNumber, Integer pageSize, String searchContent) {
		return null;
	}
}
