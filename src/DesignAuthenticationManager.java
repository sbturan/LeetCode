import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class DesignAuthenticationManager {
    class AuthenticationManager {
        HashMap<String, Integer> map;
        LinkedList<Integer> expires;
        int ttl;

        public AuthenticationManager(int timeToLive) {
            map = new HashMap<>();
            expires = new LinkedList<>();
            ttl = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + ttl);
            expires.add(currentTime + ttl);
        }

        public void renew(String tokenId, int currentTime) {
            if (map.containsKey(tokenId) && map.get(tokenId) <= currentTime) {
                expires.remove(Collections.binarySearch(expires,map.get(tokenId)));
                map.put(tokenId, currentTime + ttl);
                expires.add(currentTime + ttl);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int r=Collections.binarySearch(expires,currentTime);
            if(r<0){
                r=-r-1;
            }else{
                r++;
            }
            return expires.size() - r;
        }
    }

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
}
