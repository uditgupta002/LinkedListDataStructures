class Node {
	int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class DetectLoop{    
    public static boolean detectLoop(Node head){
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr.next != null && fastPtr != slowPtr){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if(fastPtr.next != null)
                fastPtr = fastPtr.next;
        }
        return fastPtr.next != null;
    }
}
