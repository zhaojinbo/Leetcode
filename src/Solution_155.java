import java.util.LinkedList;
import java.util.TreeMap;

class MinStack {
    private LinkedList<Integer> list;
    //用来将栈中的值存放起来，以值作为key，相同值的数量作为value。利用TreeMap存入时排序的特点，直接取第一个key，就是值最小的key
    private TreeMap<Integer, Integer> integerTreeMap;

    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
        integerTreeMap = new TreeMap<>();
    }

    public void push(int x) {
        if (integerTreeMap.containsKey(x)){
            Integer num = integerTreeMap.get(x);
            num++;
            integerTreeMap.put(x,num);
        }else{
            integerTreeMap.put(x,1);
        }
        list.addFirst(x);
    }

    public void pop() {
        Integer key = list.pop();
        Integer num = integerTreeMap.get(key);
        if (num==1)
            integerTreeMap.remove(key);
        else{
            num--;
            integerTreeMap.put(key,num);
        }
    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        return integerTreeMap.firstKey();
    }
}

public class Solution_155{
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());    //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());    //--> 返回 -2.
    }
}
