package com.designisdead.modern.jcr.observation;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.jcr.RepositoryException;
import javax.jcr.observation.Event;
import java.util.Map;

@RequiredArgsConstructor
public class StreamEvent {

    @Getter
    private final Event event;

    public int getType() {
        return event.getType();
    }

    public String getPath() {
        try {
            return event.getPath();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String getUserID() {
        return event.getUserID();
    }

    public String getIdentifier() {
        try {
            return event.getIdentifier();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Map getInfo() {
        try {
            return event.getInfo();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String getUserData() {
        try {
            return event.getUserData();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public long getDate() {
        try {
            return event.getDate();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }
}
