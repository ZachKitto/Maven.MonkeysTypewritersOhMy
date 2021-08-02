package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {
        while (stringIterator.hasNext()) {
            copied = new StringBuilder(copied).append(stringIterator.next()).append(" ").toString();
        }
    }

    @Override
    public String toString() {
        return copied;
    }
}
