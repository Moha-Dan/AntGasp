package com.fall.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import entities.Panier;

public interface Table<E> extends Iterable<E>{
	public void add(E object);
	public void remove(E object);
	public int size();
	public Set<E> find(E entity);
	public E get(UUID uuid);
}
