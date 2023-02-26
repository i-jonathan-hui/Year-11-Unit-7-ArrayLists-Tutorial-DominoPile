public class Domino {
    private int top;
    private int bottom;

    public Domino() {
        top = 0;
        bottom = 0;
    }

    public Domino(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public int getTop() { return top; }
    public int getBottom() { return bottom; }
    public void setTop(int top) { this.top = top; }
    public void setBottom(int bottom) { this.bottom = bottom; }

    public String toString() { return top + "/" + bottom; }
    public void flip() {
        int temp = top;
        top = bottom;
        bottom = temp;
    }
    public void settle() {
        if (top > bottom) flip();
    }

    public int compareTo(Domino other) {
        settle();
        other.settle();
        if (top < other.getTop()) return -1;
        if (top > other.getTop()) return 1;
        if (top == other.getTop()) {
            if (bottom == other.getBottom()) return 0;
            if (bottom < other.getBottom()) return -1;
            if (bottom > other.getBottom()) return 1;
        }
        return 0;
    }

    public int compareToWeight(Domino other) {
        int total1 = top + bottom;
        int total2 = other.getTop() + other.getBottom();
        if (total1 < total2) return -1;
        if (total1 > total2) return 1;
        if (total1 == total2) return 0;
//        else { return 0; }
        return 0;
    }

    public boolean canConnect(Domino other) {
        if (top == other.getTop()) return true;
        if (top == other.getBottom()) return true;
        if (bottom == other.getTop()) return true;
        if (bottom == other.getBottom()) return true;
        return false;
    }

}
