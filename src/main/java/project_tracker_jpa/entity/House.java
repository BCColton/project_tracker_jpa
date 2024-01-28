package project_tracker_jpa.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long houseId;
	
	@Column
	private String address;
	@Column
	private Double squareFootage;
	@Column
	private Double lotSize;
	
	@OneToMany(mappedBy = "projectId", cascade = CascadeType.ALL)
	@JsonBackReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Project> projects;
	
}
