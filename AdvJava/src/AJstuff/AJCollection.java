package AJstuff;
// Generics whirlwind
//    "AJCollection<Integer>"
//    => X ~> "Integer"
public interface AJCollection<E> extends Iterable<E>{
  /**
   * 
   * @param e - the element to attempt to add.
   * @return true if the element was added, false
   * if the element was already present and this collection
   * doesn't support multiple objects for which equals() is true, or
   * if for some reason it would be invalid to add this element
   * (for Example, if e == null and the collection doesn't support
   * null elements).
   */
  public boolean add(E e);
  
  /**
   * 
   * @param e - the element to attempt to remove.
   * @return true if the element was present and now is not; false
   * if the element was not present to be removed.  If this collection
   * supports multiple objects which are equals() to e, only one
   * instance is removed.
   */
  public boolean remove(E e);
  
  /**
   * @param e - element to test for presence of
   * @return - true if e was present; false otherwise.
   */
  public boolean contains(E e);
  
  /**
   * Removes all element in this collection.
   */
  public void clear();
  
  /**
   * @return the number of elements in this collection, >= 0.
   */
  public int size();
  //public E get(int i);
}
