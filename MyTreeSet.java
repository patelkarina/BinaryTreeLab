import java.util.*;
/**
 * MyTreeSet contains a tree and allows user to change tree.
 * @author Karina Patel 
 * @version November 20 2016 
 * 
 * @param <E> tree contains type <E> values
 */
public class MyTreeSet<E>
{
    private TreeNode root;
    private int size;
    private TreeDisplay display;

     /**
     * Constructor for MyTreeSet
     */
    public MyTreeSet()
    {
        root = null;
        size = 0;
        display = new TreeDisplay();
        display.displayTree(root);
        //wait 1 millisecond when visiting a node
        display.setDelay(1); // originally 1
    }

     /**
     * Returns size of the tree rooted at root.
     * 
     * @return the size of the tree rooted at root
     */
    public int size()
    {
        return size;
    }

     /**
     * Checks if tree rooted at root contains object
     * 
     * @param obj the object to be checked
     * @return true if tree contains object, false otherwise
     */
    public boolean contains(Object obj)
    {
        if (BSTUtilities.contains(root, (Comparable) obj, display))
        {
            return true;
        }
        return false;
    }

    // if obj is not present in this set, adds obj and
    // returns true; otherwise returns false
     /**
     * Adds object to the tree
     * 
     * @param obj the object to be added
     * @return true if object added, false otherwise
     */
    public boolean add(E obj)
    {
       if (BSTUtilities.contains(root, (Comparable) obj, display))
       {
           return false;
        }
       TreeNode n = BSTUtilities.insert(root, (Comparable) obj, display);
       if (root==null)
       {
           root = n;
        }
        size++;
        display.displayTree(root);
        return true;
    }

    // if obj is present in this set, removes obj and
    // returns true; otherwise returns false}
     /**
     * Removes object from tree
     * 
     * @param obj the object to be removed
     * @return true if object removed, false otherwise
     */
    public boolean remove(Object obj)
    {
        if (!BSTUtilities.contains(root, (Comparable) obj, display))
        {
            return false;
        }
        root = BSTUtilities.delete(root, (Comparable) obj, display);
        size--;
        display.displayTree(root);
        return true;
    }
    
    
    /**
     * Returns the values of tree
     * 
     * @return the string values of tree
     */
    public String toString()
    {
        return toString(root);
    }

    /**
     * Returns the values of tree
     * 
     * @param t the tree to be printed
     * @return the values of t
     */
    private String toString(TreeNode t)
    {
        if (t == null)
            return ", ";
        return  toString(t.getLeft()) +  t.getValue() + toString(t.getRight());
    }
}