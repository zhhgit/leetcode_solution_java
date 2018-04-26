1.用Deque<Character> stack == new LinkedList<>() 代替stack<Character>

2.注意要保证stack中有元素，否则stack.peek()为null，null再与'(','[','{'在用==比较时，会抛异常！！