package project_tracker_jpa.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_tracker_jpa.dao.HouseDao;
import project_tracker_jpa.entity.House;

/**
 * @author Brian Colton
 */

@Service
public class HouseService {

	@Autowired
	private HouseDao houseDao;

	public List<House> fetchAllHouses() {
		return houseDao.findAll();
	}

	public House fetchHouseById(Long houseId) {
		return findHouseById(houseId);
	}

	private House findHouseById(Long houseId) {
		return houseDao.findById(houseId)
				.orElseThrow(
						() -> new NoSuchElementException(
								"House with ID=" + houseId + " was not found"));
				
	}
	
	
	
}
