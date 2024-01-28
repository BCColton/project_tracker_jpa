package project_tracker_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project_tracker_jpa.entity.House;
import project_tracker_jpa.service.HouseService;

@RestController
@RequestMapping("/house")
@Slf4j
public class HouseController {

	@Autowired
	private HouseService houseService;
	
	@GetMapping
	public List<House> fetchAllHouse() {
		log.info("Retrieving all houses");
		List<House> houses = houseService.fetchAllHouses();
		log.info("Houses retrieved");
		return houses;
		
	}
	
	@GetMapping("/{houseId}")
	public House fetchHouseById(@PathVariable Long houseId) {
		log.info("Retrieving house with ID={}", houseId);
		return houseService.fetchHouseById(houseId);
	}

}
