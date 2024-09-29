
package observers;

import courses.Course;

public interface Observer {
    void update(String studentName, Course course, double grade);
}
