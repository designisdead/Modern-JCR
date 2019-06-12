package com.designisdead.modern.jcr;

import com.designisdead.modern.jcr.exception.ModernJcrException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.jcr.Item;
import javax.jcr.ItemVisitor;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

@RequiredArgsConstructor
public class StreamItem {

    @Getter
    private final Item item;

    public String getPath() {
        try {
            return item.getPath();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public String getName() {
        try {
            return item.getName();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamItem getAncestor(int depth) {
        try {
            return new StreamItem(item.getAncestor(depth));
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public StreamNode getParent() {
        try {
            return new StreamNode(item.getParent());
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public int getDepth() {
        try {
            return item.getDepth();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public Session getSession() {
        try {
            return item.getSession();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public boolean isNode() {
        return item.isNode();
    }

    public boolean isNew() {
        return item.isNew();
    }

    public boolean isModified() {
        return item.isModified();
    }

    public boolean isSame(Item otherItem) {
        try {
            return item.isSame(otherItem);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void accept(ItemVisitor visitor) {
        try {
            item.accept(visitor);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }


    public void refresh(boolean keepChanges) {
        try {
            item.refresh(keepChanges);
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

    public void remove() {
        try {
            item.remove();
        } catch (RepositoryException e) {
            throw new ModernJcrException(e);
        }
    }

}
