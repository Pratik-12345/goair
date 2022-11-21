package com.goair.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.goair.dto.TripDto;
import com.goair.repo.TripRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TripService {

	private final TripRepository repository;
	
	public List<TripDto> getAvailableTrips(Date prefferedDate) {
		return repository.findByPlannedDateGreaterThan(prefferedDate).stream().map(entity -> {
			TripDto dto = TripDto.of().tripNo(entity.getTripNo()).tripName(entity.getTripName())
					.source(entity.getSource()).destination(entity.getDestination())
					.plannedDate(entity.getPlannedDate()).estimatedCost(entity.getEstimatedCost()).build();
			return dto;
		}).toList();
	}

}
