package com.nec.foodstorage.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nec.foodstorage.models.Slot;

public interface SlotBookingRepository extends CrudRepository<Slot, String> {

	@Override
	void delete(Slot deleted);
}
