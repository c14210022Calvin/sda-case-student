// src/students/Student.java
package students;

import courses.Course;
import observers.Observer;

import java.util.ArrayList;

public class Student {
    private String name;
    private String studentId;
    private ArrayList<Course> enrolledCourses;
    private Transcript transcript;
    private boolean isHonorRoll;
    private ArrayList<Observer> observers;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.transcript = new Transcript();
        this.isHonorRoll = false;
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Course course, double grade) {
        for (Observer observer : observers) {
            observer.update(name, course, grade);
        }
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public void completeCourse(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            notifyObservers(course, grade);
            enrolledCourses.remove(course);
            System.out.println(name + " completed " + course.getCourseName() + " with grade " + grade);
        } else {
            System.out.println("Student not enrolled in the course.");
        }
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void addHonorRollStatus() {
        this.isHonorRoll = true;
    }

    public boolean isHonorRoll() {
        return isHonorRoll;
    }

    public String getStudentId() { return studentId; }

    public String getName() { return name; }
}
