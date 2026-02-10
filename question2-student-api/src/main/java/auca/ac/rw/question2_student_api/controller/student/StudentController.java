package auca.ac.rw.question2_student_api.controller.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.question2_student_api.modal.studentRegistration.Student;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1l, "ASDODJI", "Le Sage", "asdodji@auca.ac.rw", "Software Engineering", 4.5));
        students.add(new Student(2l, "NADJILEM", "Oscar", "nadjilem@auca.ac.rw", "Software Engineering", 4.8));
        students.add(new Student(3l, "SADE", "George", "sade@auca.ac.rw", "Software Engineering", 4.9));
        students.add(new Student(4l, "Saint", "Moses", "saint@auca.ac.rw", "Business", 2.7));
        students.add(new Student(5l, "Pablo Emilio", "Escobar Gaviria", "pablo@auca.ac.rw", "Business", 3.2));
    }
    
    // GET /api/students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students); // 200 OK
    }

    // GET /api/students/{studentId}
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return ResponseEntity.ok(student); // 200 OK
            }
        }
        return ResponseEntity.notFound().build(); // 404 Not Found      
    }

    // GET /api/students/major/{major}
    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }

        return ResponseEntity.ok(result); // 200 OK
    }

    // GET /api/students/filter?gpa={minGpa}
    @GetMapping("/filter")
    public ResponseEntity<List<Student>> getStudentsByGpa(@RequestParam Double gpa) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getGpa() >= gpa) {
                result.add(student);
            }
        }

        return ResponseEntity.ok(result); // 200 OK
    }

    // Post /api/students
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student); // 201 Created
    }

    // PUT /api/students/{studentId}
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setFirstName(updatedStudent.getFirstName());
                student.setLastName(updatedStudent.getLastName());
                student.setEmail(updatedStudent.getEmail());
                student.setMajor(updatedStudent.getMajor());
                student.setGpa(updatedStudent.getGpa());
                return ResponseEntity.ok(student); // 200 OK
            }
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }

}
