package com.falls.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table<E> implements Iterable<E>{
	public Table() {
		
	}
	List<E> ls = new ArrayList<E>();
	public void add(E object) {
		ls.add(object);
	}
	public void remove(E object) {
		ls.add(object);
	}
	@Override
	public Iterator<E> iterator() {
		return ls.iterator();
	}
	public int size() {
		return ls.size();
	}
}
