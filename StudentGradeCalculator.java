import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        int[] subjectScores = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            subjectScores[i] = scanner.nextInt();
        }
        
        int totalScore = 0;
        for (int score : subjectScores) {
            totalScore += score;
        }
        
        double averageScore = (double) totalScore / numSubjects;
        
        char grade;
        if (averageScore >= 90) {
            grade = 'A';
        } else if (averageScore >= 80) {
            grade = 'B';
        } else if (averageScore >= 70) {
            grade = 'C';
        } else if (averageScore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}

