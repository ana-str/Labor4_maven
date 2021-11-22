import controller.CourseController;
import controller.RegistrationSystem;
import controller.StudentController;
import controller.TeacherController;
import model.Course;
import model.Student;
import model.Teacher;

import repository.*;
import view.UI;


public class Main {

    public static void main(String[] args) throws Exception {
        StudentFileRepository studentFileRepository = new StudentFileRepository();
        StudentController studentController = new StudentController(studentFileRepository);
        for (Student myStudent : studentController.getAll()) {
            System.out.println(myStudent);
        }

        System.out.println("-------------------------------");

        TeacherFileRepository teacherFileRepository = new TeacherFileRepository();
        TeacherController teacherController = new TeacherController(teacherFileRepository);
        for (Teacher teacher : teacherController.getAll()) {
            System.out.println(teacher);
        }

        System.out.println("-------------------------------");

        CourseFileRepository courseFileRepository = new CourseFileRepository();
        CourseController courseController = new CourseController(courseFileRepository);
        for (Course course : courseController.getAll()) {
            System.out.println(course);
        }

        RegistrationSystem registrationSystem = new RegistrationSystem(studentController, courseController, teacherController);
        UI menu = new UI(registrationSystem);
        menu.startConsole();
    }
}
