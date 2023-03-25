package comp_decomp;

import java.io.*;
import java.util.zip.*;
//to import gzip file

public class Compressor {
    public static void method(File file)throws IOException{
//        we will make a function of file type so that evertime we call this function it will return a file
        String fileDirectory = file.getParent();
//        getParent returns the path name of the file
        FileInputStream fis = new FileInputStream(file);
//        used to read the path of the input file or read the compressed data
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");
//        bcz we are going to push output file in fileDirectory & in inverted coluns giving the name we want of our compressed file
         GZIPOutputStream gzip = new GZIPOutputStream(fos);
//      we are creating gzip file bcz we want our output file to be compressed file
//      we have chosen fos bcz the file we want the bytes of those file to be compressed

        byte[] buffer = new byte[1024];
//        bcz our file will be converted to byte type & to read that file we need byte type array and then write it in our output file
        int len;
        while((len=fis.read(buffer)) != -1){
//            I want this compressed-file to be readed inside in buffer array & read it until it becomes -1 or reach end of the file
//            we will read and store the values in this len variable
//        this fis.read- reads upto b.length bytes of data from inputStream into an array of bytes(fetches bytes from the input file)
        gzip.write(buffer, 0, len);
//        now we will write the data (buffer- is the data) (0 - is the starting point from where we want to start writing) (len - is the no of bytes to write)
//        from here we will write the output file will be gzip OutputStream file i.e. the compressed file 
        }
        fis.close();
        fos.close();
        gzip.close();  
//        closing all the streams
    }
    
    public static void main(String[] args)throws IOException{
        File path = new File("/PrabhatSingh/Downloads/Compressor/compressordecompressor/Testfile");
        method(path);
//        this will return the parent of the test file of line 14
    }
}
