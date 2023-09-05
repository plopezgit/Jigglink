package controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.*;

@Controller
@RequestMapping("/itinerary")
public class ControllerStudy {
	
	@Autowired
	private StudyDAO studyDAO;
	
	@RequestMapping("/details")
	public String viewItinerayDetails (Model model) {
	
		List<Itinerary> tableListItinerary = studyDAO.getItineraries();
		model.addAttribute("tableListItinerary", tableListItinerary);
		long itineraryRemainingDays = studyDAO.getItinerary(1).calculateRemainingDaysOfItinerary();
		model.addAttribute("itineraryRemainingDays", itineraryRemainingDays);

		List<Concept> tableListConcept = studyDAO.getConcepts();
		model.addAttribute("tableListConcept", tableListConcept);
		
		List<Idea> tableListIdea = studyDAO.getIdeas();
		model.addAttribute("tableListIdeas", tableListIdea);
		
		List<Badge> tableListBadge = studyDAO.getBadges();
		model.addAttribute("tableListBadge", tableListBadge);
		
		return "itinerary";
	}
	
	@GetMapping("/storeConceptForm")
	public String viewStoreConceptForm (@RequestParam("iid") int iid, Model model) {
		
		List<Itinerary> tableListItinerary = studyDAO.getItineraries();
		model.addAttribute("tableListItinerary", tableListItinerary);
		
		Concept concept = new Concept();
		Itinerary itinerary = studyDAO.getItinerary(iid);
		itinerary.addConcept(concept);
		model.addAttribute("concept", concept);
		
		return "storeConceptForm";
	}
	
	@PostMapping("saveConcept")
	public String storeConcept (@ModelAttribute("concept") Concept concept) {
		
		Itinerary itinerary = studyDAO.getItinerary(concept.getItinerary().getItineraryID());
		studyDAO.saveConcept(concept);
		
		itinerary.setItinerarypoints(itinerary.getItinerarypoints() +1);
		studyDAO.updateItinerary(itinerary);

		
		return "redirect:/itinerary/details";
	}
	
	@GetMapping("/updateConceptForm")
	public String updateConceptForm (@RequestParam("id") int id, @RequestParam("iid") int iid, Model model) {
	
	List<Itinerary> tableListItinerary = studyDAO.getItineraries();
	model.addAttribute("tableListItinerary", tableListItinerary);	
		
	Timer myTimer;
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatDateTime = now.format(formatter);
		final Concept concept = studyDAO.getConcept(id);
		
		class Note implements ActionListener {
			
			public void actionPerformed (ActionEvent e) {
				Toolkit.getDefaultToolkit().beep();
				String notes = "";
				concept.addNotesconcept(notes += JOptionPane.showInputDialog("Any note about " + concept.getTitleConcept() + " so far?") + " ");
			}
				
		}
		
		Note listener = new Note();
		
			switch (concept.getEffortEstimationConcept()) {
				case "S":
					myTimer = new Timer (300000, listener);
					myTimer.start();
					JOptionPane.showMessageDialog(null, concept.getTitleConcept() 
														+ " check-in study timer started at " 
														+ formatDateTime
														+ ".\nEvery 5 minutes will check if you have any "
														+ "note.\nClick Ok to stop the timer.");
					myTimer.stop();
					break;
				case "M":
					myTimer = new Timer (600000, listener);
					myTimer.start();
					JOptionPane.showMessageDialog(null, concept.getTitleConcept() 
														+ " check-in study timer started at " 
														+ formatDateTime
														+ ".\nEvery 10 minutes will check if you have any "
														+ "note.\nClick Ok to stop the timer.");
					myTimer.stop();
					break;
				case "L":
					myTimer = new Timer (900000, listener);
					myTimer.start();
					JOptionPane.showMessageDialog(null, concept.getTitleConcept() 
														+ " check-in study timer started at " 
														+ formatDateTime
														+ ".\nEvery 15 minutes will check if you have any "
														+ "note.\nClick Ok to stop the timer.");
					myTimer.stop();
					break;
				default:
					break;
		}
			
			Itinerary itinerary = studyDAO.getItinerary(iid);
			itinerary.addConcept(concept);
			model.addAttribute("concept", concept);
				
		return "updateConceptForm";
	}
	
	@PostMapping("updateConcept")
	public String updateConcept (@ModelAttribute("concept") Concept concept) {
		
		Itinerary itinerary = studyDAO.getItinerary(concept.getItinerary().getItineraryID());
		concept.setCheckInCounterConcept(concept.getCheckInCounterConcept() +1);
		studyDAO.updateConcept(concept);
		
		
		itinerary.setItinerarypoints(itinerary.getItinerarypoints() +4);
		studyDAO.updateItinerary(itinerary);
		
		return "redirect:/itinerary/details";
	}
	
	@GetMapping("/storeIdeaForm")
	public String viewStoreIdeaForm (@RequestParam("id") int id, @RequestParam("iid") int iid, Model model) {
		
		List<Itinerary> tableListItinerary = studyDAO.getItineraries();
		model.addAttribute("tableListItinerary", tableListItinerary);
		
		Concept concept = studyDAO.getConcept(id);
		Itinerary itinerary = studyDAO.getItinerary(iid);
		itinerary.addConcept(concept);
		Idea idea = new Idea();
		concept.addIdea(idea);
		model.addAttribute("idea", idea);
		
		return "storeIdeaForm";
	}
	
	@PostMapping("saveIdea")
	public String storeIdea (@ModelAttribute("idea") Idea idea) {
		
		Itinerary itinerary = studyDAO.getItinerary(idea.getConcept().getItinerary().getItineraryID());
		studyDAO.saveIdea(idea);
		
		itinerary.setItinerarypoints(itinerary.getItinerarypoints() +4);
		studyDAO.updateItinerary(itinerary);

		return "redirect:/itinerary/details";
	}
	
	@GetMapping("/updateIdeaForm")
	public String viewUpdateIdeaForm (@RequestParam("id") int id, @RequestParam("cid") int cid, Model model) {
		
		List<Itinerary> tableListItinerary = studyDAO.getItineraries();
		model.addAttribute("tableListItinerary", tableListItinerary);
		
		Concept concept = studyDAO.getConcept(cid); 
		Idea idea = studyDAO.getIdea(id);
		concept.addIdea(idea);
		model.addAttribute("idea", idea);
		
		return "updateIdeaForm";
	}
	
	@PostMapping("updateIdea")
	public String updateIdea (@ModelAttribute("idea") Idea idea) {
		
		studyDAO.updateIdea(idea);
		
		return "redirect:/itinerary/details";
	}
	
	@GetMapping("/deleteIdea")
	public String deleteIdea (@RequestParam("id") int id) {
		
		studyDAO.deleteIdea(id);
		
		return "redirect:/itinerary/details";
	}
	
	@GetMapping("/delete")
	public String deleteConcept (@RequestParam("id") int id) {
		
		studyDAO.deleteConcept(id);
		
		return "redirect:/itinerary/details";
	}
	
	@SuppressWarnings("finally")
	@GetMapping("/putBadges")
	public String putBadges (@RequestParam("iid") int iid) {
	
		Itinerary itinerary = studyDAO.getItinerary(iid);		
		try {

			if (itinerary.getItinerarypoints() >= 1 && itinerary.getItinerarypoints() <= 10) {
					
				studyDAO.putBadge(new Badge("Curious", "Curiosity is associated with all aspects of human development, from which derives the process of learning and desire to acquire knowledge and skill. Be curious, lets check in a concept, create and develop an idea.", "local_library"));
				
			} else if (itinerary.getItinerarypoints() > 10 && itinerary.getItinerarypoints() <= 20) {
				
				studyDAO.putBadge(new Badge("Explorer", "Exploration is the process of exploring, an activity which has some expectation of discovery. You are exploring well. Lets store and investigate new concepts.", "explore"));
				
			} else if (itinerary.getItinerarypoints() > 20 && itinerary.getItinerarypoints() <= 30) {
				
				studyDAO.putBadge(new Badge("Discoverer", "A discovery may sometimes be based on earlier discoveries, collaborations, or ideas during exploration. Some discoveries represent a radical breakthrough in knowledge or technology. You got a discovery. Keep the pase and focus on implementing your ideas.", "online_prediction"));
				
			} else if (itinerary.getItinerarypoints() > 30 && itinerary.getItinerarypoints() <= 50) {
				
				studyDAO.putBadge(new Badge("Especialist", "Devoted to a particular itinerary of Concepts and Ideas. You are becoming an specialist on the itinerary. Lets also store and investigate a new concept.", "grade"));

			} else if (itinerary.getItinerarypoints() > 50) {
				
				studyDAO.putBadge(new Badge("Feynman's drop of water", "Ideas and concepts are jiggling.", "water_drop"));

			}
			
		}finally {
			
			return "redirect:/itinerary/details";
		}
			
	}
	
}
