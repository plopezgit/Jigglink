package model;

import javax.persistence.*;

@Entity
@Table(name="IDEA")
public class Idea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDIDEA")
	protected int ideaID;
	@Column(name="TITLEIDEA")
	protected String titleIdea;
	@Column(name="DESCRIPTIONIDEA")
	private String descriptionIdea;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="IDCONCEPT")
	private Concept concept;
	
	public Idea() {
		
	}
	
	public Idea(String titleIdea, String descriptionIdea) {
		this.titleIdea = titleIdea;
		this.descriptionIdea = descriptionIdea;
	}

	public int getIdeaID() {
		return ideaID;
	}

	public void setIdeaID(int ideaID) {
		this.ideaID = ideaID;
	}

	public String getTitleIdea() {
		return titleIdea;
	}

	public void setTitleIdea(String titleIdea) {
		this.titleIdea = titleIdea;
	}

	public String getDescriptionIdea() {
		return descriptionIdea;
	}

	public void setDescriptionIdea(String descriptionIdea) {
		this.descriptionIdea = descriptionIdea;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	@Override
	public String toString() {
		return "Idea [ideaID=" + ideaID + ", titleIdea=" + titleIdea + ", descriptionIdea=" + descriptionIdea + "]";
	}

}
