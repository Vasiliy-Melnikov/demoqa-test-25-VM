import org.junit.jupiter.api.*;
public class SimpleJUnitTest {
    int result;

    @BeforeAll
    static void beforeAll () {
        System.out.println("\n###   beforeAll()\n");
    }
    @BeforeEach
    void beforeEach (){
        System.out.println("###   beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach (){
        System.out.println("###   AfterEach()\n");
        result = 0;
    }

    @AfterAll
    static void afterAll () {
        System.out.println("\n###   beforeAll()\n");
    }

    @Test
    void firstTest () {
        System.out.println("###   firstTest ()");
        Assertions.assertTrue(result>2);
    }
    private int getResult() {
return 3;
    }
}

