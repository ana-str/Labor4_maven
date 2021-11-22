package model;


import exceptions.InvalidDataException;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private long studentID;
    private int totalCredits;
    private List<Course> enrolledCourses;

    public Student()  {

    }

    public Student(String firstName, String lastName, long studentID) throws InvalidDataException {
        super(firstName, lastName);
        if (studentID <= 0) {
            throw new InvalidDataException("Invalid ID");
        }
        this.studentID = studentID;
        this.totalCredits = 0;
        this.enrolledCourses = new ArrayList<>();
    }


    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {

        this.totalCredits = totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID;
    }

    @Override
    public String toString() {
        List<String> courses = new ArrayList<>();
        for (Course course : enrolledCourses) {
            courses.add(course.getName());
        }
        return "Student{" +
                "studentID=" + studentID +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", totalCredits=" + totalCredits +
                ", enrolledCourses=" + courses +
                '}';
    }

    /**
     * adds a course to the list of enrolled courses and updates the total number of credits
     * @param course the course to be added
     */
    public void addCourseToEnrolledCourses(Course course) {

        this.enrolledCourses.add(course);
        this.totalCredits += course.getCredits();
    }

    /**
     * removes a course from the list of enrolled courses and updates the total number of credits
     * @param course the course to be removed
     */
    public void removeCourseFromEnrolledCourses(Course course) {
        this.enrolledCourses.remove(course);
        this.totalCredits -= course.getCredits();
    }
}
