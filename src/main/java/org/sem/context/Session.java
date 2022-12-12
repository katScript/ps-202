package org.sem.context;

import java.util.HashMap;

public class Session {
    HashMap<String, Object> data;

    public Session() {
        data = new HashMap<>();
    }

    public void setData(String key, Object data) {
        this.data.put(key, data);
    }

    public void removeData(String key) {
        this.data.remove(key);
    }

    public Object getData(String key) {
        return this.data.get(key);
    }
}
