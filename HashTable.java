import java.io.FileWriter;

public class HashTable<T> {
   
    //default method is linear probing
    HashObject<T>[] hashTable;
        long size = 0;
        boolean addMethod = true;
        double loadFactor = .75;
        long duplicate = 0;
        long totalProbes = 0;
        long uniqueProbes = 0;
        long uniqueStore = 0;

    public HashTable(int size, double loadFactor, boolean addMethod){
        hashTable = new HashObject[size];
        this.loadFactor = loadFactor;
        this.addMethod = addMethod;

    }

    public int hashFunction(int key, int failure){
        if(addMethod == true){
            return LinearProbe.LinearProbe(key, failure, hashTable.length);
        }
        else{
            return DoubleHashing.DoubleHashing(key, failure, hashTable.length);
        }
    }

    public void put(T key){   
        
    //     int i = 0;
        
    //     while(i != hashTable.length){
    //         int j = hashFunction(key, i);
    //         if(hashTable[j] == null){
    //             hashTable[j] = new HashObject(value, i + 1);
    //             size++;
    //             totalProbes += i + 1;
    //             return j;
    //         }
    //         else if (hashTable[j].equals(value)){
    //             hashTable[j].frequencyCount++;
    //         }
    //         else{
    //             i++;
    //         }
    //     }
    //     return -1;
 
    int probeCount = 0;
    int index = 0;
    boolean end = false;
    

    while(!end){
    
        index = hashFunction(key.hashCode(), probeCount);
        probeCount++;

        if(hashTable[index] == null){
            end = true;
            hashTable[index] = new HashObject<T>(key, probeCount);
            totalProbes += probeCount;
            uniqueProbes += probeCount;
            size++;
            uniqueStore++;
        }
        else if(hashTable[index].getKey().equals(key)){
            end = true;
            hashTable[index].setFrequencyCount(hashTable[index].getFrequencyCount() + 1);
            totalProbes += probeCount;
            size++;
        }
    }


    }
    public boolean writeToFile(String file){
        try{
            FileWriter fileWriter = new FileWriter(file);

            for(int i = 0; i < hashTable.length; i++){
                if(hashTable[i] != null){
                    fileWriter.write("table[" + i + "]: " + hashTable[i].toString() + "\n");
                    
                }
            }
            fileWriter.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public double getLoadFactor(){
        return (double)uniqueStore / (double)hashTable.length;
    }

    public long getTotalDuplicates(){
        return this.duplicate;
    }
    public long getTotalProbes(){
        return this.totalProbes;
    }
    public double getAverageProbes(){
        return (double)uniqueProbes / (double)uniqueStore;
    }
    public long getSize(){
        return size;
    }
    public int getTableSize(){
        return hashTable.length;
    }

    



    
}
