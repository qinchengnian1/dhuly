package com.ecms.cums.sysuservo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatesTree {
	@JsonProperty(value = "checked")
	private Boolean checked;

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	
	
	
}
