package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.nodetype.PropertyDefinition;
import java.math.BigDecimal;
import java.util.Calendar;

public class StreamProperty extends StreamItem {

    private final Property property;

    public StreamProperty(Property property) {
        super(property);
        this.property = property;
    }

    public void setValue(Value value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(Value... values) {
        try {
            property.setValue(values);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(String value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(String... values) {
        try {
            property.setValue(values);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(Binary value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(long value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(double value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(BigDecimal value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(Calendar value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(boolean value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setValue(Node value) {
        try {
            property.setValue(value);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Value getValue() {
        try {
            return property.getValue();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Value[] getValues() {
        try {
            return property.getValues();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String getString() {
        try {
            return property.getString();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamBinary getBinary() {
        try {
            return new StreamBinary(property.getBinary());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public long getLong() {
        try {
            return property.getLong();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public double getDouble() {
        try {
            return property.getDouble();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public BigDecimal getDecimal() {
        try {
            return property.getDecimal();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Calendar getDate() {
        try {
            return property.getDate();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean getBoolean() {
        try {
            return property.getBoolean();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamNode getNode() {
        try {
            return new StreamNode(property.getNode());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty getProperty() {
        try {
            return new StreamProperty(property.getProperty());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public long getLength() {
        try {
            return property.getLength();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public long[] getLengths() {
        try {
            return property.getLengths();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public PropertyDefinition getDefinition() {
        try {
            return property.getDefinition();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public int getType() {
        try {
            return property.getType();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean isMultiple() {
        try {
            return property.isMultiple();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Property getNativeProperty() {
        return property;
    }
}
