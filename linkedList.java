/*Note: hardcoded an intersection point for the lists. check line no:125.*/
public class linkedList {
	node start;
	public static class node{
		int data;
		node next;

		public node(int data)
		{
			this.data=data;
		}
	}
	public static void insert(linkedList list , int val )
	{
		node n = new node(val);
		n.next = null;

		if(list.start == null)
		{
			list.start = n;
		}
		else
		{
			node tail = list.start;	
			while(tail.next != null)
			{
				tail= tail.next;
			}
			tail.next = n;
		}
	}
	public static void printList(linkedList list)
	{
		node n= list.start;
		while(n != null)
		{
			System.out.print(n.data+"->");
			n=n.next;
		}
		System.out.println("null");
	}

	public static void findIntersectionNode(linkedList firstList,linkedList secondList )
	{
		node firstListCurNode = firstList.start;
		node secondListCurNode = secondList.start;
		int firstListLength=0,secondListLength=0;
		int diff=0,ctr=1,point=0;

		//finding length of both lists
		while(firstListCurNode != null)
		{
			firstListCurNode=firstListCurNode.next;
			firstListLength++;
		}
		while(secondListCurNode != null)
		{
			secondListCurNode=secondListCurNode.next;
			secondListLength++;
		}


		firstListCurNode = firstList.start;
		secondListCurNode = secondList.start;
		//finding difference of lengths and reaching to the same level of node 
		if(firstListLength >= secondListLength)
		{
			diff=firstListLength-secondListLength;
			while(ctr<=diff)
			{
				firstListCurNode=firstListCurNode.next;
				ctr++;
			}
		}
		else
		{
			diff=secondListLength-firstListLength;
			while(ctr<=diff)
			{
				secondListCurNode=secondListCurNode.next;
				ctr++;
			}
		}

		//finding the intersection node
		while(firstListCurNode != null)
		{
			if(firstListCurNode.next == secondListCurNode.next)
			{
				break;
			}
			else{
				point++;
				firstListCurNode=firstListCurNode.next;
				secondListCurNode= secondListCurNode.next;
			}

		}

		//display the insected node's data
		System.out.print("Intersected node data = "+firstListCurNode.next.data);

	}

	public static void main(String[] args) {
		int ctr=1;
		linkedList firstList = new linkedList();
		firstList.insert(firstList,1);
		firstList.insert(firstList,2);
		firstList.insert(firstList,3);
		firstList.insert(firstList,4);
		firstList.insert(firstList,5);

		linkedList secondList = new linkedList();
		secondList.insert(secondList,10);
		secondList.insert(secondList,11);

		/*intersection of two nodes at  4th position*/
		node n=secondList.start;
		while(n.next!=null)
		{
			n= n.next;
		}
		node n1=firstList.start;
		while(ctr < 4 )
		{
			n1= n1.next;
			ctr++;
		}
		n.next= n1;


		printList(firstList);
		printList(secondList);

		findIntersectionNode(firstList,secondList);

	}


}
