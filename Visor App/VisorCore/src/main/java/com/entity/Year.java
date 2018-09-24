package com.entity;

public enum Year {
	YEAR1("2015-0"),
	YEAR2("2015-1"),
	YEAR3("2015-2"),
	
	YEAR4("2016-0"),
	YEAR5("2016-1"),
	YEAR6("2016-2"),
	
	YEAR7("2017-0"),
	YEAR8("2017-1"),
	YEAR9("2017-2"),
	
	YEAR10("2018-0"),
	YEAR11("2018-1"),
	YEAR12("2018-2");
	
	private String name;

	
	private Year(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
