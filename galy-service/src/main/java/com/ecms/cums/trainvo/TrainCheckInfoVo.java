package com.ecms.cums.trainvo;

import java.util.List;

public class TrainCheckInfoVo {

	private String cid;
	private List<TrainDetaillist> detail_list;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public List<TrainDetaillist> getDetail_list() {
		return detail_list;
	}
	public void setDetail_list(List<TrainDetaillist> detail_list) {
		this.detail_list = detail_list;
	}


}
