import java.util.Scanner;
import java.lang.Math;

public class NumberGame

{
    public static void guessthenumber()
    {
        Scanner sc = new Scanner(System.in);
 
        int number = 1 + (int)(100 * Math.random());
        int t = 5;
 
        int i, guess;
 
        System.out.println("I will choose a number between 1 to 100.");
        System.out.println("Guess the number in 5 trials.");

        for (i = 0; i < t; i++) 
        {
 
            System.out.println("Guess the number:");
            guess = sc.nextInt();

            if (number == guess) 
            {
                System.out.println("Congratulations! You guessed the number.");
                break;
            }

            else if (number > guess && i != t - 1) 
            {
                System.out.println("The number is greater than " + guess);
            }

            else if (number < guess && i != t - 1) 
            {
                System.out.println("The number is less than " + guess);
            }
        }
 
        if (i == t) 
        {
            System.out.println("You have exhausted t trials.");
 
            System.out.println("The number was " + number);
        }
    }

    public static void main(String[] args)
    {
        guessthenumber();
    }
}