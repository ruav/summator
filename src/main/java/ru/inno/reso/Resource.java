package ru.inno.reso;

import java.io.File;

/**
 * Created by ruav on 15.12.16.
 */
public interface Resource {

    /**
     * Проверяет доступность ресурса.
     * @return возвращает состояние доступности.
     */
    boolean checkResourceExist();

    /**
     * Возвращает ресурсный файл (для удаленных ресурсов - возвращает временный файл)
     * @return возвращает ссылку на ресурсный файл.
     */
    File getResourceFile();



}
