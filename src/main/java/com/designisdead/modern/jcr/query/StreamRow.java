package com.designisdead.modern.jcr.query;

import com.designisdead.modern.jcr.StreamNode;
import com.designisdead.modern.jcr.exception.ModernJcrException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.query.Row;

@RequiredArgsConstructor
public class StreamRow {

    @Getter
    private final Row row;


    public Value[] getValues() {
        try {
            return row.getValues();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Value getValue(String columnName) {
        try {
            return row.getValue(columnName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamNode getNode() {
        try {
            return new StreamNode(row.getNode());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamNode getNode(String selectorName) {
        try {
            return new StreamNode(row.getNode(selectorName));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String getPath() {
        try {
            return row.getPath();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String getPath(String selectorName) {
        try {
            return row.getPath(selectorName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public double getScore() {
        try {
            return row.getScore();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public double getScore(String selectorName) {
        try {
            return row.getScore(selectorName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }
}
