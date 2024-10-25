package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Arvore<T> {
	  private T head;
	  private HashMap<T, Arvore<T>> locate = new HashMap<T, Arvore<T>>();
	  private ArrayList<Arvore<T>> leafs = new ArrayList<Arvore<T>>();
	  
	  public Arvore(T head) {
		    this.head = head;
		    locate.put(head, this);
	  }
	  public boolean addLeaf(T root, T leaf) {
		  if (locate.containsKey(root) && !existe(leaf)) {
			  locate.get(root).addLeaf(leaf);
			  return true;
		  }
		  return false;
		  //else {
			  //addLeaf(root).addLeaf(leaf);
		  //}
	  }
	  public Arvore<T> addLeaf(T leaf) {
		  Arvore<T> t = new Arvore<T>(leaf);
		  leafs.add(t);
		  t.locate = this.locate;
		  locate.put(leaf, t);
		  return t;
	  }
	  private boolean existe(T root) {
		  return locate.containsKey(root);
	  }

	  
	  @Override
	  public String toString() {
		  return printTree(0);
	  }
	  private static final int indent = 2;

	  private String printTree(int increment) {
		  String s = "";
		  String inc = "";
		  for (int i = 0; i < increment; ++i) {
		    inc = inc + " ";
		  }
		  s = inc + head;
		  for (Arvore<T> child : leafs) {
		    s += "\n" + child.printTree(increment + indent);
		  }
		  return s;
	  }
}
