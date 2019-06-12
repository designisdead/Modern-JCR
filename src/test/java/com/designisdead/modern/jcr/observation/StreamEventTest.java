package com.designisdead.modern.jcr.observation;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jcr.RepositoryException;
import javax.jcr.observation.Event;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StreamEventTest {

    @Mock
    private Event eventMock;

    @InjectMocks
    private StreamEvent event;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getType_success() {
        when(eventMock.getType()).thenReturn(9);

        assertEquals(9, event.getType());
    }

    @Test
    void getPath_success() throws Exception {
        when(eventMock.getPath()).thenReturn("path");

        assertEquals("path", event.getPath());
    }

    @Test
    void getPath_exception() throws Exception {
        when(eventMock.getPath()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> event.getPath());
    }

    @Test
    void getUserID_success() {
        when(eventMock.getUserID()).thenReturn("user-id");

        assertEquals("user-id", event.getUserID());
    }

    @Test
    void getIdentifier_success() throws Exception {
        when(eventMock.getIdentifier()).thenReturn("identifier");

        assertEquals("identifier", event.getIdentifier());
    }

    @Test
    void getIdentifier_exception() throws Exception {
        when(eventMock.getIdentifier()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> event.getIdentifier());
    }

    @Test
    void getInfo_success() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("info", "info description");
        when(eventMock.getInfo()).thenReturn(map);

        assertEquals("info description", event.getInfo().get("info"));
    }

    @Test
    void getInfo_exception() throws Exception {
        when(eventMock.getInfo()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> event.getInfo());
    }

    @Test
    void getUserData_success() throws Exception {
        when(eventMock.getUserData()).thenReturn("userData");

        assertEquals("userData", event.getUserData());
    }

    @Test
    void getUserData_exception() throws Exception {
        when(eventMock.getUserData()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> event.getUserData());
    }

    @Test
    void getDate_success() throws Exception {
        when(eventMock.getDate()).thenReturn(8L);

        assertEquals(8L, event.getDate());
    }

    @Test
    void getDate_exception() throws Exception {
        when(eventMock.getDate()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> event.getDate());
    }
}