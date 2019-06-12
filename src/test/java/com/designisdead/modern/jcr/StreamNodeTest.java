package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jcr.Binary;
import javax.jcr.Item;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;

import java.math.BigDecimal;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StreamNodeTest {

    @Mock
    private Node nodeMock;

    @InjectMocks
    private StreamNode node;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addNode_success() throws Exception {
        Node newNode = mock(Node.class);
        when(nodeMock.addNode(anyString(), eq(null))).thenReturn(newNode);

        assertNotNull(node.addNode("path"));
    }

    @Test
    void addNode_exception() throws Exception {
        when(nodeMock.addNode(anyString(), eq(null))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.addNode("path"));
    }

    @Test
    void addNode_withType_success() throws Exception {
        Node newNode = mock(Node.class);
        when(nodeMock.addNode(anyString(), anyString())).thenReturn(newNode);

        assertNotNull(node.addNode("path", "type"));
    }

    @Test
    void addNode_withType_exception() throws Exception {
        when(nodeMock.addNode(anyString(), anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.addNode("path", "type"));
    }


    @Test
    void orderBefore_success() throws Exception {
        node.orderBefore("src", "dest");
        verify(nodeMock).orderBefore(anyString(), anyString());
    }

    @Test
    void orderBefore_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).orderBefore(anyString(), anyString());

        assertThrows(ModernJcrException.class, () -> node.orderBefore("src", "dest"));
    }

    @Test
    void setProperty_value_success() throws Exception {
        Property property = mock(Property.class);
        Value value = mock(Value.class);

        when(nodeMock.setProperty(anyString(), any(Value.class))).thenReturn(property);

        assertNotNull(node.setProperty("prop", value));
    }

    @Test
    void setProperty_value_exception() throws Exception {
        Value value = mock(Value.class);

        when(nodeMock.setProperty(anyString(), any(Value.class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", value));
    }

    @Test
    void setProperty_value_withType_success() throws Exception {
        Property property = mock(Property.class);
        Value value = mock(Value.class);

        when(nodeMock.setProperty(anyString(), any(Value.class), anyInt())).thenReturn(property);

        assertNotNull(node.setProperty("prop", value, 1));
    }

    @Test
    void setProperty_value_withType_exception() throws Exception {
        Value value = mock(Value.class);

        when(nodeMock.setProperty(anyString(), any(Value.class), anyInt())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", value, 1));
    }

    @Test
    void setProperty_values_success() throws Exception {
        Property property = mock(Property.class);
        Value value = mock(Value.class);
        Value value2 = mock(Value.class);

        when(nodeMock.setProperty(anyString(), any(Value[].class))).thenReturn(property);

        assertNotNull(node.setProperty("prop", value, value2));
    }

    @Test
    void setProperty_values_exception() throws Exception {
        Value value = mock(Value.class);
        Value value2 = mock(Value.class);

        when(nodeMock.setProperty(anyString(), any(Value[].class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", new Value[]{value, value2}));
    }

    @Test
    void setProperty_values_withType_success() throws Exception {
        Property property = mock(Property.class);
        Value value = mock(Value.class);
        Value value2 = mock(Value.class);

        when(nodeMock.setProperty(anyString(), any(Value[].class), anyInt())).thenReturn(property);

        assertNotNull(node.setProperty("prop", new Value[]{value, value2}, 1));
    }

    @Test
    void setProperty_values_withType_exception() throws Exception {
        Value value = mock(Value.class);
        Value value2 = mock(Value.class);

        when(nodeMock.setProperty(anyString(), any(Value[].class), anyInt())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", new Value[]{value, value2}, 1));
    }

    @Test
    void setProperty_stringValues_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), any(String[].class))).thenReturn(property);

        assertNotNull(node.setProperty("prop", "v1", "v2"));
    }

    @Test
    void setProperty_stringValues_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), any(String[].class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", new String[]{"v1", "v2"}));
    }

    @Test
    void setProperty_stringValues_withType_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), any(String[].class), anyInt())).thenReturn(property);

        assertNotNull(node.setProperty("prop", new String[]{"v1", "v2"}, 9));
    }

    @Test
    void setProperty_stringValues_withType_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), any(String[].class), anyInt())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", new String[]{"v1", "v2"}, 9));
    }

    @Test
    void setProperty_stringValue_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), anyString())).thenReturn(property);

        assertNotNull(node.setProperty("prop", "v1"));
    }

    @Test
    void setProperty_stringValue_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", "v1"));
    }

    @Test
    void setProperty_stringValue_withType_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), anyString(), anyInt())).thenReturn(property);

        assertNotNull(node.setProperty("prop", "v1", 1));
    }

    @Test
    void setProperty_stringValue_withType_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), anyString(), anyInt())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", "v1", 1));
    }

    @Test
    void setProperty_binaryValue_success() throws Exception {
        Property property = mock(Property.class);
        Binary binary = mock(Binary.class);

        when(nodeMock.setProperty(anyString(), any(Binary.class))).thenReturn(property);

        assertNotNull(node.setProperty("prop", binary));
    }

    @Test
    void setProperty_binaryValue_exception() throws Exception {
        Binary binary = mock(Binary.class);
        when(nodeMock.setProperty(anyString(), any(Binary.class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", binary));
    }

    @Test
    void setProperty_booleanValue_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), anyBoolean())).thenReturn(property);

        assertNotNull(node.setProperty("prop", true));
    }

    @Test
    void setProperty_booleanValue_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), anyBoolean())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", true));
    }

    @Test
    void setProperty_doubleValue_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), anyDouble())).thenReturn(property);

        assertNotNull(node.setProperty("prop", 1.5));
    }

    @Test
    void setProperty_doubleValue_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), anyDouble())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", 1.5));
    }

    @Test
    void setProperty_bigDecimalValue_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), any(BigDecimal.class))).thenReturn(property);

        assertNotNull(node.setProperty("prop", new BigDecimal("5")));
    }

    @Test
    void setProperty_bigDecimalValue_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), any(BigDecimal.class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", new BigDecimal("5")));
    }

    @Test
    void setProperty_longValue_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), anyLong())).thenReturn(property);

        assertNotNull(node.setProperty("prop", 3L));
    }

    @Test
    void setProperty_longValue_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), anyLong())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", 3L));
    }

    @Test
    void setProperty_calendarValue_success() throws Exception {
        Property property = mock(Property.class);

        when(nodeMock.setProperty(anyString(), any(Calendar.class))).thenReturn(property);

        assertNotNull(node.setProperty("prop", Calendar.getInstance()));
    }

    @Test
    void setProperty_calendarValue_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), any(Calendar.class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", Calendar.getInstance()));
    }

    @Test
    void setProperty_nodeValue_success() throws Exception {
        Property property = mock(Property.class);
        Node propNode = mock(Node.class);

        when(nodeMock.setProperty(anyString(), any(Node.class))).thenReturn(property);

        assertNotNull(node.setProperty("prop", propNode));
    }

    @Test
    void setProperty_nodeValue_exception() throws Exception {
        when(nodeMock.setProperty(anyString(), any(Node.class))).thenThrow(RepositoryException.class);
        Node propNode = mock(Node.class);

        assertThrows(ModernJcrException.class, () -> node.setProperty("prop", propNode));
    }

    @Test
    void getNode_success() throws Exception {
        Node newNode = mock(Node.class);
        when(nodeMock.getNode(anyString())).thenReturn(newNode);

        assertNotNull(node.getNode("path"));
    }

    @Test
    void getNode_exception() throws Exception {
        when(nodeMock.getNode(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getNode("path"));
    }

    @Test
    void getNodes_success() throws Exception {
        NodeIterator iterator = mock(NodeIterator.class);
        when(nodeMock.getNodes()).thenReturn(iterator);

        assertNotNull(node.getNodes());
    }

    @Test
    void getNodes_exception() throws Exception {
        when(nodeMock.getNodes()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getNodes());
    }

    @Test
    void getNodes_withNamePattern_success() throws Exception {
        NodeIterator iterator = mock(NodeIterator.class);
        when(nodeMock.getNodes(anyString())).thenReturn(iterator);

        assertNotNull(node.getNodes("namePattern"));
    }

    @Test
    void getNodes_withNamePattern_exception() throws Exception {
        when(nodeMock.getNodes(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getNodes("namePattern"));
    }

    @Test
    void getNodes_withNameGlobs_success() throws Exception {
        NodeIterator iterator = mock(NodeIterator.class);
        when(nodeMock.getNodes(any(String[].class))).thenReturn(iterator);

        assertNotNull(node.getNodes("glob1", "glob2"));
    }

    @Test
    void getNodes_withNameGlobs_exception() throws Exception {
        when(nodeMock.getNodes(any(String[].class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getNodes(new String[]{"glob1", "glob2"}));
    }

    @Test
    void getProperty_success() throws Exception {
        Property property = mock(Property.class);
        when(nodeMock.getProperty(anyString())).thenReturn(property);

        assertNotNull(node.getProperty("propPath"));
    }

    @Test
    void getProperty_exception() throws Exception {
        when(nodeMock.getProperty(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getProperty("propPath"));
    }

    @Test
    void getProperties_success() throws Exception {
        PropertyIterator iterator = mock(PropertyIterator.class);
        when(nodeMock.getProperties()).thenReturn(iterator);

        assertNotNull(node.getProperties());
    }

    @Test
    void getProperties_exception() throws Exception {
        when(nodeMock.getProperties()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getProperties());
    }

    @Test
    void getProperties_withNamePattern_success() throws Exception {
        PropertyIterator iterator = mock(PropertyIterator.class);
        when(nodeMock.getProperties(anyString())).thenReturn(iterator);

        assertNotNull(node.getProperties("namePattern"));
    }

    @Test
    void getProperties_withNamePattern_exception() throws Exception {
        when(nodeMock.getProperties(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getProperties("namePattern"));
    }

    @Test
    void getProperties_withNameGlobs_success() throws Exception {
        PropertyIterator iterator = mock(PropertyIterator.class);
        when(nodeMock.getProperties(any(String[].class))).thenReturn(iterator);

        assertNotNull(node.getProperties("glob1", "glob2"));
    }

    @Test
    void getProperties_withNameGlobs_exception() throws Exception {
        when(nodeMock.getProperties(any(String[].class))).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getProperties(new String[]{"glob1", "glob2"}));
    }


    @Test
    void getPrimaryItem_success() throws Exception {
        Item item = mock(Item.class);
        when(nodeMock.getPrimaryItem()).thenReturn(item);

        assertNotNull(node.getPrimaryItem());
    }

    @Test
    void getPrimaryItem_exception() throws Exception {
        when(nodeMock.getPrimaryItem()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getPrimaryItem());
    }

    @Test
    void getIdentifier_success() throws Exception {
        when(nodeMock.getIdentifier()).thenReturn("identifier");

        assertEquals("identifier", node.getIdentifier());
    }

    @Test
    void getIdentifier_exception() throws Exception {
        when(nodeMock.getIdentifier()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getIdentifier());
    }

    @Test
    void getIndex_success() throws Exception {
        when(nodeMock.getIndex()).thenReturn(5);

        assertEquals(5, node.getIndex());
    }

    @Test
    void getIndex_exception() throws Exception {
        when(nodeMock.getIndex()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getIndex());
    }

    @Test
    void getReferences_success() throws Exception {
        PropertyIterator iterator = mock(PropertyIterator.class);
        when(nodeMock.getReferences()).thenReturn(iterator);

        assertNotNull(node.getReferences());
    }

    @Test
    void getReferences_exception() throws Exception {
        when(nodeMock.getReferences()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getReferences());
    }

    @Test
    void getReferences_withName_success() throws Exception {
        PropertyIterator iterator = mock(PropertyIterator.class);
        when(nodeMock.getReferences(anyString())).thenReturn(iterator);

        assertNotNull(node.getReferences("name"));
    }

    @Test
    void getReferences_withName_exception() throws Exception {
        when(nodeMock.getReferences(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getReferences("name"));
    }

    @Test
    void getWeakReferences_success() throws Exception {
        PropertyIterator iterator = mock(PropertyIterator.class);
        when(nodeMock.getWeakReferences()).thenReturn(iterator);

        assertNotNull(node.getWeakReferences());
    }

    @Test
    void getWeakReferences_exception() throws Exception {
        when(nodeMock.getWeakReferences()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getWeakReferences());
    }

    @Test
    void getWeakReferences_withName_success() throws Exception {
        PropertyIterator iterator = mock(PropertyIterator.class);
        when(nodeMock.getWeakReferences(anyString())).thenReturn(iterator);

        assertNotNull(node.getWeakReferences("name"));
    }

    @Test
    void getWeakReferences_withName_exception() throws Exception {
        when(nodeMock.getWeakReferences(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getWeakReferences("name"));
    }

    @Test
    void hasNode_success() throws Exception {
        when(nodeMock.hasNode(anyString())).thenReturn(true);

        assertTrue(node.hasNode("path"));
    }

    @Test
    void hasNode_exception() throws Exception {
        when(nodeMock.hasNode(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.hasNode("name"));
    }

    @Test
    void hasProperty_success() throws Exception {
        when(nodeMock.hasProperty(anyString())).thenReturn(true);

        assertTrue(node.hasProperty("prop"));
    }

    @Test
    void hasProperty_exception() throws Exception {
        when(nodeMock.hasProperty(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.hasProperty("prop"));
    }

    @Test
    void hasNodes_success() throws Exception {
        when(nodeMock.hasNodes()).thenReturn(true);

        assertTrue(node.hasNodes());
    }

    @Test
    void hasNodes_exception() throws Exception {
        when(nodeMock.hasNodes()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.hasNodes());
    }

    @Test
    void hasProperties_success() throws Exception {
        when(nodeMock.hasProperties()).thenReturn(true);

        assertTrue(node.hasProperties());
    }

    @Test
    void hasProperties_exception() throws Exception {
        when(nodeMock.hasProperties()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.hasProperties());
    }

    @Test
    void getPrimaryNodeType_success() throws Exception {
        NodeType nodeType = mock(NodeType.class);
        when(nodeMock.getPrimaryNodeType()).thenReturn(nodeType);

        assertNotNull(node.getPrimaryNodeType());
    }

    @Test
    void getPrimaryNodeType_exception() throws Exception {
        when(nodeMock.getPrimaryNodeType()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getPrimaryNodeType());
    }

    @Test
    void getMixinNodeTypes_success() throws Exception {
        NodeType nodeType1 = mock(NodeType.class);
        NodeType nodeType2 = mock(NodeType.class);

        when(nodeMock.getMixinNodeTypes()).thenReturn(new NodeType[]{nodeType1, nodeType2});

        assertEquals(2, node.getMixinNodeTypes().length);
    }

    @Test
    void getMixinNodeTypes_exception() throws Exception {
        when(nodeMock.getMixinNodeTypes()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getMixinNodeTypes());
    }

    @Test
    void isNodeType_success() throws Exception {
        when(nodeMock.isNodeType(anyString())).thenReturn(true);

        assertTrue(node.isNodeType("nodeType"));
    }

    @Test
    void isNodeType_exception() throws Exception {
        when(nodeMock.isNodeType(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.isNodeType("nodeType"));
    }

    @Test
    void setPrimaryType_success() throws Exception {
        node.setPrimaryType("primaryType");
        verify(nodeMock).setPrimaryType(anyString());
    }

    @Test
    void setPrimaryType_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).setPrimaryType(anyString());

        assertThrows(ModernJcrException.class, () -> node.setPrimaryType("nodeType"));
    }

    @Test
    void addMixin_success() throws Exception {
        node.addMixin("mixin");
        verify(nodeMock).addMixin(anyString());
    }

    @Test
    void addMixin_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).addMixin(anyString());

        assertThrows(ModernJcrException.class, () -> node.addMixin("mixin"));
    }

    @Test
    void removeMixin_success() throws Exception {
        node.removeMixin("mixin");
        verify(nodeMock).removeMixin(anyString());
    }

    @Test
    void removeMixin_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).removeMixin(anyString());

        assertThrows(ModernJcrException.class, () -> node.removeMixin("mixin"));
    }

    @Test
    void canAddMixin_success() throws Exception {
        when(nodeMock.canAddMixin(anyString())).thenReturn(true);

        assertTrue(node.canAddMixin("mixin"));
    }

    @Test
    void canAddMixin_exception() throws Exception {
        when(nodeMock.canAddMixin(anyString())).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.canAddMixin("mixin"));
    }

    @Test
    void getDefinition_success() throws Exception {
        NodeDefinition nodeDefinition = mock(NodeDefinition.class);
        when(nodeMock.getDefinition()).thenReturn(nodeDefinition);

        assertNotNull(node.getDefinition());
    }

    @Test
    void getDefinition_exception() throws Exception {
        when(nodeMock.getDefinition()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getDefinition());
    }

    @Test
    void update_success() throws Exception {
        node.update("src");
        verify(nodeMock).update(anyString());
    }

    @Test
    void update_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).update(anyString());

        assertThrows(ModernJcrException.class, () -> node.update("src"));
    }

    @Test
    void getCorrespondingNodePath_success() throws Exception {
        node.getCorrespondingNodePath("workspace");
        verify(nodeMock).getCorrespondingNodePath(anyString());
    }

    @Test
    void getCorrespondingNodePath_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).getCorrespondingNodePath(anyString());

        assertThrows(ModernJcrException.class, () -> node.getCorrespondingNodePath("workspace"));
    }

    @Test
    void getSharedSet_success() throws Exception {
        NodeIterator iterator = mock(NodeIterator.class);
        when(nodeMock.getSharedSet()).thenReturn(iterator);

        assertNotNull(node.getSharedSet());
    }

    @Test
    void getSharedSet_exception() throws Exception {
        when(nodeMock.getSharedSet()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getSharedSet());
    }

    @Test
    void removeSharedSet_success() throws Exception {
        node.removeSharedSet();
        verify(nodeMock).removeSharedSet();
    }

    @Test
    void removeSharedSet_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).removeSharedSet();

        assertThrows(ModernJcrException.class, () -> node.removeSharedSet());
    }

    @Test
    void removeShare_success() throws Exception {
        node.removeShare();
        verify(nodeMock).removeShare();
    }

    @Test
    void removeShare_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).removeShare();

        assertThrows(ModernJcrException.class, () -> node.removeShare());
    }

    @Test
    void isCheckedOut_success() throws Exception {
        when(nodeMock.isCheckedOut()).thenReturn(true);
        assertTrue(node.isCheckedOut());
    }

    @Test
    void isCheckedOut_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).isCheckedOut();

        assertThrows(ModernJcrException.class, () -> node.isCheckedOut());
    }

    @Test
    void isLocked_success() throws Exception {
        when(nodeMock.isLocked()).thenReturn(true);
        assertTrue(node.isLocked());
    }

    @Test
    void isLocked_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).isLocked();

        assertThrows(ModernJcrException.class, () -> node.isLocked());
    }

    @Test
    void followLifecycleTransition_success() throws Exception {
        node.followLifecycleTransition("transition");
        verify(nodeMock).followLifecycleTransition(anyString());
    }

    @Test
    void followLifecycleTransition_exception() throws Exception {
        doThrow(RepositoryException.class).when(nodeMock).followLifecycleTransition(anyString());

        assertThrows(ModernJcrException.class, () -> node.followLifecycleTransition("transition"));
    }

    @Test
    void getAllowedLifecycleTransistions_success() throws Exception {
        when(nodeMock.getAllowedLifecycleTransistions()).thenReturn(new String[]{"trans1", "trans2"});

        assertEquals(2, node.getAllowedLifecycleTransistions().length);
    }

    @Test
    void getAllowedLifecycleTransistions_exception() throws Exception {
        when(nodeMock.getAllowedLifecycleTransistions()).thenThrow(RepositoryException.class);

        assertThrows(ModernJcrException.class, () -> node.getAllowedLifecycleTransistions());
    }

}