public class question5 {
    public static int[] filterPositive(List<Integer> L){
        List<Integer> a = new ArrayList<>();
        for(int i=0; i<L.size(); i++){
            if(L.get(i) > 0){
                a.add(L.get(i));
            }
        }
        int[] result = new int[a.size()];
        for(int i = 0; i < a.size(); i++){
            result[i] = a.get(i);
        }
        return result;
    }
}

