package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private Element head = null;

    private int size = 0;

    @Override
    public void add(Object o) {
        size ++;

        if (head == null){
            head = new Element(o);

            return;
        }

        Element temp = head;

        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = new Element(o);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        return null;
    }

    @Override
    public Iterator<Object> iterator() {
        return null;
    }


    private static class Element{

        private Object item;
        private Element next;

        public Element(Object item){
            this.item = item;
            this.next = null;
        }

        public Object getItem(){
            return item;
        }
    }

    private class SimpleIteratorImpl implements Iterator<Object> {

        private Element current = head;

        @Override
        public boolean hasNext() {
            return current!= null;
        }

        @Override
        public Object next() {
            Object temp = current.getItem();
            current = current.next;
            return temp;
        }
    }

}
