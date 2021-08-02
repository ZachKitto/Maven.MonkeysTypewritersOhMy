package io.zipcoder;

import java.util.stream.Stream;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        UnsafeCopier unsafeMonkey1 = new UnsafeCopier(introduction);
        UnsafeCopier unsafeMonkey2 = new UnsafeCopier(introduction);
        UnsafeCopier unsafeMonkey3 = new UnsafeCopier(introduction);
        UnsafeCopier unsafeMonkey4 = new UnsafeCopier(introduction);
        UnsafeCopier unsafeMonkey5 = new UnsafeCopier(introduction);
        new Thread(unsafeMonkey1).start();
        new Thread(unsafeMonkey2).start();
        new Thread(unsafeMonkey3).start();
        new Thread(unsafeMonkey4).start();
        new Thread(unsafeMonkey5).start();

        SafeCopier safeMonkey1 = new SafeCopier(introduction);
        SafeCopier safeMonkey2 = new SafeCopier(introduction);
        SafeCopier safeMonkey3 = new SafeCopier(introduction);
        SafeCopier safeMonkey4 = new SafeCopier(introduction);
        SafeCopier safeMonkey5 = new SafeCopier(introduction);
        new Thread(safeMonkey1).start();
        new Thread(safeMonkey2).start();
        new Thread(safeMonkey3).start();
        new Thread(safeMonkey4).start();
        new Thread(safeMonkey5).start();


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        Stream.of(unsafeMonkey1, unsafeMonkey2, unsafeMonkey3, unsafeMonkey4, unsafeMonkey5)
                .forEach(System.out::println);

        Stream.of(safeMonkey1, safeMonkey2, safeMonkey3, safeMonkey4, safeMonkey5)
                .forEach(System.out::println);
    }
}