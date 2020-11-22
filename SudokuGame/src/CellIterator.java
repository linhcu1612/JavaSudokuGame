import java.util.*;

public class CellIterator implements Iterator<Cell>{

    Cell[][] cells;
    int outer;
    int inner;
    boolean runOut;

    public CellIterator(Cell[][] data) {
        this.cells = data;
        outer = 0;
        inner = 0;
        runOut = false;
    }

    @Override
    public boolean hasNext() {
        return !runOut;
    }

    @Override
    public Cell next() {
        Cell ret = cells[outer][inner];
        inner++;
        if (inner >= cells[outer].length ) {
            inner = 0;
            outer++;
            if (outer >= cells.length) {
                runOut = true;
            }
        }

        return ret;
    }
    
}
