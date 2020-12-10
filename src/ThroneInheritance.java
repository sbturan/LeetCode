import java.util.*;

public class ThroneInheritance {
    public static void main(String[] args) {
        ThroneInheritance t=new ThroneInheritance("king");

        t.birth("king", "clyde"); // order: king > andy > bob
        System.out.println(t.getInheritanceOrder());
        t.birth("clyde", "sahnnon"); // order: king > andy > bob > catherine
        System.out.println(t.getInheritanceOrder());
        t.birth("sahnnon", "scott"); // order: king > andy > matthew > bob > catherine
        System.out.println(t.getInheritanceOrder());
        t.birth("king", "keith"); // order: king > andy
        System.out.println(t.getInheritanceOrder());
        t.birth("clyde", "joseph"); // order: king > andy
        System.out.println(t.getInheritanceOrder());
//        t.birth("bob", "keith"); // order: king > andy > matthew > bob > alex > catherine
//        System.out.println(t.getInheritanceOrder());
//        t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
//        System.out.println(t.getInheritanceOrder());
//        t.death("king"); // order: king > andy > matthew > bob > alex > asha > catherine
//        System.out.println(t.getInheritanceOrder());
    }
    class Node{
        String name;
        Node next;
        Node previous;
    }
    HashMap<String,String> parents;
    String kingName;
    HashMap<String,Node> map;
    public ThroneInheritance(String kingName) {
        this.kingName=kingName;
        this.parents=new HashMap<>();
        map=new HashMap<>();
        Node king=new Node();
        king.name=kingName;
        map.put(kingName,king);
    }

    public void birth(String parentName, String childName) {
        parents.put(childName,parentName);
        Node n=new Node();
        n.name=childName;
        map.put(n.name,n);
        Node parent = map.get(parentName);
        if(parent!=null){
            while(parent.next!=null && parents.get(parent.next.name).equals(parentName)){
                parent=parent.next;
            }
            n.next=parent.next;
            if(n.next!=null)
                n.next.previous=n;
            parent.next=n;
            n.previous=parent;
        }
    }

    public void death(String name) {
        if(name.equals(kingName))
            this.kingName=map.get(name).next.name;
        Node death = map.get(name);
        if(death.previous!=null)
            death.previous.next=death.next;
        if(death.next!=null)
            death.next.previous=death.previous;

    }
    public List<String> getInheritanceOrder() {
        List<String> result= new ArrayList<>();
        Node node = map.get(kingName);
        while(node!=null){
            result.add(node.name);
            node=node.next;
        }
        return result;
    }
}
