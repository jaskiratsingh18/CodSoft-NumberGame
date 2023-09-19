import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion
{
    String question;
    String[] choices;
    int correctAnswerIndex;

    QuizQuestion(String question, String[] choices, int correctAnswerIndex) 
    {
        this.question = question;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

public class QuizApplication 
{
    private static int score = 0;
    private static int questionIndex = 0;
    private static Timer timer = new Timer();
    private static boolean isTimeUp = false;

    private static QuizQuestion[] questions = 
    {
        new QuizQuestion("What is the capital of INDIA?",
                new String[]{"A. New Delhi", "B. Mumbai", "C. Kolkata", "D. Chandigarh"}, 0),

        new QuizQuestion("Which planet is known as the Red Planet?",
                new String[]{"A. Venus", "B. Jupiter", "C. Mars", "D. Neptune"}, 2),

        new QuizQuestion("What is the largest mammal in the world?",
                new String[]{"A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Lion"}, 1),

        new QuizQuestion("What is the chemical name for Salt?",
                new String[]{"A. NaI", "B. KCl", "C. NaCl", "D. NaBr"}, 2),

        new QuizQuestion("Which gas has the highest percentage the atmosphere?",
                new String[]{"A. Oxygen", "B. Carbon Dioxide", "C. Hydrogen", "D. Nitrogen"}, 3)
    };

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz!");
        System.out.println("You have 30 seconds to answer each question.\n");

        timer.schedule(new TimerTask() 
        {
        
            public void run() 
            {
                isTimeUp = true;
                System.out.println("\nTime's up for this question!");
                nextQuestion(scanner);
            }
        }, 30000);

        nextQuestion(scanner);
    }

    private static void nextQuestion(Scanner scanner) 
    {
        if (questionIndex < questions.length) {
            QuizQuestion currentQuestion = questions[questionIndex];

            System.out.println("Question " + (questionIndex + 1) + ": " + currentQuestion.question);
            for (String choice : currentQuestion.choices) 
            {
                System.out.println(choice);
            }

            if (!isTimeUp) 
            {
                System.out.print("Enter the letter of your answer: ");
                String userAnswer = scanner.nextLine().toUpperCase();

                if (userAnswer.equals(currentQuestion.choices[currentQuestion.correctAnswerIndex].substring(0, 1))) {
                    score++;
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Wrong! The correct answer is " + currentQuestion.choices[currentQuestion.correctAnswerIndex] + "\n");
                }
            }

            questionIndex++;
            isTimeUp = false;
            timer.cancel();
            timer = new Timer();

            timer.schedule(new TimerTask() 
            {
                public void run() {
                    isTimeUp = true;
                    System.out.println("\nTime's up for this question!");
                    nextQuestion(scanner);
                }
            }, 30000); 

            nextQuestion(scanner);
        } else {
            finishQuiz();
        }
    }

    private static void finishQuiz() 
    {
        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score + " out of " + questions.length);
        timer.cancel();
        System.exit(0);
    }
}
