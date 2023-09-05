package controller;

import java.awt.Toolkit;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import model.*;


@Repository
public class StudyDAOClass implements StudyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Itinerary> getItineraries() {
		Session session = sessionFactory.getCurrentSession();
		Query<Itinerary> query = session.createQuery("from Itinerary", Itinerary.class);
		List <Itinerary> tableList = query.getResultList();
		
		return tableList;
	}
	
	@Override
	@Transactional
	public List<Concept> getConcepts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Concept> query = session.createQuery("from Concept", Concept.class);
		List <Concept> tableList = query.getResultList();
		
		return tableList;
	}

	@Override
	@Transactional
	public void saveConcept(Concept concept) {
		Session session = sessionFactory.getCurrentSession();
		session.save(concept);
	}

	@Override
	@Transactional
	public Concept getConcept(int id) {
		Session session = sessionFactory.getCurrentSession();
		Concept concept = session.get(Concept.class, id);
		
		return concept;
	}
	
	@Override
	@Transactional
	public Itinerary getItinerary(int id) {
		Session session = sessionFactory.getCurrentSession();
		Itinerary itinerary = session.get(Itinerary.class, id);
		
		return itinerary;
	}

	@Override
	@Transactional
	public void updateConcept(Concept concept) { 
		Session session = sessionFactory.getCurrentSession();
		session.update(concept);
		
	}
	
	@Override
	@Transactional
	public void updateItinerary(Itinerary itinerary) { 
		Session session = sessionFactory.getCurrentSession();
		session.update(itinerary);
		
	}

	@Override
	@Transactional
	public List<Idea> getIdeas() {
		Session session = sessionFactory.getCurrentSession();
		Query<Idea> query = session.createQuery("from Idea", Idea.class);
		List <Idea> tableList = query.getResultList();
		
		return tableList;
	}
	
	@Override
	@Transactional
	public void saveIdea(Idea idea) {
		Session session = sessionFactory.getCurrentSession();
		session.save(idea);
	}
	
	@Override
	@Transactional
	public void updateIdea(Idea idea) { 
		Session session = sessionFactory.getCurrentSession();
		session.update(idea);
		
	}

	@Override
	@Transactional
	public void deleteConcept(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Concept where idconcept=:ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}
	
	@Override
	@Transactional
	public void incrementCheckInConceptCounter(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Concept set checkInCounterConcept=checkInCounterConcept+1 where idconcept=:ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}
	
	@Override
	@Transactional
	public void incrementItineraryPoints(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Itinerary set itinerarypoints=itinerarypoints+1 where itineraryID=:ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public List<Badge> getBadges() {
		Session session = sessionFactory.getCurrentSession();
		Query<Badge> query = session.createQuery("from Badge", Badge.class);
		List <Badge> tableList = query.getResultList();
		
		return tableList;
	}

	@Override
	@Transactional
	public Badge getBadge(int id) {
		Session session = sessionFactory.getCurrentSession();
		Badge badge = session.get(Badge.class, id);
		
		return badge;
	}

	@Override
	@Transactional
	public void putBadge(Badge badge) {
		Session session = sessionFactory.getCurrentSession();
		session.save(badge);
	}

	@Override
	@Transactional
	public Idea getIdea(int id) {
		Session session = sessionFactory.getCurrentSession();
		Idea idea = session.get(Idea.class, id);
		
		return idea;
	}
	
	@Override
	@Transactional
	public void deleteIdea(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Idea where ideaID=:ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}
	
}
