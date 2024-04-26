package com.learning.designpatterns.behavioral.templatemethod;
public abstract class HouseBuilder {
    // Template method
    public final void buildHouse() {
        buildFoundation();
        buildWalls();
        buildRoof();
        furnishHouse();
        if (addExtraFeatures()) {
            addExtra();
        }
    }

    // These methods are abstract and must be implemented by subclasses
    protected abstract void buildFoundation();
    protected abstract void buildWalls();
    protected abstract void buildRoof();
    protected abstract void furnishHouse();

    // Hook method - subclasses can override this to add extra features
    protected boolean addExtraFeatures() {
        return true;
    }

    // This method is optional and can be overridden by subclasses to add extra features
    protected void addExtra() {
        System.out.println("Adding extra features");
    }
}