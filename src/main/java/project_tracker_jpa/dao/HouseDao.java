package project_tracker_jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project_tracker_jpa.entity.House;

/**
 * @author Brian Colton
 */

public interface HouseDao extends JpaRepository<House, Long> {
}
