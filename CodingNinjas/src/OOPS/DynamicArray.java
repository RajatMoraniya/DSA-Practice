package OOPS;

public class DynamicArray {
    private int[] data;
    private int nextIndex;
    public DynamicArray(){
        data= new int[5];
         nextIndex = 0;
    }

    public int size(){
        return nextIndex;
    }

    public void add(int element){
        if(nextIndex==data.length){
            restructure();
        }
        data[nextIndex]= element;
        nextIndex++;

    }

    public void set(int index , int element){
        if(index>nextIndex){
            return;
        }
        if(index<nextIndex) {
            data[index] = element;
        }
        else {
            add(element);
        }
    }

    public int get(int index){
        if(index>=nextIndex) {

            return -1;
        }
        return data[index];
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int removeLast(){
        if(size()==0){
            return -1;
        }
        int val = data[nextIndex-1];
        data[nextIndex-1] = 0;
        nextIndex--;
        return val;
    }

    private void restructure(){
        int[] temp = data;
        data = new int[2*data.length];
        for(int i = 0 ; i < temp.length ; i++){
            data[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();
        for (int i = 0; i < 100; i++) {
            d.add(i+10);
        }
        System.out.println("size = " + d.size());

        d.set(4,10);
        System.out.println("Get 3 = " + d.get(3));
        System.out.println("Get 4 = " + d.get(4));

        while(!d.isEmpty()){
            System.out.println("removed = " + d.removeLast());
            System.out.println("size : " + d.size());
            System.out.println();
        }

    }
}
