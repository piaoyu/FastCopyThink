package hardlink;

import java.io.File;
import java.io.IOException;

/**
 * HardLink
 * Created by piaoyu on 14-10-20.
 */
public class HardLink {

    private final static String hardLink  = "ln -P ";

    public static boolean createHardLink(File src,File link) throws IOException {
        if (src == null){
            throw  new IOException("File source not found");
        }
        if  (link == null){
            throw new IOException("File link not found");
        }
        Runtime.getRuntime().exec("ln -s " + src + link);
        return true;
    }
}
