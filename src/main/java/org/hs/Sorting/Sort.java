package org.hs.Sorting;

import java.util.ArrayList;

public interface Sort {
    /**
     *
     * @return A list of intermediate arrays of elements representing each stage in the sorting process.
     */
    public ArrayList<int[]> incremental_sort();

    /**
     *
     * @return A sorted list of the elements provided in the list parameter.
     */
    public int[] final_sort();
}
