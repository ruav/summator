package ru.inno.reso;

import java.io.File;

/**
 * Created by ruav on 15.12.16.
 */
public class ResourceImplLocal implements Resource{

    private String fileNameForParse;
    private File resourceFile;

    public ResourceImplLocal(String fileNameForParse) {
        this.fileNameForParse = fileNameForParse;
        this.resourceFile = new File(fileNameForParse);
    }

    @Override
    public boolean checkResourceExist() {
        return this.resourceFile.exists();
    }

    @Override
    public File getResourceFile() {
        return this.resourceFile;
    }
}
