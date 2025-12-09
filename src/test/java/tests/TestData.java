package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestData {

    private static final Faker faker = new Faker(Locale.US);

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String fullName = firstName + " " + lastName;

    public final String email = faker.internet().emailAddress();

    public final String gender = faker.options().option("Male", "Female", "Other");

    public final String mobile = faker.phoneNumber().subscriberNumber(10);

    private final Date randomBirthDate = faker.date().birthday();
    private final SimpleDateFormat dayFmt = new SimpleDateFormat("d");
    private final SimpleDateFormat monthFmt = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    private final SimpleDateFormat yearFmt = new SimpleDateFormat("yyyy");

    public final String birthDay = dayFmt.format(randomBirthDate);
    public final String birthMonth = monthFmt.format(randomBirthDate);
    public final String birthYear = yearFmt.format(randomBirthDate);

    public final String expectedDateOfBirth = birthDay + " " + birthMonth + "," + birthYear;

    public final String subject1 = faker.options().option(
            "Maths", "Physics", "Chemistry", "English", "Biology", "Computer Science"
    );
    public final String subject2 = faker.options().option(
            "Maths", "Physics", "Chemistry", "English", "Biology", "Computer Science"
    );
    public final String expectedSubjects = subject1 + ", " + subject2;

    private static final List<String> HOBBIES = Arrays.asList("Sports", "Reading", "Music");
    private final List<String> shuffledHobbies = new ArrayList<>(HOBBIES);

    public final String hobby1;
    public final String hobby2;
    public final String hobby3;
    public final String expectedHobbies;

    public TestData() {
        Collections.shuffle(shuffledHobbies, new Random(faker.random().nextLong()));

        this.hobby1 = shuffledHobbies.get(0);
        this.hobby2 = shuffledHobbies.get(1);
        this.hobby3 = shuffledHobbies.get(2);

        this.expectedHobbies = String.join(", ", shuffledHobbies);
    }

    public final String picture = "mycat.jpg";

    public final String currentAddress = faker.address().fullAddress();
    public final String permanentAddress = faker.address().secondaryAddress();

    public final String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public final String city = switch (state) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> "Delhi";
    };

    public final String expectedStateAndCity = state + " " + city;
}