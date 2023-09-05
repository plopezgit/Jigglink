package model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "enabled")
	boolean enabled;
	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH, CascadeType.REMOVE })
	private List<Itinerary> itineraryList;

	public User() {

	}


	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public List<Itinerary> getItineraryList() {
		return itineraryList;
	}

	public void setItineraryList(List<Itinerary> itineraryList) {
		this.itineraryList = itineraryList;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", itineraryList="
				+ itineraryList + "]";
	}


	
	
}
