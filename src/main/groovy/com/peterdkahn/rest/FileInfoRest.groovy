package com.peterdkahn.rest

import javax.inject.Named
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

/**
 * Simple Rest interface. again to test ability to use framework.
 * Created by pkahn on 3/14/17.
 */
@Named
@Path("/")
class FileInfoRest {
    private static List<FileInfo> files = new ArrayList<>()
    static {
        FileInfo file1 = new FileInfo()
        file1.setPath("/")
        file1.setName("foo")
        FileInfo file2 = new FileInfo()
        file2.setPath("subdir")
        file2.setName("bar")
        files.add(file1)
        files.add(file2)
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<FileInfo> getFiles() {
        return files
    }

    @GET
    @Path("file")
    @Produces(MediaType.APPLICATION_JSON)
    FileInfo getFile(@QueryParam("name") String name) {
        return files.find() { it.getName().equals(name)}
    }
}
