import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Friend {
    private Collection<Friend> friends;
    private String email;
    public HashSet<String> friendsEmails;
    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
        friendsEmails=new HashSet<String>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
        this.friendsEmails.add(friend.getEmail());
        friend.friendsEmails.add(this.getEmail());
        this.friendsEmails.addAll(friend.friendsEmails);
        friend.friendsEmails.clear();
        
        friend.friendsEmails=this.friendsEmails;
    }

    public boolean canBeConnected(Friend friend) {
        return this.friendsEmails.contains(friend.getEmail());
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}