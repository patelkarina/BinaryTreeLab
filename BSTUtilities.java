//a collection of static methods for operating on binary search trees
 /**
     * BSTUtilities allows user to change tree. 
     * @author Karina Patel 
     * @version 20 November 2016
     */
    public abstract class BSTUtilities
{
    //precondition:  t is a binary search tree in ascending order
    //postcondition: returns true if t contains the value x;
    //               otherwise, returns false
     /**
     * Checks if tree contains value 
     * 
     * @param t the tree to be checked
     * @param x the value to be checked
     * @param display displays tree
     * @return true if tree contains value, false otherwise 
     */
    public static boolean contains(TreeNode t, Comparable x, TreeDisplay display)
    {
       if (t == null)
       {
           return false;
        }
       display.visit(t);
       if (x.compareTo(t.getValue()) == 0)
       {
           return true;
        }
       if (x.compareTo(t.getValue()) < 0)
       { 
          return contains(t.getLeft(), x, display);
        }
       if (x.compareTo(t.getValue()) > 0) 
       {
           return contains(t.getRight(), x, display);
        }
       return false;
    }

    //precondition:  t is a binary search tree in ascending order
    //postcondition: if t is empty, returns a new tree containing x;
    //               otherwise, returns t, with x having been inserted
    //               at the appropriate position to maintain the binary
    //               search tree property; x is ignored if it is a
    //               duplicate of an element already in t; only one new
    //               TreeNode is created in the course of the traversal
    /**
     * Inserts value in tree.
     * 
     * @param t the tree that value is to be insterted
     * @param x the value that is to be inserted
     * @param display displays tree
     * @return the TreeNode that is inserted
     */
    public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display)
    {
       if (t == null)
       {
           return new TreeNode(x, null, null);
        }
       else if (x.compareTo(t.getValue())<0) 
        {
            if (t.getLeft()==null) 
            {
                t.setLeft(new TreeNode(x));
                return t.getLeft();
            }
            return insert(t.getLeft(), x, display);
        }
       else if (x.compareTo(t.getValue())>0)
        {
            if (t.getRight()==null) 
            {
                t.setRight(new TreeNode(x));
                return t.getRight();
            }
            return insert(t.getRight(), x, display);
        }
        else 
        {
            return t;
        }
    }

    //precondition:  t is a binary search tree in ascending order
    //postcondition: returns a pointer to a binary search tree,
    //               in which the value at node t has been deleted
    //               (and no new TreeNodes have been created)
     /**
     * Deletes node from tree.
     * 
     * @param t the node that is to be deleted
     * @param display displays tree
     * @return the replacement of the deleted node
     */
    private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
    {
        TreeNode focusNode = t;
        if (focusNode.getLeft() == null && focusNode.getRight() == null)
        {
            return null;
        }
        if (focusNode.getLeft() == null)
        {
            return focusNode.getRight();
        }
        if (focusNode.getRight() == null)
        {
            return focusNode.getLeft();
        }
        Object value = TreeUtil.leftmost(focusNode.getRight());
        focusNode.setValue(value);
        t.setRight(delete(focusNode.getRight(), (Comparable)value, display));
        return t;
    }

    //precondition:  t is a binary search tree in ascending order
    //postcondition: returns a pointer to a binary search tree,
    //               in which the value x has been deleted (if present)
    //               (and no new TreeNodes have been created)
     /**
     * Finds node that is to be deleted.
     * 
     * @param t the tree that node is to be found
     * @param x the value that is to be found
     * @param display displays tree
     * @return the root of the tree
     */
    public static TreeNode delete(TreeNode t, Comparable x, TreeDisplay display)
    {
        if (contains(t, x, display))
        {
            if (t == null)
            {
                return t;
            }
            TreeNode focusNode = t;
            if (x.compareTo(focusNode.getValue()) > 0)
            {
                focusNode.setRight(delete(focusNode.getRight(), x, display));
            }
            else if (x.compareTo(focusNode.getValue()) < 0)
            {
                focusNode.setLeft(delete(focusNode.getLeft(), x, display));
            }
            else
            {
                return deleteNode(focusNode, display);
            }
        }
        return t;
    }
}