package com.nec.foodstorage.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nec.foodstorage.serialize.LocalDateTimeDeserializer;
import com.nec.foodstorage.serialize.LocalDateTimeSerializer;

import lombok.Data;

@Data
public class SlotAnalysisEventResult {
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	protected LocalDateTime creationTimestamp;
	double red;
	double green;
	double blue;

	public SlotAnalysisEventResult(LocalDateTime creationTimestamp, double red, double green, double blue) {
		super();
		this.creationTimestamp = creationTimestamp;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public SlotAnalysisEventResult() {
		super();
		// TODO Auto-generated constructor stub
	}

}
