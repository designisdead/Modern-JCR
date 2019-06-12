package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.version.Version;
import javax.jcr.version.VersionHistory;
import javax.jcr.version.VersionIterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StreamVersionHistoryTest {


    @Mock
    private VersionHistory versionHistoryMock;

    @InjectMocks
    private StreamVersionHistory versionHistory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getVersionableIdentifier_success() throws Exception {
        when(versionHistoryMock.getVersionableIdentifier()).thenReturn("identifier");

        assertEquals("identifier", versionHistory.getVersionableIdentifier());
    }

    @Test
    void getVersionableIdentifier_exception() throws Exception {
        when(versionHistoryMock.getVersionableIdentifier()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getVersionableIdentifier());
    }

    @Test
    void getRootVersion_success() throws Exception {
        Version version = mock(Version.class);
        when(versionHistoryMock.getRootVersion()).thenReturn(version);

        assertNotNull(versionHistory.getRootVersion());
    }

    @Test
    void getRootVersion_exception() throws Exception {
        when(versionHistoryMock.getRootVersion()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getRootVersion());
    }

    @Test
    void getAllLinearVersions_success() throws Exception {
        VersionIterator iterator = mock(VersionIterator.class);
        when(versionHistoryMock.getAllLinearVersions()).thenReturn(iterator);

        assertNotNull(versionHistory.getAllLinearVersions());
    }

    @Test
    void getAllLinearVersions_exception() throws Exception {
        when(versionHistoryMock.getAllLinearVersions()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getAllLinearVersions());
    }

    @Test
    void getAllVersions_success() throws Exception {
        VersionIterator iterator = mock(VersionIterator.class);
        when(versionHistoryMock.getAllVersions()).thenReturn(iterator);

        assertNotNull(versionHistory.getAllVersions());
    }

    @Test
    void getAllVersions_exception() throws Exception {
        when(versionHistoryMock.getAllVersions()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getAllVersions());
    }

    @Test
    void getAllLinearFrozenNodes_success() throws Exception {
        NodeIterator iterator = mock(NodeIterator.class);
        when(versionHistoryMock.getAllLinearFrozenNodes()).thenReturn(iterator);

        assertNotNull(versionHistory.getAllLinearFrozenNodes());
    }

    @Test
    void getAllLinearFrozenNodes_exception() throws Exception {
        when(versionHistoryMock.getAllLinearFrozenNodes()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getAllLinearFrozenNodes());
    }

    @Test
    void getAllFrozenNodes_success() throws Exception {
        NodeIterator iterator = mock(NodeIterator.class);
        when(versionHistoryMock.getAllFrozenNodes()).thenReturn(iterator);

        assertNotNull(versionHistory.getAllFrozenNodes());
    }

    @Test
    void getAllFrozenNodes_exception() throws Exception {
        when(versionHistoryMock.getAllFrozenNodes()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getAllFrozenNodes());
    }

    @Test
    void getVersion_success() throws Exception {
        Version version = mock(Version.class);
        when(versionHistoryMock.getVersion(anyString())).thenReturn(version);

        assertNotNull(versionHistory.getVersion("version"));
    }

    @Test
    void getVersion_exception() throws Exception {
        when(versionHistoryMock.getVersion(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getVersion("version"));
    }

    @Test
    void getVersionByLabel_success() throws Exception {
        Version version = mock(Version.class);
        when(versionHistoryMock.getVersionByLabel(anyString())).thenReturn(version);

        assertNotNull(versionHistory.getVersionByLabel("version"));
    }

    @Test
    void getVersionByLabel_exception() throws Exception {
        when(versionHistoryMock.getVersionByLabel(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getVersionByLabel("version"));
    }

    @Test
    void addVersionLabel_success() throws Exception {
        versionHistory.addVersionLabel("name", "label", false);
        verify(versionHistoryMock).addVersionLabel(anyString(), anyString(), anyBoolean());
    }

    @Test
    void addVersionLabel_exception() throws Exception {
        doThrow(RepositoryException.class).when(versionHistoryMock).addVersionLabel(anyString(), anyString(), anyBoolean());

        assertThrows(ModernJcrException.class, () -> versionHistory.addVersionLabel("name", "label", false));
    }

    @Test
    void removeVersionLabel_success() throws Exception {
        versionHistory.removeVersionLabel("label");
        verify(versionHistoryMock).removeVersionLabel(anyString());
    }

    @Test
    void removeVersionLabel_exception() throws Exception {
        doThrow(RepositoryException.class).when(versionHistoryMock).removeVersionLabel(anyString());

        assertThrows(ModernJcrException.class, () -> versionHistory.removeVersionLabel("label"));
    }

    @Test
    void hasVersionLabel_success() throws Exception {
        when(versionHistoryMock.hasVersionLabel(anyString())).thenReturn(true);

        assertTrue(versionHistory.hasVersionLabel("label"));
    }

    @Test
    void hasVersionLabel_exception() throws Exception {
        when(versionHistoryMock.hasVersionLabel(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.hasVersionLabel("label"));
    }

    @Test
    void hasVersionLabel_withVersion_success() throws Exception {
        StreamVersion streamVersion = mock(StreamVersion.class);
        Version version = mock(Version.class);
        when(streamVersion.getVersion()).thenReturn(version);
        when(versionHistoryMock.hasVersionLabel(any(Version.class), anyString())).thenReturn(true);

        assertTrue(versionHistory.hasVersionLabel(streamVersion, "label"));
    }

    @Test
    void hasVersionLabel_withVersion_exception() throws Exception {
        StreamVersion streamVersion = mock(StreamVersion.class);
        Version version = mock(Version.class);
        when(streamVersion.getVersion()).thenReturn(version);
        when(versionHistoryMock.hasVersionLabel(any(Version.class), anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.hasVersionLabel(streamVersion, "label"));
    }

    @Test
    void getVersionLabels_success() throws Exception {
        when(versionHistoryMock.getVersionLabels()).thenReturn(new String[]{"label1", "label2"});

        assertEquals(2, versionHistory.getVersionLabels().length);
    }

    @Test
    void getVersionLabels_exception() throws Exception {
        when(versionHistoryMock.getVersionLabels()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getVersionLabels());
    }

    @Test
    void getVersionLabels_withVersion_success() throws Exception {
        StreamVersion streamVersion = mock(StreamVersion.class);
        Version version = mock(Version.class);
        when(streamVersion.getVersion()).thenReturn(version);
        when(versionHistoryMock.getVersionLabels(any(Version.class))).thenReturn(new String[]{"label1", "label2"});

        assertEquals(2, versionHistory.getVersionLabels(streamVersion).length);
    }

    @Test
    void getVersionLabels_withVersion_exception() throws Exception {
        StreamVersion streamVersion = mock(StreamVersion.class);
        Version version = mock(Version.class);
        when(streamVersion.getVersion()).thenReturn(version);
        when(versionHistoryMock.getVersionLabels(any(Version.class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> versionHistory.getVersionLabels(streamVersion));
    }

    @Test
    void removeVersion_success() throws Exception {
        versionHistory.removeVersion("label");
        verify(versionHistoryMock).removeVersion(anyString());
    }

    @Test
    void removeVersion_exception() throws Exception {
        doThrow(RepositoryException.class).when(versionHistoryMock).removeVersion(anyString());

        assertThrows(ModernJcrException.class, () -> versionHistory.removeVersion("label"));
    }
}