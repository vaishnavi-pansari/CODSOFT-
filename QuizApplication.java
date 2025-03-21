package CodeSoft;

import java.util.*;

class Question {
    private String questionText;
    private String[] options;
    private char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return null;
    }
}

public class QuizApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static Timer timer;
    private static boolean answered;

    private static final List<Question> questions = Arrays.asList(
            new Question("What is the capital of India?", new String[]{"A) Delhi", "B) Mumbai", "C) Kolkata", "D) Chennai"}, 'A'),
            new Question("Which language is used for Android development?", new String[]{"A) C++", "B) Java", "C) Python", "D) Swift"}, 'B'),
            new Question("Which data structure follows LIFO?", new String[]{"A) Queue", "B) Stack", "C) Array", "D) LinkedList"}, 'B')
    );

    public static void main(String[] args) {
        System.out.println("📢 Welcome to the Quiz Application with Timer! 🕒");
        startQuiz();
        System.out.println("\n🎯 Quiz Over! Your final score is: " + score + "/" + questions.size());
    }

    private static void startQuiz() {
        for (Question question : questions) {
            answered = false;
            askQuestion(question);
        }
    }

    private static void askQuestion(Question question) {
        System.out.println("\n" + question.getQuestionText());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("\n⏳ Time's up! Moving to next question.");
                    answered = true;
                    timer.cancel();
                }
            }
        }, 10000);

        System.out.print("Your Answer (A/B/C/D): ");
        String userAnswer = scanner.nextLine().toUpperCase();

        if (!answered) {
            checkAnswer(userAnswer.charAt(0), question.getCorrectAnswer());
            answered = true;
            timer.cancel();
        }
    }

    private static void checkAnswer(char userAnswer, char correctAnswer) {
        if (userAnswer == correctAnswer) {
            System.out.println("✅ Correct Answer!");
            score++;
        } else {
            System.out.println("❌ Wrong Answer! The correct answer was: " + correctAnswer);
        }
    }
}

