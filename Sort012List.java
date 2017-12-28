class Node {
 int value;
  Node next;
  Node(int value) {
   this.value = value;
  }
}

class Sort012List
{
	void linksort(Node head){
		Node zeroes = null;
		Node zeroPtr = zeroes;
		Node ones = null;
		Node onesPtr = ones;
		Node twos = null;
		Node twosPtr = twos;
		Node current = head;
		while(current != null){
			if(current.value == 0){
				if(zeroes == null){

					zeroes = current;
					zeroPtr = zeroes;
				} else {
					zeroPtr.next = current;
					zeroPtr = zeroPtr.next;
				}
				//System.out.println("Added "+current.value+" to zero list");
			} else if(current.value == 1){
				if(ones == null){
					ones = current;
					onesPtr = ones;
				} else {
					onesPtr.next = current;
					onesPtr = onesPtr.next;
				}
				//System.out.println("Added "+current.value+" to ones list");
			} else if(current.value == 2){
				if(twos == null){
					twos = current;
					twosPtr = twos;
				} else {
					twosPtr.next = current;
					twosPtr = twosPtr.next;
				}
				//System.out.println("Added "+current.value+" to twos list");
			}
			//System.out.println("Current is "+current.value);
			current = current.next;
		}

			   if(zeroes != null){
				   head = zeroes;
				   if(onesPtr != null){
					   zeroPtr.next = onesPtr;
					   onesPtr.next = twos;
				   } else {
					   zeroPtr.next= twos;
				   }
			   } else if(ones != null){
				   head = ones;
				   onesPtr.next = twos;
			   } else {
				   head = twos;
			   }

			   if(twos != null){
				   twosPtr.next = null;
			   } else if(ones != null) {
				   onesPtr.next = null;
			   } else {
				   zeroPtr.next = null;
			   }

			   current = head;
			   while(current != null){
				//System.out.println(current.value);
				current = current.next;
			   }
	}  
}
