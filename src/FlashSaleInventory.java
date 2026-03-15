import java.util.*;

public class FlashSaleInventory {
    private HashMap<String,Integer> stock=new HashMap<>();
    private HashMap<String,Queue<Integer>> waitlist=new HashMap<>();

    public void addProduct(String id,int count){
        stock.put(id,count);
        waitlist.put(id,new LinkedList<>());
    }

    public int checkStock(String id){
        return stock.getOrDefault(id,0);
    }

    public String purchase(String id,int userId){
        int s=stock.getOrDefault(id,0);
        if(s>0){
            stock.put(id,s-1);
            return "Success";
        }
        waitlist.get(id).offer(userId);
        return "Waiting "+waitlist.get(id).size();
    }
}