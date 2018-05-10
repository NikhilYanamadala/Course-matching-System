package edu.umkc.da;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Allocations happen in this class.
public class Mapping {
	
	private List<Course> courses;
	private List<Professor> professors;
	private Map<Integer,Integer> courseProfessorMapping;
	
	
	public Mapping() {
		Utility utility = new Utility();
		this.courses = utility.loadCourses();
		this.professors = utility.loadProfessors();
		this.courseProfessorMapping = new HashMap<>();
	}
	
	//Compute Score
	public double calculateScoreOfProfessor(Professor professor,Course course){
		double score = 0.0;
		for (Topic topic : professor.getTopicExpertise().keySet()) {
			if(course.getTopics().containsKey(topic)){
				score = score + (professor.getTopicExpertise().get(topic)/5.0) * course.getTopics().get(topic);
			}
		}
		return score;
	}
	
	
	public void mapCourseToProfessor(){
		//sort professors before allocating courses based on matching scores.
		for (Professor professor : professors) {
			double oldScore = 0.0;
			int matchingCourseId = -1;
			String name = null;
			for (Course course : courses) {
				if(!courseProfessorMapping.containsKey(course.getCourseID())){
					double newScore = calculateScoreOfProfessor(professor, course);
					//System.out.println(professor.getName()+"->"+course.getCourseName()+"->"+newScore);
					if(newScore > oldScore){
						name = course.getCourseName();
						matchingCourseId = course.getCourseID();
						oldScore = newScore;
					}
				}
			}
			System.out.println();
			//comment below line after testing
			System.out.println(professor.getName()+" : "+name+" : "+oldScore);
			courseProfessorMapping.put(matchingCourseId, professor.getProfessorID());
		}
		
	}
}
