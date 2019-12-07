package com.nec.foodstorage.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nec.foodstorage.models.SlotAnalysisEvent;
import com.nec.foodstorage.models.SlotAnalysisEventResult;
import com.nec.foodstorage.models.SlotEnvEvent;
import com.nec.foodstorage.models.SlotImageEvent;
import com.nec.foodstorage.repositories.CustomSlotAnalysisRepositoryImpl;
import com.nec.foodstorage.repositories.CutomSlotEventsRepository;
import com.nec.foodstorage.repositories.CutomSlotImageRepositoryImpl;
import com.nec.foodstorage.repositories.SlotImageRepository;

@RestController
public class SlotReportController {

	@Autowired
	CutomSlotEventsRepository slotEventRepository;
	@Autowired
	CutomSlotImageRepositoryImpl customSlotImageRepository;

	@Autowired
	SlotImageRepository slotImageRepository;

	@Autowired
	CustomSlotAnalysisRepositoryImpl customSlotAnalysisRepositoryImpl;

	@RequestMapping(method = RequestMethod.GET, value = "/environment/report/slots/{id}")
	public SlotEnvEvent getLatestSlotEnvEvent(@PathVariable String id) {
		return slotEventRepository.getLatestSlotEnvEvent(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/environment/report/slots/{id}/from/{fromTime}/to/{toTime}")
	public List<SlotEnvEvent> getAllSlotEnvEventByDateInterval(@PathVariable String id,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromTime,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toTime) {
		return slotEventRepository.getAllSlotEnvEventByDateInterval(id, fromTime, toTime);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/image/report/slots/{id}")
	public SlotImageEvent getLatestSlotImageEvent(@PathVariable String id) {
		return customSlotImageRepository.findBySlotId(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/image/analysis/report/slots/{id}")
	public List<SlotAnalysisEventResult> getLatestSlotAnalysisEvent(@PathVariable String id) {
		List<SlotAnalysisEventResult> slotAnalysisEventResult = new ArrayList<SlotAnalysisEventResult>();
		List<SlotAnalysisEvent> slotAnalysisEvent = customSlotAnalysisRepositoryImpl
				.getAllSlotAnalysisEventByDateInterval(id);
		slotAnalysisEvent.stream().forEach(p -> {
			slotAnalysisEventResult.add(new SlotAnalysisEventResult(p.getCreationTimestamp(),
					p.getAnalysisData().getResponses().get(0).getImagePropertiesAnnotation().getDominantColors()
							.getColors().get(0).getColor().getRed(),
					p.getAnalysisData().getResponses().get(0).getImagePropertiesAnnotation().getDominantColors()
							.getColors().get(0).getColor().getBlue(),
					p.getAnalysisData().getResponses().get(0).getImagePropertiesAnnotation().getDominantColors()
							.getColors().get(0).getColor().getGreen()));
		});
		return slotAnalysisEventResult;

	}

}
