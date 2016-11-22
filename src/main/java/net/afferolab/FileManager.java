package net.afferolab;


import java.io.File;
import java.net.URL;
import java.util.Optional;

public interface FileManager {

    URL uploadFile(File file, Optional<Integer> expiration);

}
