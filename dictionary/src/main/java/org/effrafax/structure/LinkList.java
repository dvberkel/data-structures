package org.effrafax.structure;



public class LinkList<T> {
	private T data = null;
	private LinkList<T> next = null;

	public int size() {
		if (next == null) {
			return 0;
		}
		return next.size() + 1;
	}

	public void add(T data) {
		if (next != null) {
			next.add(data);
			return;
		}
		this.data = data;
		this.next = new LinkList<T>();
	}

	public boolean contains(T target) {
		if ((target == null && data == null) || (target != null && target.equals(data))) {
			return true;
		}
		if (next != null) {
			return next.contains(target);
		}
		return false;
	}

	public T get(int index) {
		if (index == 0) {
			return data;
		}
		if (next == null) {
			throw new IndexOutOfBoundsException();
		}
		return next.get(index - 1);
	}

	public int indexOf(T target) {
		if (target.equals(data)) {
			return 0;
		}
		if (next != null) {
			return next.indexOf(target) + 1;
		}
		throw new ElementNotFoundException();
	}
}

class ElementNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}