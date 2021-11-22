package repository;

import org.junit.jupiter.api.Test;
import model.Student;

import static org.junit.jupiter.api.Assertions.*;

class FileRepositoryTest {

    @Test
    void readFromFile() {
        StudentFileRepository studentFileRepository = new StudentFileRepository();
        assertEquals(studentFileRepository.getAll().size(), 5);
        assertEquals(studentFileRepository.getAll().get(0).getStudentID(), 100);
    }

    @Test
    void writeToFile() {
        StudentFileRepository studentFileRepository = new StudentFileRepository();
        Student student = new Student("John", "Doe", 103);
        studentFileRepository.save(student);
        assertEquals(studentFileRepository.getAll().size(), 6);
        studentFileRepository.delete(student);
        assertEquals(studentFileRepository.getAll().size(), 5);
    }
}
