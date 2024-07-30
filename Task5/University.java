import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    List<Course> courses;
    List<Student> students;

    public University() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        loadSampleData();
    }

    private void loadSampleData() {
        courses.add(new Course("CS101", "Introduction to Computer Science", "Basics of computer science", 30, "MWF 9:00-10:00"));
        courses.add(new Course("MATH201", "Calculus I", "Introduction to calculus", 25, "TTh 10:00-11:30"));
        courses.add(new Course("ENG101", "English Literature", "Study of classic literature", 20, "MWF 11:00-12:00"));
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println("Code: " + course.code);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Schedule: " + course.schedule);
            System.out.println("Capacity: " + course.capacity);
            System.out.println("Enrolled: " + course.enrolled);
            System.out.println("Available Slots: " + (course.capacity - course.enrolled));
            System.out.println();
        }
    }

    public Course findCourse(String code) {
        for (Course course : courses) {
            if (course.code.equalsIgnoreCase(code)) {
                return course;
            }
        }
        return null;
    }

    public Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.studentID.equalsIgnoreCase(studentID)) {
                return student;
            }
        }
        return null;
    }

    public void registerStudentForCourse(Student student, Course course) {
        if (student.registerForCourse(course)) {
            System.out.println(student.name + " successfully registered for " + course.title);
        } else {
            System.out.println("Failed to register " + student.name + " for " + course.title);
        }
    }

    public void dropStudentFromCourse(Student student, Course course) {
        if (student.dropCourse(course)) {
            System.out.println(student.name + " successfully dropped " + course.title);
        } else {
            System.out.println("Failed to drop " + student.name + " from " + course.title);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public static void main(String[] args) {
        University university = new University();
        Scanner scanner = new Scanner(System.in);

        // Adding a sample student
        Student student = new Student("S1001", "John Doe");
        university.addStudent(student);

        while (true) {
            System.out.println("University System");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    university.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.next();
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.next();

                    Student s = university.findStudent(studentID);
                    Course c = university.findCourse(courseCode);

                    if (s != null && c != null) {
                        university.registerStudentForCourse(s, c);
                    } else {
                        System.out.println("Invalid Student ID or Course Code.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String studentIDDrop = scanner.next();
                    System.out.print("Enter Course Code: ");
                    String courseCodeDrop = scanner.next();

                    Student sDrop = university.findStudent(studentIDDrop);
                    Course cDrop = university.findCourse(courseCodeDrop);

                    if (sDrop != null && cDrop != null) {
                        university.dropStudentFromCourse(sDrop, cDrop);
                    } else {
                        System.out.println("Invalid Student ID or Course Code.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
