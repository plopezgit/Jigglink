package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CONCEPT")
public class Concept {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDCONCEPT")
	private int idconcept;
	@Column(name="TITLECONCEPT")
	private String titleConcept;
	@Column(name="EFFORTESTIMATIONCONCEPT")
	private String effortEstimationConcept;
	@Column(name="NOTESCONCEPT")
	private String notesconcept;
	@Column(name="WHATCONCEPT")
	private String whatConcept;
	@Column(name="HOWCONCEPT")
	private String howConcept;
	@Column(name="WHYCONCEPT")
	private String whyConcept;
	@Column(name="CHECKINCOUNTERCONCEPT")
	private int checkInCounterConcept;
	@OneToMany(mappedBy= "concept", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<Idea> ideaList;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="ITINERARYID")
	private Itinerary itinerary;
	


	
	public Concept() {
		
	}
	
	public Concept(String titleConcept, String effortEstimationConcept) {
		this.titleConcept = titleConcept;
		this.effortEstimationConcept = effortEstimationConcept;
		this.notesconcept = "";
	}
	
	public void addIdea (Idea idea) {
		idea.setConcept(this);
	}
	
	public int getIdconcept() {
		return idconcept;
	}

	public void setIdconcept(int idconcept) {
		this.idconcept = idconcept;
	}

	public String getTitleConcept() {
		return titleConcept;
	}

	public void setTitleConcept(String titleConcept) {
		this.titleConcept = titleConcept;
	}

	public String getEffortEstimationConcept() {
		return effortEstimationConcept;
	}

	public void setEffortEstimationConcept(String effortEstimationConcept) {
		this.effortEstimationConcept = effortEstimationConcept;
	}

	public String getNotesconcept() {
		return notesconcept;
	}

	public void setNotesconcept(String notesconcept) {
		this.notesconcept = notesconcept;
	}
	
	public void addNotesconcept(String notesconcept) {
		this.notesconcept += notesconcept;
	}

	public String getWhatConcept() {
		return whatConcept;
	}

	public void setWhatConcept(String whatConcept) {
		this.whatConcept = whatConcept;
	}

	public String getHowConcept() {
		return howConcept;
	}

	public void setHowConcept(String howConcept) {
		this.howConcept = howConcept;
	}

	public String getWhyConcept() {
		return whyConcept;
	}

	public void setWhyConcept(String whyConcept) {
		this.whyConcept = whyConcept;
	}

	public int getCheckInCounterConcept() {
		return checkInCounterConcept;
	}

	public void setCheckInCounterConcept(int checkInCounterConcept) {
		this.checkInCounterConcept = checkInCounterConcept;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	@Override
	public String toString() {
		return "Concept [idconcept=" + idconcept + ", titleConcept=" + titleConcept + ", effortEstimationConcept="
				+ effortEstimationConcept + ", notesconcept=" + notesconcept + ", whatConcept=" + whatConcept
				+ ", howConcept=" + howConcept + ", whyConcept=" + whyConcept + ", checkInCounterConcept="
				+ checkInCounterConcept + ", itinerary=" + itinerary + "]";
	}
	
}
