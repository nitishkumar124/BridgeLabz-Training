package streams;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;

class WriterThread extends Thread {

    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            String message = "Hello from Writer Thread";

            pos.write(message.getBytes());
            pos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread {

    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class PipedStream {

    public static void main(String[] args) {

        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // connect streams

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

