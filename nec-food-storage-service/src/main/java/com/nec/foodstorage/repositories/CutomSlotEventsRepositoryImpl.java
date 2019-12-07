package com.nec.foodstorage.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nec.foodstorage.models.SlotEnvEvent;

@Repository
public class CutomSlotEventsRepositoryImpl implements CutomSlotEventsRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public SlotEnvEvent getLatestSlotEnvEvent(String slotId) {
		Query query = new Query();
		query.limit(10);
		query.with(new Sort(Sort.Direction.DESC, "creationTimestamp"));
		return mongoTemplate.findOne(query, SlotEnvEvent.class);
	}

	@Override
	public List<SlotEnvEvent> getAllSlotEnvEventByDateInterval(String slotId, LocalDateTime startDate,
			LocalDateTime endDate) {
		Query query = new Query(Criteria.where("slotId").is(slotId).andOperator(
				Criteria.where("creationTimestamp").lt(endDate), Criteria.where("creationTimestamp").gte(startDate)));
		return mongoTemplate.find(query, SlotEnvEvent.class);
	}

}
