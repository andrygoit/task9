package task9;

import java.util.Arrays;

public class MyStack {
    private static final int CAPACITY_DEFAULT = 15;
    private Object[] objects = new Object[CAPACITY_DEFAULT];
    private int size = 0;
    public void add(Object val){
        if (objects.length == size){
            int newCapacity = (int) (objects.length * 1.5 + 1);
            objects = Arrays.copyOf(objects,newCapacity);
        }
        objects[size++] = val;
    }
    public Object remove(int index){
        Object o = objects[index];
        System.arraycopy(objects, index + 1, objects, index, size - index);
        size--;
        return o;
    }
    public Object peek(){
        return objects[size -1];
    }
    public Object pop(){
        Object o = objects[size - 1];
        objects[size -1] = null;
        size--;
        return o;
    }
    public int size(){
        return size;
    }
    public void clear(){
        for (int i = 0; i < size; i++){
            objects[i] = null;
            size = 0;
        }
    }
}
