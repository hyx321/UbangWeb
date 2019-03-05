package com.ubang.table;

/**
 * 分页获取
 * @author huang
 * start 起始位置
 * end 结束位置
 * space 间隔距离
 */
public class Pagination {
	private int start;
	private int space;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}
	@Override
	public String toString() {
		return "Pagination [start=" + start + ", space=" + space + "]";
	}
	
	
	
}
