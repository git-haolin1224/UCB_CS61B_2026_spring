import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question4 {
    Map<Integer, List<Integer>> buildLessThanMap(List<Integer> L){
        Map<Integer, List<Integer>> result = new HashMap<>();
        for(Integer x : L){
            if(!result.containsKey(x)){
                result.put(x, new ArrayList<>());
            }
            for(Integer y: L){
                if(y < x){
                    if(!result.get(x).contains(y)){
                        result.get(x).add(y);
                    }
                }
            }
        }
        return result;

    }
}
