import java.io.*;
import java.util.*;
public class HashTest {

    // 95791
    public static void main(String args[]){
        if (args.length != 2 && args.length != 3){
            System.out.println("java HashTest <input type> <load factor> [<debug level>]");
            System.exit(1);

        }
        int inputType = 0;
        int debugLevel = 0;
        double maxLoadFactor = 0;

        try{
            inputType = Integer.parseInt(args[0]);
            maxLoadFactor = Double.parseDouble(args[1]);
            if(args.length == 3){
                debugLevel = Integer.parseInt(args[2]);
            }
        }
        catch(Exception e){
            System.out.println("java HashTest <input type> <load factor> [<debug level>]");
            System.exit(1);
        }

        if(inputType < 1 || inputType > 3){
            System.out.println("java HashTest <input type> <load factor> [<debug level>]");
            System.exit(1);
        }
        if(maxLoadFactor < 0 || maxLoadFactor > 1){
            System.out.println("java HashTest <input type> <load factor> [<debug level>]");
            System.exit(1);
        }
        if(debugLevel < 0 || debugLevel > 1){
            System.out.println("java HashTest <input type> <load factor> [<debug level>]");
            System.exit(1);
        }

        if(inputType == 1){
            randomInput(maxLoadFactor, debugLevel);
        }
        if(inputType == 2){
            sysTimeInput(maxLoadFactor, debugLevel);
        }
        if(inputType == 3){
            wordListInput(maxLoadFactor, debugLevel);
        }  
    }
    public static void randomInput(double maxLoadFactor, int debugLevel){
        Random rand = new Random();
        int bufferNum;
        HashTable<Integer> linearPTable = new HashTable<Integer>(95791, maxLoadFactor, true);
        HashTable<Integer> doubleHTable = new HashTable<Integer>(95791, maxLoadFactor, false);

        while(linearPTable.getLoadFactor() < maxLoadFactor){
            bufferNum = rand.nextInt();
            linearPTable.put(bufferNum);
            doubleHTable.put(bufferNum);


        }
        System.out.println("Table size: " + linearPTable.getTableSize()); 
        System.out.println("Input type: java.util.random");
        System.out.println("Using Linear Hashing.... \n");
        System.out.println("Input: " + linearPTable.getSize() + ", of which " + linearPTable.getTotalDuplicates() + "are duplicates." );
        System.out.println("load factor = " + linearPTable.getLoadFactor() + "Avg. no. of Probes = " + linearPTable.getAverageProbes());
        System.out.println("Input: " + doubleHTable.getSize() + ", of which " + doubleHTable.getTotalDuplicates() );
        System.out.println("load factor = " + doubleHTable.getLoadFactor() + "Avg. no. of Probes = " + doubleHTable.getAverageProbes());

        if(debugLevel == 1){
            linearPTable.writeToFile("linear-dump");
            doubleHTable.writeToFile("double-dump");

        }


        


    }
    public static void sysTimeInput(double maxLoadFactor, int debugLevel){
        long bufferNum;
        HashTable<Long> linearPTable = new HashTable<Long>(95791, maxLoadFactor, true);
        HashTable<Long> doubleHTable = new HashTable<Long>(95791, maxLoadFactor, false);

        while(linearPTable.getLoadFactor() < maxLoadFactor){
            bufferNum = System.currentTimeMillis();
            linearPTable.put(bufferNum);
            doubleHTable.put(bufferNum);


        }
        System.out.println("Table size: " + linearPTable.getTableSize());
        System.out.println("Input type: System.currentTimeMilllis()");
        System.out.println("Using Linear Hashing.... \n");
        System.out.println("Input: " + linearPTable.getSize() + ", of which " + linearPTable.getTotalDuplicates() );
        System.out.println("load factor = " + linearPTable.getLoadFactor() + "Avg. no. of Probes = " + linearPTable.getAverageProbes());
        System.out.println("Input: " + doubleHTable.getSize() + ", of which " + doubleHTable.getTotalDuplicates() );
        System.out.println("load factor = " + doubleHTable.getLoadFactor() + "Avg. no. of Probes = " + doubleHTable.getAverageProbes());

        if(debugLevel == 1){
            linearPTable.writeToFile("linear-dump");
            doubleHTable.writeToFile("double-dump");

        }


        


    }

    public static void wordListInput(double maxLoadFactor, int debugLevel){

        try{
        Scanner scanner = new Scanner(new File("word-list"));
        String bufferWord;
        HashTable<String> linearPTable = new HashTable<String>(95791, maxLoadFactor, true);
        HashTable<String> doubleHTable = new HashTable<String>(95791, maxLoadFactor, false);

        while(linearPTable.getLoadFactor() < maxLoadFactor){
            bufferWord = scanner.nextLine();
            linearPTable.put(bufferWord);
            doubleHTable.put(bufferWord);


        }
        scanner.close();
        System.out.println("Table size: " + linearPTable.getTableSize());
        System.out.println("Input type: word-list");
        System.out.println("Using Linear Hashing.... \n");
        System.out.println("Input: " + linearPTable.getSize() + ", of which " + linearPTable.getTotalDuplicates() );
        System.out.println("load factor = " + linearPTable.getLoadFactor() + "Avg. no. of Probes = " + linearPTable.getAverageProbes());
        System.out.println("Input: " + doubleHTable.getSize() + ", of which " + doubleHTable.getTotalDuplicates() );
        System.out.println("load factor = " + doubleHTable.getLoadFactor() + "Avg. no. of Probes = " + doubleHTable.getAverageProbes());

        if(debugLevel == 1){
            linearPTable.writeToFile("linear-dump");
            doubleHTable.writeToFile("double-dump");

        }

        

        }
        catch(FileNotFoundException e){
            System.out.println("word-list is not found");
            System.exit(1);



        }
        


    }

    

   











}
