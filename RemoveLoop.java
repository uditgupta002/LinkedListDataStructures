class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
class RemoveLoop{
	boolean removeTheLoop(Node node) {
        
        if(node == null || node.next == null)
            return false;
        
        Node repeatNode = detectLoop(node);
        if(repeatNode == null)
            return false;
        
        Node start = node;
        Node prev = repeatNode;
        while(repeatNode != start){
            prev = repeatNode;
            repeatNode = repeatNode.next;
            start = start.next;
        }
        
        prev.next = null;
        return true;
    }
    
    public static Node detectLoop(Node head){
        
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr.next != null && fastPtr != slowPtr){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if(fastPtr.next != null)
                fastPtr = fastPtr.next;
        }
        
        if(fastPtr.next == null)
            return null;
        else    
            return fastPtr;
        
    }
    
}
