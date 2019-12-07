package com.nec.foodstorage.repositories;

import com.nec.foodstorage.models.SlotImageEvent;

public interface CutomSlotImageRepository {
	SlotImageEvent findBySlotId(String slotId);
}
