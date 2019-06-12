package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jcr.Item;
import javax.jcr.ItemVisitor;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StreamItemTest {

    @Mock
    private Item itemMock;

    @InjectMocks
    private StreamItem item;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getPath_success() throws Exception {
        when(itemMock.getPath()).thenReturn("path");

        assertEquals("path", item.getPath());
    }

    @Test
    void getPath_exception() throws Exception {
        when(itemMock.getPath()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> item.getPath());
    }

    @Test
    void getName_success() throws Exception {
        when(itemMock.getName()).thenReturn("name");

        assertEquals("name", item.getName());
    }

    @Test
    void getName_exception() throws Exception {
        when(itemMock.getName()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> item.getName());
    }

    @Test
    void getAncestor_success() throws Exception {
        Item ancestor = mock(Item.class);
        when(ancestor.getName()).thenReturn("name");
        when(itemMock.getAncestor(anyInt())).thenReturn(ancestor);

        assertEquals("name", this.item.getAncestor(9).getName());
    }

    @Test
    void getAncestor_exception() throws Exception {
        when(itemMock.getAncestor(anyInt())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> item.getAncestor(5));
    }

    @Test
    void getParent_success() throws Exception {
        Node node = mock(Node.class);
        when(node.getName()).thenReturn("name");
        when(itemMock.getParent()).thenReturn(node);

        assertEquals("name", item.getParent().getName());
    }

    @Test
    void getParent_exception() throws Exception {
        when(itemMock.getParent()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> item.getParent());
    }

    @Test
    void getDepth_success() throws Exception {
        when(itemMock.getDepth()).thenReturn(2);

        assertEquals(2, item.getDepth());
    }

    @Test
    void getDepth_exception() throws Exception {
        when(itemMock.getDepth()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> item.getDepth());
    }

    @Test
    void getSession_success() throws Exception {
        Session session = mock(Session.class);
        when(itemMock.getSession()).thenReturn(session);

        assertNotNull(item.getSession());
    }

    @Test
    void getSession_exception() throws Exception {
        when(itemMock.getSession()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> item.getSession());
    }

    @Test
    void isNode() {
        item.isNode();
        verify(itemMock).isNode();
    }

    @Test
    void isNew() {
        item.isNew();
        verify(itemMock).isNew();
    }

    @Test
    void isModified() {
        item.isModified();
        verify(itemMock).isModified();
    }

    @Test
    void isSame_success() throws Exception {
        Item other = mock(Item.class);
        item.isSame(other);
        verify(itemMock).isSame(any(Item.class));
    }

    @Test
    void isSame_exception() throws Exception {
        Item other = mock(Item.class);
        when(itemMock.isSame(any(Item.class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> item.isSame(other));
    }

    @Test
    void accept_success() throws Exception {
        ItemVisitor other = mock(ItemVisitor.class);
        item.accept(other);
        verify(itemMock).accept(any(ItemVisitor.class));
    }

    @Test
    void accept_exception() throws Exception {
        ItemVisitor other = mock(ItemVisitor.class);
        doThrow(RepositoryException.class).when(itemMock).accept(any(ItemVisitor.class));

        assertThrows(ModernJcrException.class, () -> item.accept(other));
    }

    @Test
    void refresh_success() throws Exception {
        item.refresh(true);
        verify(itemMock).refresh(anyBoolean());
    }

    @Test
    void refresh_exception() throws Exception {
        doThrow(RepositoryException.class).when(itemMock).refresh(anyBoolean());

        assertThrows(ModernJcrException.class, () -> item.refresh(true));
    }

    @Test
    void remove_success() throws Exception {
        item.remove();
        verify(itemMock).remove();
    }

    @Test
    void remove_exception() throws Exception {
        doThrow(RepositoryException.class).when(itemMock).remove();

        assertThrows(ModernJcrException.class, () -> item.remove());
    }

}