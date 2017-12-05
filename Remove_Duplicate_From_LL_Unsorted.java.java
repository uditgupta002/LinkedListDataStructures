//--------------------------Driver Code -----------------------//

/* package whatever; // don't place package name! */
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }


class Remove_Duplicate_From_LL_Unsorted
{
    Node head;  

	public void addToTheLast(Node node) 
	{

	  if (head == null) 
	  {
	   head = node;
	  } else 
	  {
	   Node temp = head;
	   while (temp.next != null)
		temp = temp.next;

	   temp.next = node;
	  }
	}

      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	/* Drier program to test above functions */
	public static void main(String args[])
    {
       
        
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		  
		 while(t>0)
         {
			int n = sc.nextInt();
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
		//llist.printList();	
        RemovingDuplicatesFromUnsortedList g = new RemovingDuplicatesFromUnsortedList();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList();
		
        t--;		
        }
    }
}

//--------------------------Driver Code ------------------------//

class RemovingDuplicatesFromUnsortedList
{
    Set<Integer> set = new HashSet<Integer>();
    
    Node removeDuplicates(Node head)
    {
        Node temp = head;
        Node prev = head;
        while(temp != null){
            if(!set.contains(temp.data)){
                set.add(temp.data);
                prev = temp;
                temp = temp.next;
            } else {
                prev.next = temp.next;
                temp = temp.next;
            }
        }
        return head;
    }
}
