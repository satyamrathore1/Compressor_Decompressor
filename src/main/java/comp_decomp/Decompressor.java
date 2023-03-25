package comp_decomp;

import java.io.*;
import java.util.zip.*;

public class Decompressor {    
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile");
        
//        Here we will get the compressed file through input stream & we will read it through gzipinputstream
//      & then decompress and write them back to fileoutputstream

        byte[] buffer = new byte[1024];
        int len;
        while((len=gzip.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        gzip.close();
        fis.close();
        fos.close();
    }
    
    public static void main(String[] args) throws IOException{
        File path = new File("/PrabhatSingh/Downloads/Compressor/compressordecompressor/CompressedFile.gz");
        method(path);
    }
}
