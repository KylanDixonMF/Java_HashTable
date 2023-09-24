
public class LinearProbe {
    public static int LinearProbe(int key, int failure, int size){
        int i = failure;
        int hashing1 =  PositiveMod(key, size);

        return (hashing1 + i) % size;
    }
   

public static int PositiveMod (int dividend, int divisor)
{
    int value = dividend % divisor;
    if (value < 0)
        value += divisor;
        return value;
    
    
}
}
