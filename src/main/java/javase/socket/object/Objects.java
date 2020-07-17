package javase.socket.object;

import java.io.Serializable;

public class Objects implements Serializable {
    private static final long serialVersionUID = 9210117849421230696L;

    public Objects() {}

    public Objects(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String name;
    public int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
