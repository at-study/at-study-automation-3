package at.study.automation.tests;

import org.testng.annotations.Test;

import at.study.automation.model.user.User;

public class UserTest {

    @Test
    public void userCreationTest() {
        User user = new User();

        User user2 = new User();
        user2.setPassword("qwriqwiqw");
        user2.setFirstName("Иван");
        user2.setLastName("Петров");
    }
}
