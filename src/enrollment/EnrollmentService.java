
package enrollment;

import students.Student;
import courses.Course;

public class EnrollmentService {
    private static EnrollmentService instance;


    private EnrollmentService() {
    }


    public static EnrollmentService getInstance() {
        if (instance == null) {
            instance = new EnrollmentService();
        }
        return instance;
    }

    public void enroll(Student student, Course course) {
        student.enrollInCourse(course);
        System.out.println("Enrolled " + student.getName() + " in " + course.getCourseName());
    }
}
