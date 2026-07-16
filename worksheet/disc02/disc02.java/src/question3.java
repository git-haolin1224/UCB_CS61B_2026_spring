public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
    List<Integer> common = new ArrayList<>();
    for(Integer l1 : L1){
        if (L2.contains(l1) && !common.contains(l1)){
            common.add(l1);
        }
    }
    return common;
}

public static void capitalize(List<String> L){
    List<String> s = new ArrayList<>();
    for (int i = 0; i < L.size(); i ++){
        L.set(i, L.get(i).toUpperCase());
    }
}

void main() {
}
