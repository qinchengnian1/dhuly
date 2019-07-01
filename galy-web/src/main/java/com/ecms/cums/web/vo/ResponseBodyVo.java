package com.ecms.cums.web.vo;

import java.util.List;

public class ResponseBodyVo {

	private List<ResultInfosLsVo> ResultInfoLs;

	private PageVo PageVo;

	public List<ResultInfosLsVo> getResultInfoLs() {
		return ResultInfoLs;
	}

	public void setResultInfoLs(List<ResultInfosLsVo> resultInfoLs) {
		ResultInfoLs = resultInfoLs;
	}

	public PageVo getPageVo() {
		return PageVo;
	}

	public void setPageVo(PageVo pageVo) {
		PageVo = pageVo;
	}


}
