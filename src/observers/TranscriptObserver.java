
package observers;

import courses.Course;
import students.Transcript;

public class TranscriptObserver implements observers.Observer {
    private Transcript transcript;

    public TranscriptObserver(Transcript transcript) {
        this.transcript = transcript;
    }

    @Override
    public void update(String studentName, Course course, double grade) {
        System.out.println("Updating transcript for " + studentName + " for course: " + course.getCourseName());
        transcript.addCourse(course, grade);
    }
}
