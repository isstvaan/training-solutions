package introconstructors;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Mama kifőzdéje", 4);

        System.out.println("Étterem: " + restaurant.getName() + " férőhelyek száma: " + restaurant.getCapacity() + "\n Menü: " + restaurant.getMenu().toString());
    }
}
