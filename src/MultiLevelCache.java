import java.util.*;

public class MultiLevelCache{
    LinkedHashMap<String,String> L1=new LinkedHashMap<>(10000,0.75f,true){
        protected boolean removeEldestEntry(Map.Entry e){
            return size()>10000;
        }
    };

    HashMap<String,String> L2=new HashMap<>();

    public String get(String id){
        if(L1.containsKey(id)) return L1.get(id);
        if(L2.containsKey(id)){
            String v=L2.get(id);
            L1.put(id,v);
            return v;
        }
        String db="VideoData";
        L2.put(id,db);
        return db;
    }
}