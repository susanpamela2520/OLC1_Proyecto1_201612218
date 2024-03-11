
package funciones;

/**
 *
 * @author pamel
 */
public class Entradas {
    
    private String name;
    private String dir;
    private boolean exist;
    
    public Entradas(String name, String dir, boolean exist)
    {
        this.name = name;
        this.dir = dir;
        this.exist = exist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
    
}
