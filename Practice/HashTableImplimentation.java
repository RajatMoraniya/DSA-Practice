package Practice;

public class HashTableImplimentation {
    public static void main(String[] args) {
        int size = 5;
        int[] arr = new int[5];
        insert(arr,10,size);
        insert(arr,15,size);
        insert(arr,20,size);
        insert(arr,25,size);
        insert(arr,30,size);

        System.out.println(arr[3]);
    }
    void init(int [] arr,int size)
    {
        for(int i = 0 ; i < size ; i++){
            arr[i] = -1;
        }
    }

    public static int insert(int arr[] , int value , int size)
    {
        int key = value%size;
        int index = key;

        while(arr[index] != -1)
        {
            index = (index+1) % size;
            if(index == key)
            {
                System.out.println("Hash Table Full");
                return 0;
            }
        }
        arr[index] = value;
        return 1;
    }
}
