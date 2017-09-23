package com.ezio.controller;

import com.ezio.domain.Music;
import com.ezio.service.MusicService;

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
public class MusicRestController {
	@Autowired
	private MusicService musicService;


	@RequestMapping(value = "/api/music/search", method = RequestMethod.GET)
	public List<Music> searchCity(@RequestParam(value = "pageNumber",required = false) Integer pageNumber,
								  @RequestParam(value = "pageSize", required = false) Integer pageSize,
								  @RequestParam(value = "searchContent",required = false) String searchContent) {
		return musicService.searchMusic(pageNumber, pageSize,searchContent);
	}

	@RequestMapping(value = "/api/music/test", method = RequestMethod.GET)
	public String searchCity() {
		return "123";
	}
}
