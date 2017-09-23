package com.ezio.controller;

import com.ezio.domain.Comment;
import com.ezio.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ezio on 2017/9/23.
 */
@RestController
public class CommentRestController {
	@Autowired
	private CommentService commentService;


	@RequestMapping(value = "/api/comment/search", method = RequestMethod.GET)
	public List<Comment> searchCity(@RequestParam(value = "pageNumber",required = false) Integer pageNumber,
									@RequestParam(value = "pageSize", required = false) Integer pageSize,
									@RequestParam(value = "searchContent",required = false) String searchContent) {
		return commentService.searchComment(pageNumber, pageSize,searchContent);
	}

}
