import java.util.*;

public class Quiz {
    List<Question> questions;
    int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("An object could be....", new String[]{"A. anything", "B. an algorithm", "C. a data container", "D. program"}, 'A'));
        questions.add(new Question(" Which of the below are reserved keyword in Java?", new String[]{"A. array", "B. str", "C. null", "D. java"}, 'C'));
        questions.add(new Question("Which data type is used to store a single character in Java?", new String[]{"A. char", "B. string", "C. int", "D. single"}, 'A'));
		questions.add(new Question("How many bytes does an int data type occupy in Java?", new String[]{"A. 1", "B. 2", "C. 3", "D. 4"}, 'D'));
		questions.add(new Question("Which keyword in Java is used for constant variables??", new String[]{"A. const", "B. static", "C. constant", "D. final"}, 'D'));

	}

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question q : questions) {
            askQuestion(q, scanner);
        }
        displayResults();
        scanner.close();
    }

    private void askQuestion(Question question, Scanner scanner) {
        System.out.println(question.questionText);
        for (String option : question.options) {
            System.out.println(option);
        }

        System.out.print("You have 10 seconds to answer. Enter your choice (A/B/C/D): ");

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                System.exit(0);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 10000);

        char answer = scanner.next().toUpperCase().charAt(0);
        timer.cancel();

        if (answer == question.correctAnswer) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.correctAnswer);
        }
        System.out.println();
    }

    private void displayResults() {
        System.out.println("Quiz Over!");
        System.out.println("Your Score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.start();
    }
}
