package com.nec.foodstorage.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.nec.foodstorage.models.SlotEnvEvent;

public interface CutomSlotEventsRepository {
	SlotEnvEvent getLatestSlotEnvEvent(String slotId);

	List<SlotEnvEvent> getAllSlotEnvEventByDateInterval(String slotId, LocalDateTime startDt, LocalDateTime endDt);

}
