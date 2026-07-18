public class DesignATextEditor {
    public static void main(String[] args) {
        TextEditor edit=new DesignATextEditor().new TextEditor();
        edit.addText("leetcode");
        edit.deleteText(4);
        edit.addText("practice");
        System.out.println(edit.cursorRight(3));
    }

    class TextEditor {
        class Node {
            char val;
            Node prev;
            Node next;
        }

        Node cursor;
        public TextEditor() {
        }

        public void addText(String text) {
            Node head=new Node();
            Node cur=head;
            for(char c:text.toCharArray()){
                cur.val=c;
                cur.next=new Node();
                cur.next.prev=cur;
                cur=cur.next;
            }
            if(cursor!=null&&cursor.prev!=null){
                cursor.prev.next=cur;
            }
            cursor=cur.prev;

        }

        public int deleteText(int k) {
            if(cursor==null)
                return 0;
            Node next=cursor.next;
            int count=0;
            Node cur=cursor;
            while(cur!=null&&count<k){
                cur=cur.prev;
                count++;
            }
            if(cur!=null){
                cur.next=cursor.next;
            }
            cursor=cur;
            return count;

        }

        public String cursorLeft(int k) {
            if(cursor==null){
                return "";
            }
            int count=0;
            while(cursor!=null&&count<k){
                cursor=cursor.prev;
                count++;
            }
            if(cursor==null){
                return "";
            }

            return getLeft10();
        }
        private String getLeft10(){
            int temp=10;
            StringBuilder sb=new StringBuilder();
            Node cur=cursor.prev;
            while(cur!=null && temp>0){
                sb.append(cur.val);
                cur=cur.prev;
                temp--;
            }
            return sb.reverse().toString();
        }

        public String cursorRight(int k) {
            if(cursor==null){
                return "";
            }
            int count=0;
            while(count<k&&cursor.next!=null){
                count++;
                cursor=cursor.next;
            }
            return getLeft10();
        }
    }

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
}
