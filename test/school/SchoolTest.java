package school;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Zornitsa Petkova on 4/21/15.
 */
public class SchoolTest {
  School school;

  @Before
  public void setUp() {
    school = new School();
  }

  @Test
  public void sortOfMarks() {
    Student ivan = new Student("Ivan", 18006, "Informatika", 5.90);
    Student sisa = new Student("Sisa", 18010, "Matematika", 5.70);
    Student kaloqn = new Student("Kaloqn", 18002, "Informatika", 6.00);
    school.add(ivan);
    school.add(sisa);
    school.add(kaloqn);
    assertThat(school.sortMark("Informatika"), is("18002,6.0 18006,5.9 "));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void removeOfEmptyList() {
    school.remove(0);
  }

  @Test
  public void sortAllStudents() {
    Student ivan = new Student("Ivan", 18006, "Informatika", 5.90);
    Student sisa = new Student("Sisa", 18010, "Matematika", 5.70);
    Student kaloqn = new Student("Kaloqn", 18002, "Informatika", 6.00);
    school.add(ivan);
    school.add(sisa);
    school.add(kaloqn);
    school.remove(1);
    List<Student> list = school.sort();
    StringBuilder buffer = new StringBuilder();
    for (Student value : list) {
      buffer.append(value.getNumber()).append(" ");
    }

    assertThat(buffer.toString(), is("18002 18006 "));
  }

  @Test
  public void print() {
    Student ivan = new Student("Ivan", 18006, "Informatika", 5.90);
    Student sisa = new Student("Sisa", 18010, "Matematika", 5.70);
    Student kaloqn = new Student("Kaloqn", 18002, "Informatika", 6.00);
    school.add(ivan);
    school.add(sisa);
    school.add(kaloqn);
    final StringBuilder buffer = new StringBuilder();
    school.print(new Display() {
      @Override
      public void print(Student value) {
        buffer.append(value.getName()).append(" ");
      }
    });
    assertThat(buffer.toString(), is("Ivan Sisa Kaloqn "));
  }
}
