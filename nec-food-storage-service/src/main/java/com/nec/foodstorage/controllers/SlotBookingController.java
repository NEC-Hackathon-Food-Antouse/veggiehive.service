package com.nec.foodstorage.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nec.foodstorage.models.Owner;
import com.nec.foodstorage.models.Slot;
import com.nec.foodstorage.repositories.SlotBookingRepository;

@RestController
public class SlotBookingController {

	@Autowired
	SlotBookingRepository slotRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/slots")
	public Iterable<Slot> slots() {
		return slotRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/slots")
	public String save(@RequestBody Slot slot) {
		slotRepository.save(slot);
		return slot.getId();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/slots/{id}")
	public Optional<Slot> show(@PathVariable String id) {
		return slotRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/slots/{id}")
	public Slot update(@PathVariable String id, @RequestBody Slot slot) {
		Optional<Slot> slotInDB = slotRepository.findById(id);
		if (slot.getDimension() != null)
			slotInDB.get().setDimension(slot.getDimension());
		if (slot.getOwner() != null)
			slotInDB.get().setOwner(slot.getOwner());
		if (slot.getLocation() != null)
			slotInDB.get().setLocation(slot.getLocation());
		if (slot.getSiteName() != null)
			slotInDB.get().setSiteName(slot.getSiteName());
		slotRepository.save(slotInDB.get());
		return slotInDB.get();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/book/slots/{id}/")
	public Slot updateOwner(@PathVariable String id, @RequestBody Owner owner) {
		Optional<Slot> slotInDB = slotRepository.findById(id);
		if (owner != null)
			slotInDB.get().setOwner(owner);
		slotRepository.save(slotInDB.get());
		return slotInDB.get();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/slots/{id}")
	public String delete(@PathVariable String id) {
		Optional<Slot> product = slotRepository.findById(id);
		slotRepository.delete(product.get());
		return "slot deleted";
	}

}
