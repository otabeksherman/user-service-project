package App.service;

import java.util.HashMap;

public class TokenService {
    private static HashMap<Long, Long> tokenToUserIdMap = new HashMap<>();

    void setSession(long token, long id) {
        tokenToUserIdMap.put(token, id);
    }

    boolean tokenIsValid(long token, long id) {
        return tokenToUserIdMap.get(token) == id;
    }

    void removeSession(long token) {
        tokenToUserIdMap.remove(token);
    }
}
