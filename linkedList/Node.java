public class Node<E>
{
    E data;
    Node<E> nextElt;

    public Node(E val, Node<E> nextNode)
    {
        data = val;
        nextElt = nextNode;
    }

    public Node<E> next()
    {
        return nextElt;
    }

    public E value()
    {
        return data;
    }

    public void setNode(Node<E> nextNode)
    {
        nextElt = nextNode;
    }
}
