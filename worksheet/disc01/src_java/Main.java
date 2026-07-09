static int maxMinDiff(List<Integer> L){
    int max;
    int min;
    int size = L.size();
    max = L.get(0);
    min = L.get(0);
    for(int i=0; i < size; i++ ){
        if(L.get(i)<min){
            min = L.get(i);
        }
        if(L.get(i)>max){
            max = L.get(i);
        }
    }
    return max - min;
}

public static Map<String, List<String>> listOfFollowers(List<String> x) {
    Map<String, List<String>> result = new TreeMap<>();
    for(int i=0; i< x.size()-1; i++){
        String currentword = x.get(i);
        String nextword = x.get(i+1);
        if(!result.containsKey(currentword)){
            result.put(currentword, new ArrayList<>());
        }
        result.get(currentword).add(nextword);

    }
    return result;
}





void main() {
}