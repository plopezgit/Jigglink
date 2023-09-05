package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BADGE")
public class Badge {
	
	@Id
	@Column(name="BADGENAME")
	private String badgeName;
	@Column(name="COACHMESSAGE")
	private String coachMessage;
	@Column(name="ICON")
	private String icon;
	
	public Badge() {
	}

	public Badge(String badgeName, String coachMessage, String icon) {
		this.badgeName = badgeName;
		this.coachMessage = coachMessage;
		this.icon = icon;
	}

	public String getBadgeName() {
		return badgeName;
	}

	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}

	public String getCoachMessage() {
		return coachMessage;
	}

	public void setCoachMessage(String coachMessage) {
		this.coachMessage = coachMessage;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Badge [badgeName=" + badgeName + ", coachMessage=" + coachMessage + ", icon=" + icon + "]";
	}

}
