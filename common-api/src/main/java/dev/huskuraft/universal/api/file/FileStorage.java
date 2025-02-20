package dev.huskuraft.universal.api.file;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.logging.Logger;

import dev.huskuraft.universal.api.platform.Platform;

abstract class FileStorage<T> implements Storage<T> {

    private final String fileName;
    private final FileType fileType;
    private T target;

    protected FileStorage(String fileName, FileType fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    protected String getFileName() {
        return fileName;
    }

    protected final FileType getFileType() {
        return fileType;
    }

    private void read() {
        try {
            var file = getTargetFile();
            if (!file.exists()) {
                this.target = getDefault();
                write();
                return;
            }
            // TODO: 27/2/24
//            read.validate();
            this.target = read(file);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().warning("Cannot read config file: " + e.getMessage());
            this.target = getDefault();
        }
        write();
    }

    private void write() {
        try {
            var file = getTargetFile();
            write(file, target);
        } catch (Exception e) {
            Logger.getAnonymousLogger().warning("Cannot save config file: " + e.getMessage());
        }
    }

    protected File getDir() throws IOException {
        var dataDir = Platform.getInstance().getConfigDir().toFile();
        if (!dataDir.exists() && !dataDir.mkdirs()) {
            throw new IOException("Could not create data directory: " + dataDir.getAbsolutePath());
        }
        return dataDir;
    }

    private File getTargetFile() throws IOException {
        return new File(getDir(), getFileName());
    }

    @Override
    public void update(UnaryOperator<T> operator) {
        synchronized (this) {
            set(operator.apply(get()));
        }
    }

    @Override
    public T get() {
        synchronized (this) {
            if (target == null) {
                read();
            }
            return target;
        }
    }

    @Override
    public void set(T config) {
        synchronized (this) {
            if (Objects.equals(this.target, config)) {
                return;
            }
            this.target = config;
            write();
        }
    }

    public abstract T getDefault();

    protected abstract T read(File config) throws IOException;

    protected abstract void write(File file, T t) throws IOException;

}
