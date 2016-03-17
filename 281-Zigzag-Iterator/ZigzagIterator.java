public class ZigzagIterator {
    private Iterator<Integer> main;
    private Iterator<Integer> alt;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        main = v1.iterator();
        alt = v2.iterator();
    }

    public int next() {
        Iterator<Integer> temp = main;
        main = alt;
        alt = temp;
        return temp.next();
    }

    public boolean hasNext() {
        if (main.hasNext()) return true;
        if (alt.hasNext()) {
            Iterator<Integer> temp = main;
            main = alt;
            alt = temp;
            return true;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */