package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import lombok.Getter;

import javax.jcr.RepositoryException;
import javax.jcr.version.Version;
import java.util.Calendar;
import java.util.stream.Stream;

public class StreamVersion extends StreamNode {

    @Getter
    private final Version version;

    public StreamVersion(Version version) {
        super(version);

        this.version = version;
    }

    public StreamVersionHistory getContainingHistory() {
        try {
            return new StreamVersionHistory(version.getContainingHistory());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Calendar getCreated() {
        try {
            return version.getCreated();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamVersion getLinearSuccessor() {
        try {
            return new StreamVersion(version.getLinearSuccessor());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamVersion[] getSuccessors() {
        try {
            return Stream.of(version.getSuccessors())
                    .map(StreamVersion::new)
                    .toArray(StreamVersion[]::new);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamVersion getLinearPredecessor() {
        try {
            return new StreamVersion(version.getLinearPredecessor());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamVersion[] getPredecessors() {
        try {
            return Stream.of(version.getPredecessors())
                    .map(StreamVersion::new)
                    .toArray(StreamVersion[]::new);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamNode getFrozenNode() {
        try {
            return new StreamNode(version.getFrozenNode());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }
}
