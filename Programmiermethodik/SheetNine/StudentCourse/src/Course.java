import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Course {

	public static final String FILE_LOCATION = "StudentCourse/resources/students.data";
	
  private List<Student> students;
  
  public Course(){
  	File file = new File(FILE_LOCATION);
  	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
  		this.students = (List<Student>) ois.readObject();
  	} catch (IOException | ClassNotFoundException ex){
  		System.out.println("Could not load data file: " + ex.getMessage());
  	}
  }

  private double getAverageGrade(){
  	double sum = 0;
    for (Student student: students){
    	sum += student.getGrade();
    }
    return sum / students.size();
  }

  public static void main(String[] args){
    Course course = new Course();
    System.out.println(course.getAverageGrade());
  }
}
