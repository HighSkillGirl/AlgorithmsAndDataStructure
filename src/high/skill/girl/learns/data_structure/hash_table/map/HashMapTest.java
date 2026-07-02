package high.skill.girl.learns.data_structure.hash_table.map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        System.out.println("put A, 1 into empty map, old value is: " + map.put("A", 1));
        System.out.println("put B, 2 into map, old value is: " + map.put("B", 2));
        System.out.println("put A, 3 into map, old value is: " + map.put("A", 3));

        System.out.println("size: " + map.size());

        System.out.println("get value for A key from map: " + map.get("A"));
        System.out.println("get value for B key from map: " + map.get("B"));
        System.out.println("get value for not putted key from map: " + map.get("C"));

        System.out.println("contains A key from map: " + map.containsKey("A"));
        System.out.println("contains B key from map: " + map.containsKey("B"));
        System.out.println("contains not putted key from map: " + map.containsKey("C"));

        System.out.println("contains value 1: " + map.containsValue(1));
        System.out.println("contains value 2: " + map.containsValue(2));
        System.out.println("contains value 3: " + map.containsValue(3));

        System.out.println("remove key B, value was: " + map.remove("B"));
        System.out.println(map.get("B"));
        System.out.println(map.size());

        System.out.println("remove key A, value was: " + map.remove("A"));
        System.out.println(map.get("A"));
        System.out.println(map.size());

        System.out.println("put A, 1 into empty map, old value is: " + map.put("A", 1));
        System.out.println("put B, 2 into map, old value is: " + map.put("B", 2));
        System.out.println("put A, 3 into map, old value is: " + map.put("A", 3));
        System.out.println("put C, 4 into map, old value is: " + map.put("C", 4));
        System.out.println(map.size());

        System.out.println("remove [B, 2]: " + map.remove("B", 2));
        System.out.println(map.get("B"));
        System.out.println(map.size());

        System.out.println("remove [A, 1]: " + map.remove("A", 1));
        System.out.println(map.get("A"));
        System.out.println(map.size());

        System.out.println("remove [A, 3]: " + map.remove("A", 3));
        System.out.println(map.get("A"));
        System.out.println(map.size());

        System.out.println(map);
    }
}
