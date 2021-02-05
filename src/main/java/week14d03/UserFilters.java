package week14d03;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class UserFilters {
    public UserFilter createFilter(List<Predicate<User>> predicates) {
        return users -> {
            for (Iterator<User> item = users.iterator(); item.hasNext(); ) {
                User user = item.next();
                boolean needRemove = false;
                for (Predicate<User> predicate : predicates) {
                    if (!predicate.test(user)) {
                        needRemove = true;
                    }
                }
                if (needRemove)
                {
                    item.remove();
                }
            }
            return users;
        };
    }

}
