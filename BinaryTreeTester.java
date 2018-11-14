import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeTester
{
    public void test()
    {
        TreeDisplay display = new TreeDisplay();
        // to get the display to send back the values when it visits a node:
       // display.setTester(this);
        // test to see that the call back works
        TreeNode t = createBST(10, display);
        display.displayTree(t);
        MyTreeSet<Integer> fake = new MyTreeSet<Integer>();
    }

    /**
     * called by the display object to send back the node value
     * when a node is visited
     */
    public void sendValue(Object value)
    {
        System.out.println(value);
    }

    public TreeNode createBST(int n, TreeDisplay display)
    {
        TreeNode bst = new TreeNode((Comparable) (int) (Math.random() * 10));
        for (int i = 0; i < n - 1; i++)
        {
            BSTUtilities.insert(bst, (Comparable) (int) (Math.random() * 10), display);
        }
        return bst;
    }
}
