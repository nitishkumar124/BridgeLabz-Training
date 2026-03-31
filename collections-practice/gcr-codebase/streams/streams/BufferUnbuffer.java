package streams;

import java.io.*;

public class BufferUnbuffer {

    private static final int BUFFER_SIZE = 4096; 

    public static void main(String[] args) throws Exception {

        String source =
            "bigfile.dat";

        String unbufferedDest =
            "copy_unbuffered.dat";

        String bufferedDest =
            "copy_buffered.dat";

        copyUsingUnbufferedStreams(source, unbufferedDest);
        copyUsingBufferedStreams(source, bufferedDest);
    }

    // Unbuffer
    static void copyUsingUnbufferedStreams(String src, String dest) throws IOException {

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        long start = System.nanoTime();

        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        long end = System.nanoTime();

        fis.close();
        fos.close();

        System.out.println("Unbuffered Stream Time: " + (end - start) + " ns");
    }

    // Buffer
    static void copyUsingBufferedStreams(String src, String dest) throws IOException {

        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(dest));

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        long start = System.nanoTime();

        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        long end = System.nanoTime();

        bis.close();
        bos.close();

        System.out.println("Buffered Stream Time: " + (end - start) + " ns");
    }
}

