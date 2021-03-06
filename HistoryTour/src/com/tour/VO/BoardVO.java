package com.tour.VO;

import java.sql.Timestamp;

public class BoardVO {
	int num;
	String title;
	String writer;
	String content;
	String filename;	
	Timestamp wrtDate;
	int hit;
	int replyRef;	
	int replyLevel;
	int replySeq;
	
	private static BoardVO boardVO = new BoardVO();
	public static BoardVO getInstance() {
		return boardVO;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Timestamp getWrtDate() {
		return wrtDate;
	}

	public void setWrtDate(Timestamp wrtDate) {
		this.wrtDate = wrtDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getReplyRef() {
		return replyRef;
	}

	public void setReplyRef(int replyRef) {
		this.replyRef = replyRef;
	}

	public int getReplyLevel() {
		return replyLevel;
	}

	public void setReplyLevel(int replyLevel) {
		this.replyLevel = replyLevel;
	}

	public int getReplySeq() {
		return replySeq;
	}

	public void setReplySeq(int replySeq) {
		this.replySeq = replySeq;
	}


	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", filename=" + filename + ", wrtDate=" + wrtDate + ", hit=" + hit + ", replyRef=" + replyRef
				+ ", replyLevel=" + replyLevel + ", replySeq=" + replySeq + "]";
	}
	
	
	
	
	
	
}
