//package high.skill.girl.prepare.interview.data_structure.list.homeworks;
//
//import java.util.List;
//
//public class MyArrayList<E> implements List<E> {
//    int size;
//    private E[] array;
//
//    @SuppressWarnings("unchecked")
//    public MyArrayList() {
//        array = (E[]) new Object[10];
//        size = 0;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public boolean add(E element) {
//        if (size >= array.length) {
//            E[] newArray = (E[]) new Object[array.length * 2]; // создаем большой массив
//            System.arraycopy(array, 0, newArray, 0, array.length); // копируем элементы
//            array = newArray;
//        }
//
//        array[size] = element; // кладем в последний индекс элемент
//        size++; // увеличиваем размер
//        return true;
//    }
//}
