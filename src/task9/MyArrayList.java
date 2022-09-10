package task9;

public class MyArrayList<T> {
    private T[] list;
    private int size;
    private static final int CAPACITY_DEFAULT = 10;
    public MyArrayList(int capacity){
        if (capacity <= 0){
            throw  new IllegalArgumentException();
        } else {
               list = (T[]) new Object[capacity];
           }
        }
    public  MyArrayList(){
        list = (T[]) new Object[CAPACITY_DEFAULT];
    }
    public void add(T item){
        list[size++] = item;
    }
    public void add(int index, T element){
        for (int i = size; i > index; i--){
            list[i] = list[i - 1];
        }
        list[index] = element;
        size++;
    }
    public void remove(int index){
        for (int i =  index; i < size; i++){
            list[i] = list[i+1];
        }
    }
    public void clear(){
        for (int i = 0; i < size; i++){
            list[i] = null;
        }
    }
    public int size(){
        return size;
    }
    public T get(int index){
        return list[index];
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(5);
        myArrayList.add(6);
    }
}
