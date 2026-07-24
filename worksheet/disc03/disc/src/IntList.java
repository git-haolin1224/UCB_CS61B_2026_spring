class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public static IntList list(int... values) {
        if (values.length == 0) {
            return null;
        }

        IntList L = new IntList(values[0], null);
        IntList current = L;

        for (int i = 1; i < values.length; i++) {
            current.rest = new IntList(values[i], null);
            current = current.rest;
        }

        return L;
    }

    public static void main(String[] args) {
        IntList L1 = IntList.list(1, 2, 3);
        IntList L2 = new IntList(4, L1.rest);

        L2.rest.first = 13;
        L1.rest.rest.rest = L2;

        IntList L3 = IntList.list(50);
        L2.rest.rest = L3;
    }
}

