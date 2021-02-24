package com.spring.bom.model.yeah;

public class UserBookmarkBoard {
	int ucode; // 회원코드
	int bcode; // 글코드

	// user_info
	String uimage; // 프로필
	String unickname; // 닉네임
	String uatid; // 아이디

	// Board
	String bregdate; // 작성시간
	String bcontent; // 글 내용

	// Bookmark
	String lbtype; // 좋아요

	public int getUcode() {
		return ucode;
	}

	public void setUcode(int ucode) {
		this.ucode = ucode;
	}

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public String getUimage() {
		return uimage;
	}

	public void setUimage(String uimage) {
		this.uimage = uimage;
	}

	public String getUnickname() {
		return unickname;
	}

	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}

	public String getUatid() {
		return uatid;
	}

	public void setUatid(String uatid) {
		this.uatid = uatid;
	}

	public String getBregdate() {
		return bregdate;
	}

	public void setBregdate(String bregdate) {
		this.bregdate = bregdate;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getLbtype() {
		return lbtype;
	}

	public void setLbtype(String lbtype) {
		this.lbtype = lbtype;
	}

}