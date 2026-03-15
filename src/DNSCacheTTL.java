import java.util.*;

class DNSEntry{
    String ip;
    long expiry;
    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl;
    }
}

public class DNSCacheTTL{
    HashMap<String,DNSEntry> cache=new HashMap<>();
    int hit=0,miss=0;

    public String resolve(String domain){
        if(cache.containsKey(domain)){
            DNSEntry e=cache.get(domain);
            if(System.currentTimeMillis()<e.expiry){
                hit++;
                return e.ip;
            }
            cache.remove(domain);
        }
        miss++;
        String ip="192.168."+new Random().nextInt(255)+"."+new Random().nextInt(255);
        cache.put(domain,new DNSEntry(ip,300000));
        return ip;
    }

    public double hitRate(){
        return hit*1.0/(hit+miss);
    }
}