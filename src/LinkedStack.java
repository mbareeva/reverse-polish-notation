
public class LinkedStack <T> implements Stack<T> {

	private Node <T> top;
	private int size;

/*
 * Contructor
 */
public LinkedStack() {
	top = null;
	size = 0;
}

@Override
public boolean isEmpty() {
	return top == null;
}

@Override
public void pop() throws UnderflowException {
	if (size == 0){
        throw new UnderflowException();
    }
	
	T currentNode = top.getData();
	top = top.getNext();
	size--;
}

@Override
public void push(T element) throws OverflowException {
	Node <T> newNode = new Node<>(element, top);
	top = newNode;
	size++;
}

@Override
public T top() throws UnderflowException {
	 if(isEmpty()){
         throw new UnderflowException();
     }
	 
	T currentNode = top.getData();
		return currentNode;
	}

public void display()
{
    System.out.print("\nStack = ");
    if (size == 0) 
    {
        System.out.print("Empty\n");
        return;
    }
    Node<T> newN = top;
    while (newN != null)
    {
        System.out.print(newN.getData()+" ");
        newN = newN.getNext();
    }
    System.out.println();        
}
}

