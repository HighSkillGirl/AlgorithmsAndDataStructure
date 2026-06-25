package high.skill.girl.learns.data_structure.list.array;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("empty list contains 1: " + list.contains(1));
        System.out.println("empty list size: " + list.size());

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println("was added values, size: " + list.size());
        System.out.println(list);

        System.out.println("get from the list value by index 2: " + list.get(2));

        list.addFirst(0);
        System.out.println(list);

        list.add(2, -33);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
