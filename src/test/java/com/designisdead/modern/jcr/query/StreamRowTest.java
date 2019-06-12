package com.designisdead.modern.jcr.query;

import com.designisdead.modern.jcr.StreamNode;
import com.designisdead.modern.jcr.exception.ModernJcrException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.query.Row;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StreamRowTest {

    @Mock
    private Row mockRow;

    @InjectMocks
    private StreamRow row;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getValues_success() throws Exception {
        Value value1 = mock(Value.class);
        Value value2 = mock(Value.class);
        Value value3 = mock(Value.class);

        when(mockRow.getValues()).thenReturn(new Value[]{value1, value2, value3});

        assertEquals(3, row.getValues().length);
    }

    @Test
    void getValues_exception() throws Exception {
        when(mockRow.getValues()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> row.getValues());
    }

    @Test
    void getValue_success() throws Exception {
        Value value1 = mock(Value.class);
        when(value1.getString()).thenReturn("value1");

        when(mockRow.getValue(anyString())).thenReturn(value1);

        assertEquals("value1", row.getValue("column1").getString());
    }

    @Test
    void getValue_exception() throws Exception {
        when(mockRow.getValue(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> row.getValue("column1"));
    }

    @Test
    void getNode_success() throws Exception {
        Node mockNode = mock(Node.class);
        when(mockNode.getName()).thenReturn("nodeName");

        when(mockRow.getNode()).thenReturn(mockNode);

        StreamNode node = row.getNode();
        assertEquals("nodeName", node.getName());
    }

    @Test
    void getNode_exception() throws Exception {
        when(mockRow.getNode()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> row.getNode());
    }

    @Test
    void getNode_withSelector_success() throws Exception {
        Node mockNode = mock(Node.class);
        when(mockNode.getName()).thenReturn("nodeName");

        when(mockRow.getNode(anyString())).thenReturn(mockNode);

        StreamNode node = row.getNode("selector");
        assertEquals("nodeName", node.getName());
    }

    @Test
    void getNode_withSelector_exception() throws Exception {
        when(mockRow.getNode(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> row.getNode("selector"));
    }

    @Test
    void getPath_success() throws Exception {
        when(mockRow.getPath()).thenReturn("path");

        assertEquals("path", row.getPath());
    }

    @Test
    void getPath_exception() throws Exception {
        when(mockRow.getPath()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> row.getPath());
    }

    @Test
    void getPath_withSelector_success() throws Exception {
        when(mockRow.getPath(anyString())).thenReturn("path");

        assertEquals("path", row.getPath("selector"));
    }

    @Test
    void getPath_withSelector_exception() throws Exception {
        when(mockRow.getPath(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> row.getPath("selector"));
    }

    @Test
    void getScore_success() throws Exception {
        when(mockRow.getScore()).thenReturn(1.5);

        assertEquals(1.5, row.getScore());
    }

    @Test
    void getScore_exception() throws Exception {
        when(mockRow.getScore()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> row.getScore());
    }

    @Test
    void getScore_withSelector_success() throws Exception {
        when(mockRow.getScore(anyString())).thenReturn(1.5);

        assertEquals(1.5, row.getScore("selector"));
    }

    @Test
    void getScore_withSelector_exception() throws Exception {
        when(mockRow.getScore(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> row.getScore("selector"));
    }
}