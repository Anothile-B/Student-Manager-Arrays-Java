/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.student_arrays;

import javax.swing.JOptionPane;

/**
 *
 * @author 27817
 */
public class Student_Arrays {

    /**
     * @param args the command line arguments
     */
    
    // Declarations --> Global Variables 
    // Arrays 
    // All Arrays have been declared as static as we are working in the main 
    private static final int MAX_STUDENTS = 100;
    private static String[] firstNames = new String[MAX_STUDENTS];
    private static String[] lastNames = new String[MAX_STUDENTS];
    private static int[] ages = new int[MAX_STUDENTS];
    private static int[] marks = new int[MAX_STUDENTS];
    private static String[] studentNumbers = new String[MAX_STUDENTS];
    private static int studentCount = 0;

    public static void main(String[] args) {
        
        // While Loop to loop the selection menu 
        while (true) {
            // Create an Area to make use of drop-down JOptionPane
            String[] options = {
                "Add Student", "Display All Students", "Display Student with Highest Marks",
                "Search Student by Student Number", "Exit"
            };
            String choice = (String) JOptionPane.showInputDialog(
                null, "Choose an option", "Student Manager", 
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]
            );
            
            if (choice == null || choice.equals("Exit")) {
                break;
            }
            
            // Switch statement to invoke modules based on users selection from menu
            switch (choice) {
                case "Add Student":
                    addStudent();
                    break;
                case "Display All Students":
                    displayAllStudents();
                    break;
                case "Display Student with Highest Marks":
                    displayStudentWithHighestMarks();
                    break;
                case "Search Student by Student Number":
                    searchStudentByNumber();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Invalid choice. Try again.", "INVALID", 
                            JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void addStudent() {
        // Setting a Limit to the number of entries 
        if (studentCount >= MAX_STUDENTS) {
            JOptionPane.showMessageDialog(null, 
                    "Maximum number of students reached.", "LIMIT", 
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // Prompt User for Details 
        String firstName = JOptionPane.showInputDialog(null, 
                "Please Enter First Name: ", "FIRST NAME", 
                JOptionPane.QUESTION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null,
                "Please Enter Last Name: ", "LAST NAME", 
                JOptionPane.QUESTION_MESSAGE);
        int age = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Please Enter Age: ", "AGE", 
                JOptionPane.QUESTION_MESSAGE));
        int studentMarks = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Please Enter marks: ", "MARKS", 
                JOptionPane.QUESTION_MESSAGE));
        String studentNumber = JOptionPane.showInputDialog(null, 
                "Enter student number: ", "STUDENT NUMBER", 
                JOptionPane.QUESTION_MESSAGE);
        
        // Populating the Array
        firstNames[studentCount] = firstName;
        lastNames[studentCount] = lastName;
        ages[studentCount] = age;
        marks[studentCount] = studentMarks;
        studentNumbers[studentCount] = studentNumber;
        studentCount++;
   
        
        JOptionPane.showMessageDialog(null, "Student added successfully.", 
                "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void displayAllStudents() {
        StringBuilder allStudents = new StringBuilder();
        for (int i = 0; i < studentCount; i++) {
            allStudents.append("First Name: ").append(firstNames[i])
                       .append("\nLast Name: ").append(lastNames[i])
                       .append("\nAge: ").append(ages[i])
                       .append("\nMarks: ").append(marks[i])
                       .append("\nStudent Number: ").append(studentNumbers[i])
                       .append("\n");
        }
        if (allStudents.length() == 0) {
            JOptionPane.showMessageDialog(null, "No students available.", 
                    "INCORRECT ENTRY", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, allStudents.toString(), 
                    "STUDENT LIST", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void displayStudentWithHighestMarks() {
        if (studentCount == 0) {
            JOptionPane.showMessageDialog(null, "No students available.", 
                    "INCORRECT ENTRY", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int highestMarksIndex = 0;
        for (int i = 1; i < studentCount; i++) {
            if (marks[i] > marks[highestMarksIndex]) {
                highestMarksIndex = i;
            }
        }
        JOptionPane.showMessageDialog(null, 
            "First Name: " + firstNames[highestMarksIndex] + 
            "\nLast Name: " + lastNames[highestMarksIndex] + 
            "\nAge: " + ages[highestMarksIndex] + 
            "\nMarks: " + marks[highestMarksIndex] + 
            "\nStudent Number: " + studentNumbers[highestMarksIndex], 
            "HIGHEST MARKS", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void searchStudentByNumber() {
        String studentNumber = JOptionPane.showInputDialog(null, "Enter student number to search:");
        for (int i = 0; i < studentCount; i++) {
            if (studentNumbers[i].equalsIgnoreCase(studentNumber)) {
                JOptionPane.showMessageDialog(null, 
                    "First Name: " + firstNames[i] + 
                    "\nLast Name: " + lastNames[i] + 
                    "\nAge: " + ages[i] + 
                    "\nMarks: " + marks[i] + 
                    "\nStudent Number: " + studentNumbers[i], 
                    "STUDENT SEARCH", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Student not found.", 
                "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
    }
}
        
        
    

