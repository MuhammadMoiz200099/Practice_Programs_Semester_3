package Others;

public class Node {
	 public Object anElement;
	 public Node less;
	 public Node greater;
	 
	 public Node(Object theElement) {
	    this(theElement, null, null); 
         }

	 public Node(Object currentElement, Node lessSide, Node greaterSide) {
	  anElement = currentElement;
	  this.less = lessSide;
	  this.greater = greaterSide;
	 }
}
