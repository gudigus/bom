package com.spring.bom.model.yeah;

public class UserBookmarkBoard {
	// 북마크
	int ucode; // 회원코드
	int bcode; // 글코드
	String ltype;
	String bbtype;
	String ldate;
	String bdate;

	// user_info
	String uimage; // 프로필
	String unickname; // 닉네임
	String uatid; // 아이디

	// Board
	String bregdate; // 작성시간
	String bcontent; // 글 내용
	String battach; // 첨부파일
	int blikecount; // 좋아요 횟수
	int breplycount; // 댓글 갯수
	int bquotecount; // 스크랩 / 인용 갯수

	// battach Type 조회용
	String battachType;
	String battachSrc;

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

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getBbtype() {
		return bbtype;
	}

	public void setBbtype(String bbtype) {
		this.bbtype = bbtype;
	}

	public String getLdate() {
		return ldate;
	}

	public void setLdate(String ldate) {
		this.ldate = ldate;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
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

	public String getBattach() {
		return battach;
	}

	public void setBattach(String battach) {
		this.battach = battach;
	}

	public int getBlikecount() {
		return blikecount;
	}

	public void setBlikecount(int blikecount) {
		this.blikecount = blikecount;
	}

	public int getBreplycount() {
		return breplycount;
	}

	public void setBreplycount(int breplycount) {
		this.breplycount = breplycount;
	}

	public int getBquotecount() {
		return bquotecount;
	}

	public void setBquotecount(int bquotecount) {
		this.bquotecount = bquotecount;
	}

	public String getBattachType() {
		return battachType;
	}

	public void setBattachType(String battachType) {
		this.battachType = battachType;
	}

	public String getBattachSrc() {
		return battachSrc;
	}

	public void setBattachSrc(String battachSrc) {
		this.battachSrc = battachSrc;
	}

}