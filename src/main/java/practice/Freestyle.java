package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Freestyle {

    public static void main(String[] args) {
        String name = "Maria";
        //master

        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 2);

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            System.out.println(i.getValue());
            System.out.println(i.getKey());
        }
    }
}