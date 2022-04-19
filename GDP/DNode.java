class DNode {
    private DNode prev;
    private int value;
    private DNode next;

    public DNode(DNode prev, int value, DNode next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
}