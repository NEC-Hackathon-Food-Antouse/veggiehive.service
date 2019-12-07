package com.nec.foodstorage.models;

public class Dimension {
	private long length;
	private long width;

	public Dimension(long length, long width, long size) {
		super();
		this.length = length;
		this.width = width;
		this.size = size;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getWidth() {
		return width;
	}

	public void setWidth(long width) {
		this.width = width;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	private long size;

}
