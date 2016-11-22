package net.afferolab.s3;

import net.afferolab.FileManager;
import org.junit.Test;

import java.io.File;
import java.util.Optional;

public class S3ManagerTest {

    @Test(expected = NullPointerException.class)
    public void configurationCanNotBeNull() {
        //Init
        S3Configuration configuration = null;

        //Act
        FileManager manager = new S3Manager(configuration);
    }

    @Test(expected = NullPointerException.class)
    public void fileCanNotBeNull() {
        //Init
        S3Configuration configuration = new S3Configuration();
        File file = null;

        //Act
        FileManager manager = new S3Manager(configuration);
        manager.uploadFile(file, Optional.empty());

    }


}
