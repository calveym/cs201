public class SLL<E>
{
    Node<E> head;
    Node<E> tail;
    int count;

    Node<E> iterate(int amount)
    {
        Node<E> finger = head;
        for(int i = 0; i < amount; i++)
        {
            finger = finger.next();
        }
        return finger;
    }

    public boolean contains(E value)
    {
        Node<E> finger = head;
        for(int i = 0; i < count; i++)
        {
            if(finger.value() == value)
            {
                return true;
            }
            else
            {
                finger = finger.next();
            }
        }
        return false;
    }

    public int size()
    {
        return count;
    }

    public void addFirst(E val)
    {
        head = new Node<E>(val, head);
        count++;
    }

    public void add(int index, E val)
    {
        if(index > count) {return;}
        if(index == 0) {addFirst(val);} else
        {
            Node<E> preFinger = iterate(index - 1);
            Node<E> finger = iterate(index);

            // make prefinger point to new val, new val to finger
            preFinger.setNode(new Node(val, finger));
        }
    }

    public void addLast(E val)
    {
        Node<E> finger = iterate(count - 1);
        System.out.println("Finger val: " + finger.value());
        Node<E> newNode = new Node<E>(val, null);
        finger.setNode(newNode);
        count++;
    }

    public E remove(int index)
    {
        //Node<E> finger = iterate(index-1);
        //return finger;
        return null;
    }

    public E removeFirst()
    {
        Node<E> oldHead = head;
        head = head.next();
        count--;
        return oldHead.value();
    }

    public E removeLast()
    {
        Node<E> finger = head;
        while(finger.next() != null)
        {
            finger = finger.next();
        }
        E temp = finger.value();
        finger.setNode(null);
        count--;
        return temp;
    }

    public boolean remove(E value)
    {
        int count = 0;
        Node<E> finger = head;
        while(value != finger.next().value())
        {
            count++;
            if(count > this.count) {return false;}
            finger = finger.next();
        }
        if(finger.next().next() == null)
        // remove value is last value, so finger must point to null
        {
            finger.setNode(null);
        } else
        // remove value is not last value, so nextElt must be set
        {
            finger.setNode(finger.next().next());
        }
        // set to null and update next node refs
        return false;
    }

    public E get(int index)
    {
        if(index < count)
        {
            Node<E> finger = head;
            for(int i = 0; i < index; i++)
            {
                finger = finger.next();
            }
            return finger.value();
        }
        else {return null;}
    }

    public String toString()
    {
        Node<E> finger = head;
        String returnString = finger.value().toString();
        finger = finger.next();
        for(int i = 1; i < count; i++)
        {
            returnString = returnString + ", " + finger.value().toString();
            finger = finger.next();
        }
        return returnString;
    }
}
