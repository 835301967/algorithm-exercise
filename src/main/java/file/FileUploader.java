package file;

import io.minio.*;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {

    public static final String BUCKET_NAME = "secondbucket";
    public static final String FILE_PATH = "/Users/yuxiangjin/Pictures/test1.png";
    public static final String NAME = "test2.png";
    public static final String ENDPOINT = "http://10.12.7.206:9000";
    public static final String ACCESS_KEY = "IccSwcfwLFGgGvpcWbB1";
    public static final String SECRET_KEY = "EqtOBBLQt2ChCTxm7SBtDCPnk9N76mhopiQhs9rF";

    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // Create a minioClient with the MinIO server playground, its access key and secret key.
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(ENDPOINT)
                            .credentials(ACCESS_KEY, SECRET_KEY)
                            .build();

            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
            } else {
                System.out.printf("Bucket %s already exists.",BUCKET_NAME);
            }

//            minioClient.uploadObject(
//                    UploadObjectArgs.builder()
//                            .bucket(BUCKET_NAME)
//                            .object(NAME)
//                            .filename(FILE_PATH)
//                            .build());
            GetObjectResponse object = minioClient.getObject(GetObjectArgs.builder().bucket(BUCKET_NAME).object(NAME).build());
            byte[] bytes = new byte[1024];
            object.read(bytes);

            object.close();
            System.out.printf(
                    "%s is successfully uploaded as "
                            + "object %s to bucket %s.",FILE_PATH,NAME,BUCKET_NAME);
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }
}
