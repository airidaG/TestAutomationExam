import com.github.javafaker.Faker;

import java.util.Random;

public class TestDataUtil {
    private static final Faker faker = new Faker();

    //user info
    private static String username;
    private static String password;
    private static String shortPassword;
    private static final String SHORT_USERNAME = "me";
    //calc operations
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String TIMES = "*";
    private static final String DIVIDE = "/";
    //calc data
    private static String firstNum;
    private static String secondNum;
    private static final String FIRST_NUM_NEGATIVE = "-10";
    private static final String SECOND_NUM_NEGATIVE = "-5";
    //err
    private static final String ERROR_MESSAGE = "Test data was not generated. Call generateData() first.";


    //generate
    public static void generateData(){
        username = faker.name().username();
        password = faker.internet().password(6, 16);
    }
    public static void generateTooShortPassword(){
        shortPassword = faker.internet().password(1, 2);
    }
    public static void generateFirstNumber() {
        Random random = new Random();
        int num = random.nextInt(20) + 1;
        firstNum = String.valueOf(num);
    }
    public static void generateSecondNumber() {
        Random random = new Random();
        int num = random.nextInt(20) + 1;
        secondNum = String.valueOf(num);
    }

    //get
    public static String getUsername(){
        if (username == null){
            throw new IllegalStateException(ERROR_MESSAGE);
        }
        return username;
    }
    public static String getPassword(){
        if (password == null){
            throw new IllegalStateException(ERROR_MESSAGE);
        }
        return password;
    }
    public static String getShortPassword(){
        if (shortPassword == null){
            throw new IllegalStateException(ERROR_MESSAGE);
        }
        return shortPassword;
    }
    public static String getShortUsername(){
        return SHORT_USERNAME;
    }
    public static String getMinus(){
        return MINUS;
    }
    public static String getTimes(){
        return TIMES;
    }
    public static String getDivide(){
        return DIVIDE;
    }
    public static String getPlus(){
        return PLUS;
    }
    public static String getSecondNum(){
        return secondNum;
    }
    public static String getFirstNum(){
        return firstNum;
    }

    public static String getFirstNumNegative() {
        return FIRST_NUM_NEGATIVE;
    }

    public static String getSecondNumNegative() {
        return SECOND_NUM_NEGATIVE;
    }

}
