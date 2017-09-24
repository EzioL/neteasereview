package com.ezio.service.impl;

import com.ezio.domain.Music;
import com.ezio.repository.MusicRepository;
import com.ezio.service.MusicService;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ezio on 2017/9/23.
 */
@Service
public class MusicESServiceImpl implements MusicService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MusicESServiceImpl.class);
	/* 分页参数 */
	final static Integer PAGE_SIZE = 12;          // 每页数量
	final static Integer DEFAULT_PAGE_NUMBER = 0; // 默认当前页码
	/* 搜索模式 */
	final static String SCORE_MODE_SUM = "sum"; // 权重分求和模式
	final static Float  MIN_SCORE = 10.0F;      // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
	@Autowired
	MusicRepository musicRepository;


	@Override
	public Map<String, Object> searchMusic(Integer pageNumber, Integer pageSize, String searchContent) {


		// 校验分页参数
		if (pageSize == null || pageSize <= 0) {
			pageSize = PAGE_SIZE;
		}
		if (pageNumber == null || pageNumber < DEFAULT_PAGE_NUMBER) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}
		LOGGER.info("\n searchCity: searchContent [" + searchContent + "] \n ");
		Page<Music> musicPage;
		if ( !StringUtils.isEmpty(searchContent)){
			// 构建搜索查询
			SearchQuery searchQuery = getMusicSearchQuery(pageNumber,pageSize,searchContent);
			LOGGER.info("\n searchCity: searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());
			musicPage = musicRepository.search(searchQuery);

		}else {
			Pageable pageable = new PageRequest(pageNumber, pageSize);
			musicPage = musicRepository.findAll(pageable);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("content",musicPage.getContent());
		map.put("totalPages",musicPage.getTotalPages());
		map.put("totalElements",musicPage.getTotalElements());
		map.put("currentPage",pageNumber);
		return map;
	}

	/**
	 *
	 * @param pageNumber
	 * @param pageSize
	 * @param searchContent
	 * @return
	 */
	private SearchQuery getMusicSearchQuery(Integer pageNumber, Integer pageSize, String searchContent) {
		FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
				.add(QueryBuilders.matchPhraseQuery("title", searchContent),
						ScoreFunctionBuilders.weightFactorFunction(1000))
				.add(QueryBuilders.matchPhraseQuery("author", searchContent),
						ScoreFunctionBuilders.weightFactorFunction(500))
				.scoreMode(SCORE_MODE_SUM).setMinScore(MIN_SCORE);

		// 分页参数
		Pageable pageable = new PageRequest(pageNumber, pageSize);
		return new NativeSearchQueryBuilder()
				.withPageable(pageable)
				.withQuery(functionScoreQueryBuilder).build();

	}
}
