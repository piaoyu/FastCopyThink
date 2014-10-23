import fastcopy.HDFSUtil;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

import java.io.IOException;

/**
 * Created by piaoyu on 14-10-20.
 */
public class FastCopyMain {

    public static void main(String[] args) throws IOException {
        String inputDir = args[0];
        LocatedBlocks locatedBlocks = HDFSUtil.getLocatedBlocks(inputDir);
        System.out.print(locatedBlocks.getLastLocatedBlock().getLocations());
    }
}
