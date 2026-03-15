import java.util.*;

public class PlagiarismDetector{
    HashMap<String,Set<String>> map=new HashMap<>();
    int n=5;

    public void addDocument(String id,String text){
        String[] words=text.split(" ");
        for(int i=0;i<=words.length-n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++) sb.append(words[i+j]).append(" ");
            String gram=sb.toString();
            map.putIfAbsent(gram,new HashSet<>());
            map.get(gram).add(id);
        }
    }

    public int compare(String text){
        String[] words=text.split(" ");
        int match=0;
        for(int i=0;i<=words.length-n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++) sb.append(words[i+j]).append(" ");
            if(map.containsKey(sb.toString())) match++;
        }
        return match;
    }
}