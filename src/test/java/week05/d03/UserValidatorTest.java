package week05.d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {
    @Test
    public void testThrows() throws UserValidationException {
        List<User> users = new ArrayList<>();
        users.add(new User(null, 0));

        Exception ex = assertThrows(UserValidationException.class, () -> new UserValidator().validate(users));
        assertEquals("User name can't be null", ex.getMessage());

        users.clear();
        users.add(new User("", 0));

        ex = assertThrows(UserValidationException.class, () -> new UserValidator().validate(users));
        assertEquals("User name can't be blank", ex.getMessage());

        users.clear();
        users.add(new User("Béla", -1));

        ex = assertThrows(UserValidationException.class, () -> new UserValidator().validate(users));
        assertEquals("User age can't be less than zero.", ex.getMessage());

        users.clear();
        users.add(new User("Béla", 121));

        ex = assertThrows(UserValidationException.class, () -> new UserValidator().validate(users));
        assertEquals("User age can't be more than " + UserValidator.MAX_AGE + ".", ex.getMessage());
    }
}
