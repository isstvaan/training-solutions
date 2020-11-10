package introconstructors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = numberOfTables * 4;

        menu = getDefaultMenu();
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    private List<String> getDefaultMenu() {
        ArrayList<String> menuList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            menuList.add("Előétel " + (i + 1));
            menuList.add("Főétel " + (i + 1));
            menuList.add("Desszert " + (i + 1));
        }

        return menuList;
    }
}
