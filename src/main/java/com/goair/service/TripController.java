package com.goair.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goair.dto.TripDto;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/trip")
@AllArgsConstructor
public class TripController {

	private final TripService service;

	@GetMapping("/available")
	public String showAvailableTrips(Model model) {
		List<TripDto> tripDtos = service.getAvailableTrips(new Date());
		model.addAttribute("trips", tripDtos);
		return "available-trips";
	}	
	@GetMapping("/message")	
	public String showMessages() {
		return "hello-user";
	
	}
}
