package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.nodetype.PropertyDefinition;

import java.math.BigDecimal;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StreamPropertyTest {

    @Mock
    private Property propertyMock;

    @InjectMocks
    private StreamProperty property;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void setValue_value_success() throws Exception {
        Value value = mock(Value.class);

        property.setValue(value);
        verify(propertyMock).setValue(any(Value.class));
    }

    @Test
    void setValue_value_exception() throws Exception {
        Value value = mock(Value.class);

        doThrow(RepositoryException.class).when(propertyMock).setValue(any(Value.class));

        assertThrows(ModernJcrException.class, () -> property.setValue(value));
    }

    @Test
    void setValue_values_success() throws Exception {
        Value value1 = mock(Value.class);
        Value value2 = mock(Value.class);

        property.setValue(value1, value2);
        verify(propertyMock).setValue(any(Value[].class));
    }

    @Test
    void setValue_values_exception() throws Exception {
        Value value1 = mock(Value.class);
        Value value2 = mock(Value.class);

        doThrow(RepositoryException.class).when(propertyMock).setValue(any(Value[].class));

        assertThrows(ModernJcrException.class, () -> property.setValue(value1, value2));
    }

    @Test
    void setValue_stringValue_success() throws Exception {
        property.setValue("value");
        verify(propertyMock).setValue(anyString());
    }

    @Test
    void setValue_stringValue_exception() throws Exception {
        doThrow(RepositoryException.class).when(propertyMock).setValue(anyString());

        assertThrows(ModernJcrException.class, () -> property.setValue("value"));
    }

    @Test
    void setValue_stringValues_success() throws Exception {
        property.setValue("value1", "value2");
        verify(propertyMock).setValue(any(String[].class));
    }

    @Test
    void setValue_stringValues_exception() throws Exception {
        doThrow(RepositoryException.class).when(propertyMock).setValue(any(String[].class));

        assertThrows(ModernJcrException.class, () -> property.setValue("value1", "value2"));
    }

    @Test
    void setValue_binaryValue_success() throws Exception {
        Binary value = mock(Binary.class);

        property.setValue(value);
        verify(propertyMock).setValue(any(Binary.class));
    }

    @Test
    void setValue_binaryValue_exception() throws Exception {
        Binary value = mock(Binary.class);

        doThrow(RepositoryException.class).when(propertyMock).setValue(any(Binary.class));

        assertThrows(ModernJcrException.class, () -> property.setValue(value));
    }

    @Test
    void setValue_longValue_success() throws Exception {
        property.setValue(1L);
        verify(propertyMock).setValue(anyLong());
    }

    @Test
    void setValue_longValue_exception() throws Exception {
        doThrow(RepositoryException.class).when(propertyMock).setValue(anyLong());

        assertThrows(ModernJcrException.class, () -> property.setValue(1L));
    }

    @Test
    void setValue_bigdecimalValue_success() throws Exception {
        property.setValue(new BigDecimal("1"));
        verify(propertyMock).setValue(any(BigDecimal.class));
    }

    @Test
    void setValue_bigdecimalValue_exception() throws Exception {
        doThrow(RepositoryException.class).when(propertyMock).setValue(any(BigDecimal.class));

        assertThrows(ModernJcrException.class, () -> property.setValue(new BigDecimal("1")));
    }

    @Test
    void setValue_doubleValue_success() throws Exception {
        property.setValue(2.5);
        verify(propertyMock).setValue(anyDouble());
    }

    @Test
    void setValue_doubleValue_exception() throws Exception {
        doThrow(RepositoryException.class).when(propertyMock).setValue(anyDouble());

        assertThrows(ModernJcrException.class, () -> property.setValue(2.5));
    }

    @Test
    void setValue_calendarValue_success() throws Exception {
        property.setValue(Calendar.getInstance());
        verify(propertyMock).setValue(any(Calendar.class));
    }

    @Test
    void setValue_calendarValue_exception() throws Exception {
        doThrow(RepositoryException.class).when(propertyMock).setValue(any(Calendar.class));

        assertThrows(ModernJcrException.class, () -> property.setValue(Calendar.getInstance()));
    }

    @Test
    void setValue_boolValue_success() throws Exception {
        property.setValue(true);
        verify(propertyMock).setValue(anyBoolean());
    }

    @Test
    void setValue_boolValue_exception() throws Exception {
        doThrow(RepositoryException.class).when(propertyMock).setValue(anyBoolean());

        assertThrows(ModernJcrException.class, () -> property.setValue(true));
    }

    @Test
    void setValue_nodeValue_success() throws Exception {
        Node value = mock(Node.class);

        property.setValue(value);
        verify(propertyMock).setValue(any(Node.class));
    }

    @Test
    void setValue_nodeValue_exception() throws Exception {
        Node value = mock(Node.class);

        doThrow(RepositoryException.class).when(propertyMock).setValue(any(Node.class));

        assertThrows(ModernJcrException.class, () -> property.setValue(value));
    }

    @Test
    void getValue_success() throws Exception {
        Value value = mock(Value.class);
        when(propertyMock.getValue()).thenReturn(value);

        assertNotNull(property.getValue());
    }

    @Test
    void getValue_exception() throws Exception {
        when(propertyMock.getValue()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getValue());
    }

    @Test
    void getValues_success() throws Exception {
        Value value = mock(Value.class);
        when(propertyMock.getValues()).thenReturn(new Value[]{value, value});

        assertEquals(2, property.getValues().length);
    }

    @Test
    void getValues_exception() throws Exception {
        when(propertyMock.getValues()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getValues());
    }

    @Test
    void getString_success() throws Exception {
        when(propertyMock.getString()).thenReturn("value");

        assertEquals("value", property.getString());
    }

    @Test
    void getString_exception() throws Exception {
        when(propertyMock.getString()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getString());
    }

    @Test
    void getBinary_success() throws Exception {
        Binary binary = mock(Binary.class);
        when(propertyMock.getBinary()).thenReturn(binary);

        assertNotNull(property.getBinary());
    }

    @Test
    void getBinary_exception() throws Exception {
        when(propertyMock.getBinary()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getBinary());
    }

    @Test
    void getLong_success() throws Exception {
        when(propertyMock.getLong()).thenReturn(1L);

        assertEquals(1L, property.getLong());
    }

    @Test
    void getLong_exception() throws Exception {
        when(propertyMock.getLong()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getLong());
    }

    @Test
    void getDouble_success() throws Exception {
        when(propertyMock.getDouble()).thenReturn(1.5);

        assertEquals(1.5, property.getDouble());
    }

    @Test
    void getDouble_exception() throws Exception {
        when(propertyMock.getDouble()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getDouble());
    }

    @Test
    void getDecimal_success() throws Exception {
        when(propertyMock.getDecimal()).thenReturn(new BigDecimal("1.5"));

        assertNotNull(property.getDecimal());
    }

    @Test
    void getDecimal_exception() throws Exception {
        when(propertyMock.getDecimal()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getDecimal());
    }

    @Test
    void getDate_success() throws Exception {
        when(propertyMock.getDate()).thenReturn(Calendar.getInstance());

        assertNotNull(property.getDate());
    }

    @Test
    void getDate_exception() throws Exception {
        when(propertyMock.getDate()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getDate());
    }

    @Test
    void getBoolean_success() throws Exception {
        when(propertyMock.getBoolean()).thenReturn(true);

        assertTrue(property.getBoolean());
    }

    @Test
    void getBoolean_exception() throws Exception {
        when(propertyMock.getBoolean()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getBoolean());
    }

    @Test
    void getNode_success() throws Exception {
        Node node = mock(Node.class);
        when(propertyMock.getNode()).thenReturn(node);

        assertNotNull(property.getNode());
    }

    @Test
    void getNode_exception() throws Exception {
        when(propertyMock.getNode()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getNode());
    }

    @Test
    void getProperty_success() throws Exception {
        Property prop = mock(Property.class);
        when(propertyMock.getProperty()).thenReturn(prop);

        assertNotNull(this.property.getProperty());
    }

    @Test
    void getProperty_exception() throws Exception {
        when(propertyMock.getProperty()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getProperty());
    }

    @Test
    void getLength_success() throws Exception {
        when(propertyMock.getLength()).thenReturn(1L);

        assertEquals(1L, property.getLength());
    }

    @Test
    void getLength_exception() throws Exception {
        when(propertyMock.getLength()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getLength());
    }

    @Test
    void getLengths_success() throws Exception {
        when(propertyMock.getLengths()).thenReturn(new long[]  {1L, 2L});

        assertEquals(2, property.getLengths().length);
    }

    @Test
    void getLengths_exception() throws Exception {
        when(propertyMock.getLengths()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getLengths());
    }

    @Test
    void getDefinition_success() throws Exception {
        PropertyDefinition definition = mock(PropertyDefinition.class);
        when(propertyMock.getDefinition()).thenReturn(definition);

        assertNotNull(property.getDefinition());
    }

    @Test
    void getDefinition_exception() throws Exception {
        when(propertyMock.getDefinition()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getDefinition());
    }

    @Test
    void getType_success() throws Exception {
        when(propertyMock.getType()).thenReturn(1);

        assertEquals(1, property.getType());
    }

    @Test
    void getType_exception() throws Exception {
        when(propertyMock.getType()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.getType());
    }

    @Test
    void isMultiple_success() throws Exception {
        when(propertyMock.isMultiple()).thenReturn(true);

        assertTrue(property.isMultiple());
    }

    @Test
    void isMultiple_exception() throws Exception {
        when(propertyMock.isMultiple()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> property.isMultiple());
    }
}