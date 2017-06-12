import java.io.Serializable;

public class Student implements Serializable{
  
  private static final long serialVersionUID = -3353569852755414639L;
  private Integer id;
  private String firstName;
  private String lastName;
  private Integer grade;

  public Integer getGrade() {
    if (grade == null){
      return 3;
    } else {
      return grade;
    }
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
} 
