package com.sergio.week8;
//imported the 3 necessary java
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Stack;


public class Lab_Week8 {
    public static void main(String[] args) {
        //PART 2 - HASHSET OPERATIONS
        HashSet<Student> studentManagement = new HashSet<>();
        //creating 2 students to insert in all the parts
        Student st1 = new Student(1, "Delta", "delta@gmail.com");
        Student st2 = new Student(2, "Alfa", "alfa@gmail.com");
        Student st3 = new Student(3, "Charlie", "charlie@gmail.com");
        Student st4 = new Student(4, "Bravo", "bravo@gmail.com");
        //PART 1 - calling method add that checks if students exist and add or not
        //PART 4 - included in the method for part 1 the push(), so this part is also used in PART 4
        addStudent(studentManagement, st1);
        addStudent(studentManagement, st1); //will generate the error
        addStudent(studentManagement, st2);
        addStudent(studentManagement, st3);
        addStudent(studentManagement, st4);
        //PART 1 - calling method to display all students
        displayStudents(studentManagement);

        //PART 3 - TREESET OPERATIONS
        TreeSet<Student> studentManagementTree = new TreeSet<>();
        //PART 3 - adding students to tree (using the same ones used before), new method
        addStudentToTree(studentManagementTree, st1);
        addStudentToTree(studentManagementTree, st2);
        addStudentToTree(studentManagementTree, st3);
        addStudentToTree(studentManagementTree, st4);
        //PART 3 - displaying students in alphabetical using method
        displayStudentsFromTree(studentManagementTree);

        //PART 4 - STACK
        //PART 4 - no method was requested to print, but I am putting to see if students were included with the add
        if (studentHistory.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("Printing all students in the stack:");
            for (Student student : studentHistory) {
                System.out.println(student.getId() + " - " + student.getName() + " - " + student.getEmail());
            }
        }

        //PART 4 - tests, printing all users, removing one with method and printing again
        popStudentFromStack();
        System.out.println();
        if (studentHistory.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("Printing all students in the stack:");
            for (Student student : studentHistory) {
                System.out.println(student.getId() + " - " + student.getName() + " - " + student.getEmail());
            }
        }


    }
    //PART 4 - STACK
        private static Stack<Student> studentHistory = new Stack<>();

    //PART 2 and PART 4 - method to add students
    public static void addStudent(HashSet<Student> studentManagement, Student student){
        System.out.println("\nUsing HASHSET and STACK to try and ADD a student");
        //Checks if the id is existent
        if (studentManagement.contains(student)) {
            System.out.println("Student with ID " + student.getId() + " already exists in the system.");
            //if it exists print and error and finishes
        } else {
            //if id does not exists include in the hash
            studentManagement.add(student);
            //also includes in the STACK for PART 4
            studentHistory.push(student);
            //prints a sentence just to inform it was added
            System.out.println("Added student: " + student.getName() + " in the HASHSET and STACK");
        }
    }

    //PART 2 - method to display all the registers in the hashtree
    public static void displayStudents(HashSet<Student> studentManagement) {
        System.out.println();
        System.out.println("Printing all students that are registered (method created using HASHSET):");
        //create a for loop to print each one of the ids
        for (Student student : studentManagement) {
            System.out.println(student.getId() + " - " + student.getName() + " - " + student.getEmail());
        }
    }
    //PART 3 - method to add students to tree
    public static void addStudentToTree(TreeSet<Student> studentManagementTree, Student student) {
        System.out.println("\nUsing TREESET to try and ADD a student");
        if (studentManagementTree.contains(student)) {
            System.out.println("Student with ID " + student.getId() + " already exists in the system.");
        } else {
            studentManagementTree.add(student);
            System.out.println("Added student: " + student.getName());
        }
    }
    //PART 3 - method to display students in the Tree
    public static void displayStudentsFromTree(TreeSet<Student> studentManagementTree) {
        System.out.println("\nPrinting all students sorted by name (using TREESET):");
        for (Student student : studentManagementTree) {
            System.out.println(student.getId() + " - " + student.getName() + " - " + student.getEmail());
        }
    }
    //PART 4 - method to pop students from STACK
    public static void popStudentFromStack() {
        if (!studentHistory.isEmpty()) {
            Student lastStudent = studentHistory.pop();
            System.out.println("\nLast added student removed from stack:");
            System.out.println(lastStudent.getId() + " - " + lastStudent.getName() + " - " + lastStudent.getEmail());
        } else {
            System.out.println("\nNo students in the history stack.");
        }
    }
}
    // PART 1 - Define a Student class implementing Comparable to allow sorting
    class Student implements Comparable<Student>{
        //PART 3 - override to compare in the Treeset
        @Override
        public int compareTo(Student other) {
            return this.name.compareTo(other.name);
        }
        //PART 1 - define the 3 variables in the class
        private String name;
        private int id;
        private String email;
        //PART 1 - constructor with the variables and this
        public Student(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
        //PART 1 - Getters for the 3 variables
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        //PART 1 - comparison using equals()
        @Override
            public boolean equals(Object obj) {
                if (obj instanceof Student) {
                    return this.id == ((Student) obj).id;
                }
                return false;
            }
        //PART 1 - implement hashcode
        @Override
            public int hashCode() {
                return id;
            }
        }




