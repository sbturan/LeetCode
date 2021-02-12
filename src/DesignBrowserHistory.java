import java.util.ArrayList;

public class DesignBrowserHistory {
    class BrowserHistory {

        ArrayList<String> list;
        int index=0;
        public BrowserHistory(String homepage) {
            list=new ArrayList<>();
            list.add(homepage);
        }

        public void visit(String url) {
            list=new ArrayList<>(list.subList(0,index+1));
            list.add(url);
            index++;
        }

        public String back(int steps) {
            index=Math.max(0,index-steps);
            return list.get(index);
        }

        public String forward(int steps) {
            index=Math.min(list.size()-1,index+steps);
            return list.get(index);
        }
    }
}
