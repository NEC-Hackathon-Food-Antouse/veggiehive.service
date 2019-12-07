package com.nec.foodstorage.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nec.foodstorage.serialize.LocalDateTimeDeserializer;
import com.nec.foodstorage.serialize.LocalDateTimeSerializer;

@Document(collection = "slotImageEvent")
public class SlotImageEvent {
	@Id
	String id;
	protected String slotId;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	protected LocalDateTime creationTimestamp;
	private String imageUrl;

	public SlotImageEvent() {

	}

	public SlotImageEvent(String slotId, LocalDateTime creationTimestamp, String imageUrl) {
		super();
		this.slotId = slotId;
		this.creationTimestamp = creationTimestamp;
		this.imageUrl = imageUrl;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public LocalDateTime getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(LocalDateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
