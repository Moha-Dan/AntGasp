package com.fall.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListTable<E> implements Table<E> {
	public ListTable() {
		
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
	public Set<E> find(E entity) {
		return ls.stream().filter((E ent)->{
			boolean isequal = true;
			List<String> props = ParseClass.getProprietyNames(ent);
			Iterator<String> it1 = props.iterator();
			while(it1.hasNext() && isequal) {
				String key = it1.next();
				Object value = ParseClass.getPropriety(entity, key);
				if(value!=null) {
					Object value1 = ParseClass.getPropriety(ent, key);
					if(!value.equals(value1)) {
						System.out.println("39"+value+" : "+value1+"||");
						isequal = false;
					}
				}
			}
			/*
			HashMap<String,Object> map1 = ParseClass.parse(ent);
			HashMap<String,Object> map2 = ParseClass.parse(entity);
			Set<String> set1 = map1.keySet();
			if(set1.size() != map2.size())return isequal;
			Iterator<String> it1 = set1.iterator();
			String key = null;
			isequal = true;
			do {
				key = it1.next();
				System.out.println("ent "+key+" : "+map1.get(key));
				System.out.println("entity "+key+" : "+map2.get(key));
				if(map1.get(key) != null)
					isequal = map1.get(key).equals(map2.get(key));
			}
			while(it1.hasNext() && isequal);
			 	*/
			return isequal;
		}).collect(Collectors.toSet());
	}
}
