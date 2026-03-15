import java.util.*;

public class RealtimeAnalytics{
    HashMap<String,Integer> views=new HashMap<>();
    HashMap<String,Set<String>> unique=new HashMap<>();
    HashMap<String,Integer> source=new HashMap<>();

    public void process(String url,String user,String src){
        views.put(url,views.getOrDefault(url,0)+1);
        unique.putIfAbsent(url,new HashSet<>());
        unique.get(url).add(user);
        source.put(src,source.getOrDefault(src,0)+1);
    }

    public List<String> topPages(){
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->views.get(a)-views.get(b));
        for(String k:views.keySet()){
            pq.offer(k);
            if(pq.size()>10) pq.poll();
        }
        return new ArrayList<>(pq);
    }
}