package com.nec.foodstorage.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nec.foodstorage.models.SlotEnvEvent;

public interface SlotEventsRepository extends CrudRepository<SlotEnvEvent, String> {

}
