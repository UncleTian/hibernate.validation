package com.lin.luo.tian.types;

public enum BrandTypes {
	DOMESTIC("domestic"), ABROAD("abroad");
	private String value;

	BrandTypes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
