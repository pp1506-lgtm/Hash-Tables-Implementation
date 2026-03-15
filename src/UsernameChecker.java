import java.util.*;

public class UsernameChecker {
    private HashMap<String,Integer> users=new HashMap<>();
    private HashMap<String,Integer> attempts=new HashMap<>();

    public boolean checkAvailability(String username){
        attempts.put(username,attempts.getOrDefault(username,0)+1);
        return !users.containsKey(username);
    }

    public void register(String username,int userId){
        users.put(username,userId);
    }

    public List<String> suggest(String username){
        List<String> list=new ArrayList<>();
        for(int i=1;i<=3;i++){
            String s=username+i;
            if(!users.containsKey(s)) list.add(s);
        }
        String alt=username.replace("_",".");
        if(!users.containsKey(alt)) list.add(alt);
        return list;
    }

    public String mostAttempted(){
        String res="";
        int max=0;
        for(String k:attempts.keySet()){
            if(attempts.get(k)>max){
                max=attempts.get(k);
                res=k;
            }
        }
        return res;
    }
}