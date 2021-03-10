package com.spring.bom.model.hoon;

public class Junghun {
	// search
	private String search;
	private int uCode;
	private int sage;
	private String stime;
	private String stype;
	private int srecord;
	private int scount;

	// board
	private String bcontent;
	private int blikecount;
	private String btmpsavtime;
	private String breplycount;
	private String bquotecount;

	// user_info
	private String uNickName;
	private String uatId;
	private String uintro;
	
	//block
	private int bopcode;
	
	// login된 Ucode
	static private int loginUcode; // 로그인 확인용

	
	public int getBopcode() {
		return bopcode;
	}

	public void setBopcode(int bopcode) {
		this.bopcode = bopcode;
	}

	public String getBreplycount() {
		return breplycount;
	}

	public void setBreplycount(String breplycount) {
		this.breplycount = breplycount;
	}

	public String getBquotecount() {
		return bquotecount;
	}

	public void setBquotecount(String bquotecount) {
		this.bquotecount = bquotecount;
	}

	public int getLoginUcode() {
		return loginUcode;
	}

	public void setLoginUcode(int loginUcode) {
		this.loginUcode = loginUcode;
	}

	public int getScount() {
		return scount;
	}

	public void setScount(int scount) {
		this.scount = scount;
	}

	public String getUintro() {
		return uintro;
	}

	public void setUintro(String uintro) {
		this.uintro = uintro;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getuCode() {
		return uCode;
	}

	public void setuCode(int ucode) {
		this.uCode = ucode;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public int getSrecord() {
		return srecord;
	}

	public void setSrecord(int srecord) {
		this.srecord = srecord;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

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

}
