class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}
class PalindromeCheck
{
    boolean isPalindrome(Node head) 
    {
        if(head == null || head.next == null)
            return true;
            
        if(head.next.next == null){
            return head.data == head.next.data;
        }
        
        int count = 1;
        Node mid = null;
        Node slow=head;
        Node fast=head;
        while(fast.next != null){
           slow = slow.next;
           fast = fast.next;
           count++;
           if(fast != null && fast.next != null) {
               fast = fast.next;
               count++;
           }
        }
        //System.out.println("count is "+count);
       mid = slow;
       //System.out.println("Middle element is "+mid.data);
       
       Node current = mid.next;
       Node prev = mid;
       Node tempNext;
       
       while(current != null){
            tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
       }
       //System.out.println("Last node is "+prev.data);
       //System.out.println("Count is "+count);
       Node start = head;
       Node end = prev;
      
       boolean palindrom = true;
       int counter = count/2;
       while(counter > 0){
           //System.out.println("Currently checking "+start.data +" and "+prev.data);
           if(start.data != prev.data){
               palindrom = false;
               break;
           }
           start = start.next;
           prev = prev.next;
           counter--;
       }

        
       current = end.next;
       prev = end;
       prev.next = null;
       /*
       while(prev != mid){
            tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
       }
       */
       return palindrom;
       
    }
    
}
