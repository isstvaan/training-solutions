package array;

public class ArrayHandler {

    private int find(int[] source, int itemToFind)
    {
        for (int i = 0; i < source.length; i++) {
            if (itemToFind == source[i])
            {
                return  i;
            }
        }
        return -1;
    }

    private boolean contains(int[] source, int itemToFind)
    {
        for (int i = 0; i < source.length; i++) {
            if (itemToFind == source[i])
            {
                return  true;
            }
        }
        return false;
    }
}
