package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jcr.Binary;
import javax.jcr.RepositoryException;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StreamBinaryTest {

    @Mock
    private Binary binaryMock;

    @InjectMocks
    private StreamBinary binary;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getStream_success() throws Exception {
        InputStream inputStream = mock(InputStream.class);
        when(binaryMock.getStream()).thenReturn(inputStream);

        assertNotNull(binary.getStream());
    }

    @Test
    void getStream_exception() throws Exception {
        when(binaryMock.getStream()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> binary.getStream());
    }

    @Test
    void read_success() throws Exception {
        when(binaryMock.read(any(byte[].class), anyLong())).thenReturn(9);

        assertEquals(9, binary.read(new byte[]{}, 15));
    }

    @Test
    void read_exception() throws Exception {
        when(binaryMock.read(any(byte[].class), anyLong())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> binary.read(new byte[]{}, 15));
    }

    @Test
    void getSize_success() throws Exception {
        when(binaryMock.getSize()).thenReturn(9L);

        assertEquals(9L, binary.getSize());
    }

    @Test
    void getSize_exception() throws Exception {
        when(binaryMock.getSize()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> binary.getSize());
    }

    @Test
    void dispose() {
        binary.dispose();
        verify(binaryMock).dispose();
    }
}