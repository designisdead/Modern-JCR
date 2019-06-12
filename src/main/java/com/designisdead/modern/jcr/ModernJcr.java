package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.observation.StreamEvent;
import com.designisdead.modern.jcr.query.StreamRow;
import lombok.experimental.UtilityClass;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;
import javax.jcr.security.AccessControlPolicy;
import javax.jcr.security.AccessControlPolicyIterator;
import javax.jcr.version.Version;
import javax.jcr.version.VersionIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@UtilityClass
public class ModernJcr {
    @SuppressWarnings("unchecked")
    public static Stream<StreamNode> asStream(NodeIterator nodes) {
        Spliterator<Node> spliterator = Spliterators.spliteratorUnknownSize(nodes, 0);
        return StreamSupport.stream(spliterator, false)
                .map(StreamNode::new);
    }

    @SuppressWarnings("unchecked")
    public static Stream<StreamProperty> asStream(PropertyIterator properties) {
        Spliterator<Property> spliterator = Spliterators.spliteratorUnknownSize(properties, 0);
        return StreamSupport.stream(spliterator, false)
                .map(StreamProperty::new);
    }

    @SuppressWarnings("unchecked")
    public static Stream<StreamVersion> asStream(VersionIterator properties) {
        Spliterator<Version> spliterator = Spliterators.spliteratorUnknownSize(properties, 0);
        return StreamSupport.stream(spliterator, false)
                .map(StreamVersion::new);
    }

    @SuppressWarnings("unchecked")
    public static Stream<AccessControlPolicy> asStream(AccessControlPolicyIterator accessControlPolicyIterator) {
        Spliterator<AccessControlPolicy> spliterator =
                Spliterators.spliteratorUnknownSize(accessControlPolicyIterator, 0);
        return StreamSupport.stream(spliterator, false);
    }

    @SuppressWarnings("unchecked")
    public static Stream<StreamRow> asStream(RowIterator rows) {
        Spliterator<Row> spliterator =
                Spliterators.spliteratorUnknownSize(rows, 0);
        return StreamSupport.stream(spliterator, false)
                .map(StreamRow::new);
    }

    @SuppressWarnings("unchecked")
    public static Stream<StreamEvent> asStream(EventIterator events) {
        Spliterator<Event> spliterator =
                Spliterators.spliteratorUnknownSize(events, 0);
        return StreamSupport.stream(spliterator, false)
                .map(StreamEvent::new);
    }

    @SuppressWarnings("unchecked")
    public static Stream<NodeType> asStream(NodeTypeIterator nodeTypes) {
        Spliterator<NodeType> spliterator =
                Spliterators.spliteratorUnknownSize(nodeTypes, 0);
        return StreamSupport.stream(spliterator, false);
    }
}
