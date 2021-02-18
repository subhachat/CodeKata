package poc.basic;

public class CustomNode<T> {
    private T data;
    private int index;
    private CustomNode<T> nextNode;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CustomNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(CustomNode<T> nextNode) {
        this.nextNode = nextNode;
        if(nextNode != null) {
            nextNode.index = this.index + 1; //increment next Node's index
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if ((obj == null) || (obj.getClass() != this.getClass())) {
            //"instanceof" checks for subclass as well, not exact class type always
            return false;
        }
        CustomNode e = (CustomNode) obj;
        return (this.index == e.index)
                && (String.valueOf(this.data).equals(String.valueOf(e.data)))
                && (this.nextNode == e.nextNode);
    }

    @Override
    public int hashCode() {
        return this.index;
    }
}
