package tests;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {

    private static final Faker faker = new Faker(Locale.US);

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String fullName = firstName + " " + lastName;

    public final String email = faker.internet().emailAddress();
    public final String mobile = faker.phoneNumber().subscriberNumber(10);

    public final String gender = "Male";

    public final String birthMonth = "November";
    public final String birthYear = "1993";
    public final String birthDay = "19";

    public final String expectedDateOfBirth = birthDay + " " + birthMonth + "," + birthYear;

    public final String subject1 = "Maths";
    public final String subject2 = "Computer Science";
    public final String expectedSubjects = subject1 + ", " + subject2;

    public final String hobby1 = "Sports";
    public final String hobby2 = "Reading";
    public final String hobby3 = "Music";
    public final String expectedHobbies = hobby1 + ", " + hobby2 + ", " + hobby3;

    public final String picture = "mycat.jpg";

    public final String currentAddress = faker.address().fullAddress();
    public final String permanentAddress = faker.address().streetAddress();

    public final String state = "NCR";
    public final String city = "Delhi";
    public final String expectedStateAndCity = state + " " + city;
}
