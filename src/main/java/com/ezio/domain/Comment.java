package com.ezio.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Created by Ezio on 2017/9/23.
 */
@Document(indexName = "comment", type = "form_comment")
public class Comment implements Serializable {
	private Integer	id;

	public String getSong_id() {
		return song_id;
	}

	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}

	public Integer getLiked_count() {
		return liked_count;
	}

	public void setLiked_count(Integer liked_count) {
		this.liked_count = liked_count;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	private String	song_id;
	private String	nickname;
	private Integer	liked_count;
	private String	content;
	private String time;
	private int comment_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}
