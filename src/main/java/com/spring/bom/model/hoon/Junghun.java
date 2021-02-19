package com.spring.bom.model.hoon;

public class Junghun {
	private String search;
	private String sTime;
	private int sAge;

	// board
	private String bcontent;
	private int blikecount;
	private String btmpsavtime;

	
	// user_info
	private String uNickName;
	private String uatId;

	
	public int getBlikecount() {
		return blikecount;
	}

	public void setBlikecount(int blikecount) {
		this.blikecount = blikecount;
	}

	public String getBtmpsavtime() {
		return btmpsavtime;
	}

	public void setBtmpsavtime(String btmpsavtime) {
		this.btmpsavtime = btmpsavtime;
	}
	
	public int getBlikeCount() {
		return blikecount;
	}

	public void setBlikeCount(int blikeCount) {
		this.blikecount = blikeCount;
	}

	public String getuNickName() {
		return uNickName;
	}

	public void setuNickName(String uNickName) {
		this.uNickName = uNickName;
	}

	public String getUatId() {
		return uatId;
	}

	public void setUatId(String uatId) {
		this.uatId = uatId;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public int getsAge() {
		return sAge;
	}

	public void setsAge(int sAge) {
		this.sAge = sAge;
	}

}
