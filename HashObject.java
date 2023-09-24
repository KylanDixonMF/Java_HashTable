import java.util.*;

public class HashObject<T> {

   T hashObject;
   long frequencyCount = 0;
   long probeCount;
   T key;

   public HashObject(T key, int probeCount){
      this.probeCount = probeCount;
      this.frequencyCount = 0;
      this.key = key;


      
   }
   public boolean equals(Object obj){

      if(obj == null || obj.getClass() != getClass()){
         return false;
      }
      HashObject<T> hashObj = (HashObject <T>)obj;
         return (hashObj.key.equals(key));
      
   }

   


   public T getKey() {
      return key;

   }

   public long getFrequencyCount() {

      return this.frequencyCount;
   }

   public void setFrequencyCount(long val) {

      this.frequencyCount = val;
   }

   public long getProbeCount() {

      return this.probeCount;
   }

   public void setProbeCount(int val) {

      this.probeCount = val;
   }
   public String toString(){
      return this.key.toString() + " " + this.frequencyCount + " " + this.probeCount;
   }

}
