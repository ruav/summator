package ru.inno.reso;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ruav on 15.12.16.
 */
public class ResourceImplRemote implements Resource {

    private String fileNameForParse;
    private File resourceFile;
    private URL url = null;

    public ResourceImplRemote(String fileNameForParse) throws MalformedURLException {
        this.fileNameForParse = fileNameForParse;
        this.resourceFile = new File(fileNameForParse);
        url = new URL(fileNameForParse);


    }

    @Override
    public boolean checkResourceExist() {
        boolean result = false;
        try {
            url.openConnection();

            result = true;

            // вычитываем данные из сети, и записываем во временный файл
            InputStream is = new BufferedInputStream(url.openStream());
            File fTemp = File.createTempFile("url", ".tmp");
            fTemp.deleteOnExit();
            OutputStream os = new FileOutputStream(fTemp);
            byte[] bytes = new byte[1024];
            while (is.available() > 0) {
                is.read(bytes);
                os.write(bytes);
            }
            is.close();
            os.flush();
            os.close();
            resourceFile = fTemp;

        } catch (IOException e) {

        }
        return result;
    }

    @Override
    public File getResourceFile() {
        return resourceFile;
    }


}
