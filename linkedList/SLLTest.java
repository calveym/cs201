public class SLLTest
{
    public static void main(String[] args)
    {
        SLL<Integer> list= new SLL<Integer>();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);

        log("List created: " + list.toString());
        log("Getting first value: " + list.get(0));
        log("Getting last value: " + list.get(2));

        log("Removing last: " + list.removeLast());
        log("List now: " + list.toString());
        list.addFirst(1);
        list.addFirst(0);
        log("List now: " + list.toString());

        log("Checking if contains 2: " + list.contains(2));

        list.addLast(15);
        log("Adding 15 to last: " + list.toString());
    }

    public static void log(String s)
    {
        System.out.println(s);
    }
}
