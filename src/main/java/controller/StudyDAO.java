package controller;

import java.util.*;
import model.*;

public interface StudyDAO {
	
	public List<Itinerary> getItineraries();
	public List<Concept> getConcepts();
	public void saveConcept(Concept concept);
	public Concept getConcept(int id);
	public void updateConcept(Concept concept);
	public void deleteConcept(int id);
	public List<Idea> getIdeas();
	public Idea getIdea(int id);
	public void saveIdea(Idea idea);
	public void incrementCheckInConceptCounter(int id);
	public void incrementItineraryPoints(int id);
	public Itinerary getItinerary(int id);
	public void updateItinerary(Itinerary itinerary);
	public List<Badge> getBadges();
	public Badge getBadge(int id);
	public void putBadge(Badge badge);
	public void updateIdea(Idea idea);
	public void deleteIdea(int id);

}
