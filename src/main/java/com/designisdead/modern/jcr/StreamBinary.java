package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.jcr.Binary;
import javax.jcr.RepositoryException;
import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
public class StreamBinary {

    @Getter
    private final Binary binary;

    public InputStream getStream() {
        try {
            return binary.getStream();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public int read(byte[] b, long position) throws IOException {
        try {
            return binary.read(b, position);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public long getSize() {
        try {
            return binary.getSize();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void dispose() {
        binary.dispose();
    }
}
