package com.peterdkahn.rest
import java.io.File


/**
 * Simple file info class to test ability to work with springboot - expect to remove later.
 * Created by pkahn on 3/14/17.
 */
 class FileInfo {
    private String path
    private String name

    void setPath(String path) {
        this.path = path
    }
    String getPath() {
        return path
    }

    void setName(String name) {
        this.name = name
    }

    String getName() {
        return name
    }
}
