import java.util.*;

public class ParkingLotHashing{
    String[] table;
    int size=500;

    public ParkingLotHashing(){
        table=new String[size];
    }

    int hash(String plate){
        return Math.abs(plate.hashCode())%size;
    }

    public int park(String plate){
        int h=hash(plate);
        while(table[h]!=null){
            h=(h+1)%size;
        }
        table[h]=plate;
        return h;
    }

    public void exit(String plate){
        for(int i=0;i<size;i++){
            if(plate.equals(table[i])){
                table[i]=null;
                return;
            }
        }
    }
}