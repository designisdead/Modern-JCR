package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import lombok.Getter;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.stream.Stream;

public class StreamNode extends StreamItem {

    @Getter
    private final Node node;

    public StreamNode(Node node) {
        super(node);
        this.node = node;
    }

    public StreamNode addNode(String relPath) {
        return addNode(relPath, null);
    }

    public StreamNode addNode(String relPath, String primaryNodeTypeName) {
        try {
            return new StreamNode(node.addNode(relPath, primaryNodeTypeName));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void orderBefore(String srcChildRelPath, String destChildRelPath) {
        try {
            node.orderBefore(srcChildRelPath, destChildRelPath);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, Value value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, Value value, int type) {
        try {
            return new StreamProperty(node.setProperty(name, value, type));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, Value... values) {
        try {
            return new StreamProperty(node.setProperty(name, values));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, Value[] values, int type) {
        try {
            return new StreamProperty(node.setProperty(name, values, type));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, String... values) {
        try {
            return new StreamProperty(node.setProperty(name, values));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, String[] values, int type) {
        try {
            return new StreamProperty(node.setProperty(name, values, type));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, String value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, String value, int type) {
        try {
            return new StreamProperty(node.setProperty(name, value, type));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, Binary value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, boolean value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, double value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, BigDecimal value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, long value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, Calendar value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty setProperty(String name, Node value) {
        try {
            return new StreamProperty(node.setProperty(name, value));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamNode getNode(String relPath) {
        try {
            return new StreamNode(node.getNode(relPath));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamNode> getNodes() {
        try {
            return ModernJcr.asStream(node.getNodes());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamNode> getNodes(String namePattern) {
        try {
            return ModernJcr.asStream(node.getNodes(namePattern));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamNode> getNodes(String... nameGlobs) {
        try {
            return ModernJcr.asStream(node.getNodes(nameGlobs));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamProperty getProperty(String relPath) {
        try {
            return new StreamProperty(node.getProperty(relPath));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamProperty> getProperties() {
        try {
            return ModernJcr.asStream(node.getProperties());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamProperty> getProperties(String namePattern) {
        try {
            return ModernJcr.asStream(node.getProperties(namePattern));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamProperty> getProperties(String... nameGlobs) {
        try {
            return ModernJcr.asStream(node.getProperties(nameGlobs));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamItem getPrimaryItem() {
        try {
            return new StreamItem(node.getPrimaryItem());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String getIdentifier() {
        try {
            return node.getIdentifier();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public int getIndex() {
        try {
            return node.getIndex();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamProperty> getReferences() {
        try {
            return ModernJcr.asStream(node.getReferences());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamProperty> getReferences(String name) {
        try {
            return ModernJcr.asStream(node.getReferences(name));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamProperty> getWeakReferences() {
        try {
            return ModernJcr.asStream(node.getWeakReferences());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamProperty> getWeakReferences(String name) {
        try {
            return ModernJcr.asStream(node.getWeakReferences(name));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean hasNode(String relPath) {
        try {
            return node.hasNode(relPath);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean hasProperty(String relPath) {
        try {
            return node.hasProperty(relPath);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean hasNodes() {
        try {
            return node.hasNodes();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean hasProperties() {
        try {
            return node.hasProperties();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public NodeType getPrimaryNodeType() {
        try {
            return node.getPrimaryNodeType();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public NodeType[] getMixinNodeTypes() {
        try {
            return node.getMixinNodeTypes();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean isNodeType(String nodeTypeName) {
        try {
            return node.isNodeType(nodeTypeName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void setPrimaryType(String nodeTypeName) {
        try {
            node.setPrimaryType(nodeTypeName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void addMixin(String mixinName) {
        try {
            node.addMixin(mixinName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void removeMixin(String mixinName) {
        try {
            node.removeMixin(mixinName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean canAddMixin(String mixinName) {
        try {
            return node.canAddMixin(mixinName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public NodeDefinition getDefinition() {
        try {
            return node.getDefinition();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void update(String srcWorkspace) {
        try {
            node.update(srcWorkspace);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String getCorrespondingNodePath(String workspaceName) {
        try {
            return node.getCorrespondingNodePath(workspaceName);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Stream<StreamNode> getSharedSet() {
        try {
            return ModernJcr.asStream(node.getSharedSet());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void removeSharedSet() {
        try {
            node.removeSharedSet();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void removeShare() {
        try {
            node.removeShare();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean isCheckedOut() {
        try {
            return node.isCheckedOut();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean isLocked() {
        try {
            return node.isLocked();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void followLifecycleTransition(String transition) {
        try {
            node.followLifecycleTransition(transition);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String[] getAllowedLifecycleTransistions() {
        try {
            return node.getAllowedLifecycleTransistions();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }
}
