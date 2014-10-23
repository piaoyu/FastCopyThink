package fastcopy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.ClientProtocol;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

import java.io.IOException;

/**
 * HDFS Util
 * Created by piaoyu on 14-10-20.
 */
public class HDFSUtil {

    public static final Log LOG = LogFactory.getLog(HDFSUtil.class);
    private static final Configuration conf = new Configuration();


    /**
     * Get The HDFS File LocatedBlocks
     *
     * @param filePath
     * @return
     */
    public static LocatedBlocks getLocatedBlocks(String filePath) throws IOException {
        DistributedFileSystem disFS = (DistributedFileSystem) DistributedFileSystem.get(conf);
        ClientProtocol srcNameNode = disFS.getClient().getNamenode();
        LocatedBlocks fileLocatedBlocks = srcNameNode.getBlockLocations(filePath, 0, Long.MAX_VALUE);
        return fileLocatedBlocks;
    }

    /**
     * Get The HDFS File FileStatus
     *
     * @param filePath
     * @return
     */
    public static FileStatus getFileStatus(String filePath) throws IOException {
        DistributedFileSystem disFS = (DistributedFileSystem) DistributedFileSystem.get(conf);
        Path hdfsfilePath = new Path(filePath);
        FileStatus fileStatus = disFS.getFileStatus(hdfsfilePath);
        return fileStatus;
    }

    /**
     * Is the HDFS File LocatedBlocks UnderConstruction
     *
     * @param fileLocatedBlocks
     * @return
     */
    public static boolean isUnderConstruction(LocatedBlocks fileLocatedBlocks) {
        return fileLocatedBlocks.isUnderConstruction();
    }


//    public static boolean createFsInNS(){
//
//    }

}
