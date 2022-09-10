package task9;

import java.util.Arrays;

public class MyQueue {
    private static final int CAPACITY_DEFAULT = 10;
    private Object[] objects = new Object[CAPACITY_DEFAULT];
    private  int size;

    public void add(Object element){
        if (objects.length == size){
            int newCapacity = (int) (objects.length * 1.5 + 1);
            objects = Arrays.copyOf(objects,newCapacity);
        }
        objects[size++] = element;
    }
    public Object remove(int index){
        Object object = objects[index];
        System.arraycopy(objects,index + 1, objects,index,size - index - 1);
        size--;
        return object;
    }
    public int size(){
        return size;
    }
    public void clear(){
        for (int i = 0; i < size; i++){
            objects[i] = null;
        }
        size = 0;
    }
    public Object poll(){
        Object object = objects[0];
        System.arraycopy(objects, 1, objects,0, --size);
        return object;
    }
    public Object peek(){
        if (size > 0){
            return  objects[0];
        } else {
            return null;
        }
    }
}
