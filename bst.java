class node
{
  int val;
  node next;
  public node(int val)
  {
    this.val = val;
    this.next = null;
  }
}
class tree_node
{
        int val;
        tree_node l,r;
        tree_node(int val) 
        {
            this.val = val;
            this.l = this.r = null;
        }
}
    
public class bst
{
  public static void sort(node head) 
  {
    if (head == null || head.next == null) 
    {
      return;
    }
    boolean swap;
    do 
    {
     swap = false;
     node current = head;
     while (current.next != null) 
     {
       if (current.val > current.next.val) 
       {
        int t = current.val;
        current.val = current.next.val;
        current.next.val = t;
        swap = true;
       }
        current = current.next;
     }
  } while (swap);
}
        
private static node middle(node head) 
{
  node slow = head, fast = head, prev = null;
  while (fast != null && fast.next != null) 
  {
    prev = slow;
    slow = slow.next;
    fast = fast.next.next;
  }
  if (prev != null) 
  {
    prev.next = null;
  }
  return slow;
}

public static tree_node list_to_bst(node head) 
{
    if (head == null) 
    {
      return null;
    }
    node mid = middle(head);
    tree_node root = new tree_node(mid.val);
            
    if (head == mid) 
    {
      return root;
    }
    root.l = list_to_bst(head);
    root.r = list_to_bst(mid.next);
            
    return root;
}

public static void preorder(tree_node root) 
{
    if (root != null) 
   {
      System.out.println(root.val + " ");
      preorder(root.l);
      preorder(root.r);
   } 
}
        
public static void main(String[] args) 
{
    node head = new node(2);
    head.next = new node(4);
    head.next.next = new node(1);
    head.next.next.next = new node(3);
    head.next.next.next.next = new node(5);
    head.next.next.next.next.next = new node(7);
            
    sort(head);
    tree_node root = list_to_bst(head);
    System.out.println("Preorder traversal:");
    preorder(root);
  }
}
