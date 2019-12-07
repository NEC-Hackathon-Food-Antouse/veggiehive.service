package com.nec.foodstorage.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nec.foodstorage.models.SlotAnalysisEvent;

@Repository
public class CustomSlotAnalysisRepositoryImpl implements CustomSlotAnalysisRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<SlotAnalysisEvent> getAllSlotAnalysisEventByDateInterval(String slotId) {
		Query query = new Query(Criteria.where("slotId").is(slotId));
		query.limit(10);
		query.with(new Sort(Sort.Direction.DESC, "creationTimestamp"));
		return mongoTemplate.find(query, SlotAnalysisEvent.class);
	}

}
