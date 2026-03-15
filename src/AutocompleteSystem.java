import java.util.*;

public class AutocompleteSystem{
    HashMap<String,Integer> freq=new HashMap<>();

    public void addQuery(String q){
        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    public List<String> search(String prefix){
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->freq.get(a)-freq.get(b));
        for(String k:freq.keySet()){
            if(k.startsWith(prefix)){
                pq.offer(k);
                if(pq.size()>10) pq.poll();
            }
        }
        return new ArrayList<>(pq);
    }
}