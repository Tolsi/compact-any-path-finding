import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Contains a [x1,y1,x2,y2] or [x,y] and a colour.
 * Refer to GridObjects.java for how the path array works.
 */
public class AAPFSnapshotItem {
    private static HashMap<AAPFSnapshotItem, AAPFSnapshotItem> cached;
    public final Integer[] path;
    public final Color color;
    
    private AAPFSnapshotItem(Integer[] path, Color color) {
        this.path = path;
        this.color = color;
    }
    
    public static AAPFSnapshotItem generate(Integer[] path, Color color) {
        return getCached(new AAPFSnapshotItem(path, color));
    }
    
    public static AAPFSnapshotItem generate(Integer[] path) {
        return getCached(new AAPFSnapshotItem(path, null));
    }
    
    public static void clearCached() {
        cached.clear();
        cached = null;
    }
    
    private static AAPFSnapshotItem getCached(AAPFSnapshotItem item) {
        if (cached == null) {
            cached = new HashMap<>();
        }
        AAPFSnapshotItem get = cached.get(item);
        if (get == null) {
            cached.put(item, item);
            return item;
        } else { 
            return get;
        }  
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + path[0];
        result = prime * result + Arrays.hashCode(path);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AAPFSnapshotItem other = (AAPFSnapshotItem) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (!Arrays.equals(path, other.path))
            return false;
        return true;
    }
}
