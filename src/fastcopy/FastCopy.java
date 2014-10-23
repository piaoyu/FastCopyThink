package fastcopy;

import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.ClientProtocol;

import java.util.concurrent.ExecutorService;

/**
 * FastCopy Learn
 * Created by piaoyu on 14-10-22.
 */
public class FastCopy {

    private static ClientProtocol srcNameNode;
    private static ClientProtocol destNameNode;
    private ExecutorService blockRPCExcutor;

    //查询源NS中文件的meta信息,获取源文件所有的block信息

    /**
     *
     * @param src 源文件
     * @param dest 目标文件
     * @param srcFs 原FileSystem
     * @param destFs 目标FileSystem
     * @return
     */
    public static boolean fastCopy(String src, String dest, DistributedFileSystem srcFs, DistributedFileSystem destFs) {
        srcNameNode = srcFs.getClient().getNamenode();
        destNameNode = destFs.getClient().getNamenode();
        destNameNode.addBlock();

    }


}
