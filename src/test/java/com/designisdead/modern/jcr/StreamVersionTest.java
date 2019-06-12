package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.version.Version;
import javax.jcr.version.VersionHistory;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StreamVersionTest {

    @Mock
    private Version versionMock;

    @InjectMocks
    private StreamVersion version;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getContainingHistory_success() throws Exception {
        VersionHistory versionHistory = mock(VersionHistory.class);
        when(versionMock.getContainingHistory()).thenReturn(versionHistory);

        assertNotNull(version.getContainingHistory());
    }

    @Test
    void getContainingHistory_exception() throws Exception {
        when(versionMock.getContainingHistory()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> version.getContainingHistory());
    }

    @Test
    void getCreated_success() throws Exception {
        when(versionMock.getCreated()).thenReturn(Calendar.getInstance());

        assertNotNull(version.getCreated());
    }

    @Test
    void getCreated_exception() throws Exception {
        when(versionMock.getCreated()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> version.getCreated());
    }

    @Test
    void getLinearSuccessor_success() throws Exception {
        Version successor = mock(Version.class);
        when(versionMock.getLinearSuccessor()).thenReturn(successor);

        assertNotNull(this.version.getLinearSuccessor());
    }

    @Test
    void getLinearSuccessor_exception() throws Exception {
        when(versionMock.getLinearSuccessor()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> version.getLinearSuccessor());
    }

    @Test
    void getSuccessors_success() throws Exception {
        Version successor = mock(Version.class);
        when(versionMock.getSuccessors()).thenReturn(new Version[]{successor, successor});

        assertEquals(2, this.version.getSuccessors().length);
    }

    @Test
    void getSuccessors_exception() throws Exception {
        when(versionMock.getSuccessors()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> version.getSuccessors());
    }

    @Test
    void getLinearPredecessor_success() throws Exception {
        Version predecessors = mock(Version.class);
        when(versionMock.getLinearPredecessor()).thenReturn(predecessors);

        assertNotNull(this.version.getLinearPredecessor());
    }

    @Test
    void getLinearPredecessor_exception() throws Exception {
        when(versionMock.getLinearPredecessor()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> version.getLinearPredecessor());
    }

    @Test
    void getPredecessors_success() throws Exception {
        Version predecessors = mock(Version.class);
        when(versionMock.getPredecessors()).thenReturn(new Version[]{predecessors, predecessors});

        assertEquals(2, this.version.getPredecessors().length);
    }

    @Test
    void getPredecessors_exception() throws Exception {
        when(versionMock.getPredecessors()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> version.getPredecessors());
    }

    @Test
    void getFrozenNode_success() throws Exception {
        Node node = mock(Node.class);
        when(versionMock.getFrozenNode()).thenReturn(node);

        assertNotNull(this.version.getFrozenNode());
    }

    @Test
    void getFrozenNode_exception() throws Exception {
        when(versionMock.getFrozenNode()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> version.getFrozenNode());
    }
}