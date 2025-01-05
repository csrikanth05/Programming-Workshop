import java.util.Stack;
class node
{
  int val;
  node prev;
  node next;
  node child;
  
  public node(int val)
  {
    this.val = val;
  }
}
  
public class flatten
{
  public node flatten(node h)
  {
    if (h == null)
      return h;
      
    node dummy = new node(0);
    dummy.next = h;
    h.prev = dummy;
    
    node current = h;
    Stack<node> s = new Stack<>();
    
    while(current != null)
    {
      if(current.child != null)
      {
        if(current.next != null)
        {
          s.push(current.next);
        }
        
        current.next = current.child;
        current.child.prev = current;
        current.child = null;
      }
      
      if(current.next == null && !s.isEmpty())
      {
       current.next = s.pop();
       current.next.prev = current;
      }
      
      current = current.next;
    }
    
    dummy.next.prev = null;
    return dummy.next;
  }
  
  public static void printList(node head) {
        node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
  }
    
  public static void main(String[] args)
  {
        node head = new node(1);
        node node2 = new node(2);
        node node3 = new node(3);
        node node4 = new node(4);
        node node5 = new node(5);
        node node6 = new node(6);
        node child1 = new node(7);
        node child2 = new node(8);
        node child3 = new node(9);
        node child4 = new node(10);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        
        node2.child = child1;
        node4.child = child2;
        node5.child = child3;
        child3.next = child4;
        child4.prev = child3;

        System.out.println("Original list:");
        printList(head);
        
        flatten f = new flatten();
        node fh = f.flatten(head);
        
        System.out.println("Flattened List: ");
        printList(fh);
   }

} 
