package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ITINERARY")
public class Itinerary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int itineraryID;
	@Column(name="ITINERARYNAME")
	private String itineraryname;
	@Column(name="TARGETDATE")
	private LocalDate targetDate;
	@Column(name="ITINERARYPOINTS")
	private int itinerarypoints;
	@OneToMany(mappedBy= "itinerary", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Concept> conceptList;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="username")
	private User user;
	
	
	
	public Itinerary() {
		
	}

	public Itinerary(String itineraryname, LocalDate targetDate, int itinerarypoints) {

		this.itineraryname = itineraryname;
		this.targetDate = targetDate;
		this.itinerarypoints = itinerarypoints;
	}
	
	public void addConcept (Concept concept) {
		concept.setItinerary(this);
	}

	public int getItineraryID() {
		return itineraryID;
	}

	public void setItineraryID(int itineraryID) {
		this.itineraryID = itineraryID;
	}

	public String getItineraryname() {
		return itineraryname;
	}

	public void setItineraryname(String itineraryname) {
		this.itineraryname = itineraryname;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public int getItinerarypoints() {
		return itinerarypoints;
	}

	public void setItinerarypoints(int itinerarypoints) {
		this.itinerarypoints = itinerarypoints;
	}
	
	public List<Concept> getConceptList() {
		return conceptList;
	}

	public void setConceptList(List<Concept> conceptList) {
		this.conceptList = conceptList;
	}
	
	public long calculateRemainingDaysOfItinerary () {
		return LocalDate.now().until(targetDate, ChronoUnit.DAYS);
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Itinerary [itineraryID=" + itineraryID + ", itineraryname=" + itineraryname + ", targetDate="
				+ targetDate + ", itinerarypoints=" + itinerarypoints + "]";
	}	
	
}
