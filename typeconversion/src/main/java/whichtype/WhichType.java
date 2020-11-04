package whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {
    public List<Type> whichType(String s) {
        List<Type> convertableTypes = new ArrayList<>();
        long number = Long.parseLong(s);

        for (Type item : Type.values()) {
            if (number >= item.getMinValue() && number <= item.getMaxValue()) {
                convertableTypes.add(item);
            }
        }
        return convertableTypes;
    }
}
