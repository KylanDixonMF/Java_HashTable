
public class DoubleHashing {
    public static int DoubleHashing(int key, int failure, int size){
        int i = failure;
        int hashing1 =  PositiveMod(key, size);
        int hashing2 =  1 + (PositiveMod(key, size - 2));

        return (hashing1 + i * hashing2) % size;
    }
   

public static int PositiveMod (int dividend, int divisor)
{
    int value = dividend % divisor;
    if (value < 0)
        value += divisor;
        return value;
    
    
}
   
}
