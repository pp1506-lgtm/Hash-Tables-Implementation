import java.util.*;

class Bucket{
    int tokens;
    long last;
    Bucket(int t){
        tokens=t;
        last=System.currentTimeMillis();
    }
}

public class RateLimiter{
    HashMap<String,Bucket> map=new HashMap<>();
    int limit=1000;

    public boolean allow(String client){
        map.putIfAbsent(client,new Bucket(limit));
        Bucket b=map.get(client);
        long now=System.currentTimeMillis();
        if(now-b.last>3600000){
            b.tokens=limit;
            b.last=now;
        }
        if(b.tokens>0){
            b.tokens--;
            return true;
        }
        return false;
    }
}