package week05.d03;

import java.util.List;

public class UserValidator {
    static final int MAX_AGE = 120;

    public void validate(List<User> users) {
        for (User item : users) {
            if (item.getName() == null) {
                throw new UserValidationException("User name can't be null");
            }
            if (item.getName().isBlank()) {
                throw new UserValidationException("User name can't be blank");
            }
            if (item.getAge() < 0) {
                throw new UserValidationException("User age can't be less than zero.");
            }
            if (item.getAge() > MAX_AGE) {
                throw new UserValidationException("User age can't be more than " + MAX_AGE + ".");
            }
        }
    }
}
