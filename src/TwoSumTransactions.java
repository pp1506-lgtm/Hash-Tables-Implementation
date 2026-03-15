import java.util.*;

class Transaction{
    int id,amount;
    Transaction(int id,int amount){
        this.id=id;
        this.amount=amount;
    }
}

public class TwoSumTransactions{
    public List<int[]> twoSum(List<Transaction> list,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        List<int[]> res=new ArrayList<>();
        for(Transaction t:list){
            int comp=target-t.amount;
            if(map.containsKey(comp)){
                res.add(new int[]{map.get(comp),t.id});
            }
            map.put(t.amount,t.id);
        }
        return res;
    }
}