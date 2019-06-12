package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import lombok.Getter;

import javax.jcr.RepositoryException;
import javax.jcr.version.VersionHistory;
import java.util.stream.Stream;

public class StreamVersionHistory extends StreamNode {

    @Getter
    private VersionHistory versionHistory;

    public StreamVersionHistory(VersionHistory versionHistory) {
        super(versionHistory);
        this.versionHistory = versionHistory;
    }

    public String getVersionableIdentifier() {
        try {
            return versionHistory.getVersionableIdentifier();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamVersion getRootVersion() {
        try {
            return new StreamVersion(versionHistory.getRootVersion());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamVersion> getAllLinearVersions() {
        try {
            return ModernJcr.asStream(versionHistory.getAllLinearVersions());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamVersion> getAllVersions() {
        try {
            return ModernJcr.asStream(versionHistory.getAllVersions());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamNode> getAllLinearFrozenNodes() {
        try {
            return ModernJcr.asStream(versionHistory.getAllLinearFrozenNodes());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamNode> getAllFrozenNodes() {
        try {
            return ModernJcr.asStream(versionHistory.getAllFrozenNodes());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamVersion getVersion(String versionName) {
        try {
            return new StreamVersion(versionHistory.getVersion(versionName));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamVersion getVersionByLabel(String label) {
        try {
            return new StreamVersion(versionHistory.getVersionByLabel(label));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void addVersionLabel(String versionName, String label, boolean moveLabel) {
        try {
            versionHistory.addVersionLabel(versionName, label, moveLabel);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void removeVersionLabel(String label) {
        try {
            versionHistory.removeVersionLabel(label);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean hasVersionLabel(String label) {
        try {
            return versionHistory.hasVersionLabel(label);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean hasVersionLabel(StreamVersion version, String label) {
        try {
            return versionHistory.hasVersionLabel(version.getVersion(), label);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String[] getVersionLabels() {
        try {
            return versionHistory.getVersionLabels();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String[] getVersionLabels(StreamVersion version) {
        try {
            return versionHistory.getVersionLabels(version.getVersion());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void removeVersion(String versionName) {
        try {
            versionHistory.removeVersion(versionName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }
}
