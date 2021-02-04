package week12d01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsPacker {
    public int packGoods(int[][] types, int capacity) {
        List<Packet> packets = getPacketsFromArray(types);
        Collections.sort(packets);
        Collections.reverse(packets);

        List<Packet> packetsForCapacity = new ArrayList<>();
        int currentCapacity = 0;
        while (!packets.isEmpty() && currentCapacity <= capacity) {
            if (currentCapacity + packets.get(0).getWeight() <= capacity) {
                packetsForCapacity.addAll(getPacketMaxPacketForCapacity(packets, capacity - currentCapacity));
            }
            currentCapacity = getSumPacketsWeights(packetsForCapacity);
            packets.remove(0);
        }

        return getSumPacketsPrices(packetsForCapacity);
    }

    private int getSumPacketsPrices(List<Packet> packets) {
        int retVal = 0;
        for (Packet item : packets) {
            retVal += item.getPrice();
        }

        return retVal;
    }

    private int getSumPacketsWeights(List<Packet> packets) {
        int retVal = 0;
        for (Packet item : packets) {
            retVal += item.getWeight();
        }
        System.out.println(retVal);
        return retVal;
    }

    private List<Packet> getPacketMaxPacketForCapacity(List<Packet> packets, int capacity) {
        List<Packet> retVal = new ArrayList<>();
        int currentCapacity = 0;
        while ((currentCapacity + packets.get(0).getWeight()) <= capacity) {
            retVal.add(packets.get(0));
            currentCapacity += packets.get(0).getWeight();
        }
        return retVal;
    }

    private List<Packet> getPacketsFromArray(int[][] types) {
        List<Packet> retVal = new ArrayList<>();
        for (int[] item : types) {
            retVal.add(new Packet(item[0], item[1]));
        }

        return retVal;
    }

    public static void main(String[] args) {
        System.out.println(new GoodsPacker().packGoods(new int[][]{{7, 160}, {3, 90}, {2, 15}}, 20));
    }
}
