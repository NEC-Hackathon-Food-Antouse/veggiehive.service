package com.nec.foodstorage.repositories;

import java.util.List;

import com.nec.foodstorage.models.SlotAnalysisEvent;

public interface CustomSlotAnalysisRepository {

	List<SlotAnalysisEvent> getAllSlotAnalysisEventByDateInterval(String slotId);
}
