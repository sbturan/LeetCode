
public class QuadTreeIntersection {
	public Node intersect(Node quadTree1, Node quadTree2) {
         if(quadTree1==null||quadTree2==null) {
        	 return null;
         }
         if(quadTree1.isLeaf||quadTree2.isLeaf) {
        	 if(quadTree1.isLeaf&&quadTree2.isLeaf) {
        		 Node leaf=new Node();
        		 leaf.isLeaf=true;
        		 leaf.val=quadTree1.val||quadTree2.val;
        		 return leaf;
        	 }
        	 if((quadTree1.isLeaf&&quadTree1.val)||(quadTree2.isLeaf&&quadTree2.val)) {
        		 Node leaf=new Node();
        		 leaf.val=true;
        		 leaf.isLeaf=true;
        		 return leaf;
        	 }
         }
         Node node=new Node();
         node.bottomLeft=intersect(
        		 quadTree1.bottomLeft==null?quadTree1:quadTree1.bottomLeft, 
        				 quadTree2.bottomLeft==null?quadTree2:quadTree2.bottomLeft);
         node.bottomRight=intersect(
        		 quadTree1.bottomRight==null?quadTree1:quadTree1.bottomRight, 
        				 quadTree2.bottomRight==null?quadTree2:quadTree2.bottomRight);
         node.topLeft=intersect(
        		 quadTree1.topLeft==null?quadTree1:quadTree1.topLeft, 
        				 quadTree2.topLeft==null?quadTree2:quadTree2.topLeft);
         node.topRight=intersect(
        		 quadTree1.topRight==null?quadTree1:quadTree1.topRight, 
        				 quadTree2.topRight==null?quadTree2:quadTree2.topRight);
         
         if(node.bottomLeft.isLeaf&&node.bottomRight.isLeaf&&
        		 node.topLeft.isLeaf&&node.topRight.isLeaf&&
        		 node.bottomLeft.val==node.bottomRight.val&&
        		 node.bottomLeft.val==node.topLeft.val&&
        		 node.bottomLeft.val==node.topRight.val) {
        	 node.val=node.bottomLeft.val;
        	 node.isLeaf=true;
         }
         return node;
	}
}
