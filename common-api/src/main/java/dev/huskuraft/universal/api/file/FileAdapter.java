package dev.huskuraft.universal.api.file;

import java.io.File;
import java.io.IOException;

public abstract class FileAdapter<T> {

    public abstract T read(File file) throws IOException;

    public abstract void write(File file, T t) throws IOException;
}
