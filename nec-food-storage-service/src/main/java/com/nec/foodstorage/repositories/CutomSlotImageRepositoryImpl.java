package com.nec.foodstorage.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nec.foodstorage.models.SlotImageEvent;

@Repository
public class CutomSlotImageRepositoryImpl implements CutomSlotImageRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public SlotImageEvent findBySlotId(String slotId) {
		Query query = new Query(Criteria.where("slotId").is(slotId));
		query.limit(10);
		query.with(new Sort(Sort.Direction.DESC, "creationTimestamp"));
		return mongoTemplate.findOne(query, SlotImageEvent.class);
	}

}
