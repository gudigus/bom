package com.spring.bom.model.bear;

public class Chat {
	//ucdoe : 회원코드 , ccode: 쪽지방코드 , uopcode : 상대방코드 , udelstate : 삭제여부
	private int ucode,ccode,udelstate;
	// cdmessage : 대화 메세지 , 톡 시간
	private String cdmessage , cdtime,uopcode ;
	public int getUcode() {
		return ucode;
	}
	public void setUcode(int ucode) {
		this.ucode = ucode;
	}
	public int getCcode() {
		return ccode;
	}
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	public String getUopcode() {
		return uopcode;
	}
	public void setUopcode(String uopcode) {
		this.uopcode = uopcode;
	}
	public int getUdelstate() {
		return udelstate;
	}
	public void setUdelstate(int udelstate) {
		this.udelstate = udelstate;
	}
	public String getCdmessage() {
		return cdmessage;
	}
	public void setCdmessage(String cdmessage) {
		this.cdmessage = cdmessage;
	}
	public String getCdtime() {
		return cdtime;
	}
	public void setCdtime(String cdtime) {
		this.cdtime = cdtime;
	} 
	@Override
	public String toString() {
		return "[ccode =\" + ccode  + \", uopcode =\" + uopcode  + \"]";
		
	}
	

}
