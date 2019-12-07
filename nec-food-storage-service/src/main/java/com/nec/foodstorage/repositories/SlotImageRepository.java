package com.nec.foodstorage.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nec.foodstorage.models.SlotImageEvent;

public interface SlotImageRepository extends CrudRepository<SlotImageEvent, String> {

}
