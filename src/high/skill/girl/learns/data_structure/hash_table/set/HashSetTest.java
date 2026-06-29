package high.skill.girl.learns.data_structure.hash_table.set;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> myHashSet = new HashSet<>();

        myHashSet.add(1, 1);
        System.out.println("add 1 element, size: " + myHashSet.size());

        myHashSet.add(2, 2);
        myHashSet.add(3, 3);
        System.out.println("add more 2 elements, size: " + myHashSet.size());

        myHashSet.add(4, 4);
        System.out.println("add 1 different element, size: " + myHashSet.size());

        myHashSet.add(4, 4);
        System.out.println("add the same element, size: " + myHashSet.size());

        myHashSet.add(5, 4);
        System.out.println("add different element into one bucket, size: " + myHashSet.size());

        System.out.println(myHashSet);

        System.out.println("set contains 5: " + myHashSet.contains(5));
        System.out.println("set contains 0: " + myHashSet.contains(0));

        myHashSet.add(6, 4);
        myHashSet.remove(4, 4);
    }
}
