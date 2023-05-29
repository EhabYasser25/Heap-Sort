package CLI;

import Sorting.*;

import java.util.ArrayList;

public interface ICommand {
    long execute(Sort_Array sort, OutputFormat format);
    ArrayList<int[]> getResult();
}
