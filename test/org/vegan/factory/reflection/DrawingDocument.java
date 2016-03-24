package org.vegan.factory.reflection;

public class DrawingDocument extends Document {
    public DrawingDocument() {
        System.out.println("New DrawingDocument instance created: " + this.toString());
    }

	@Override
	public void describeDocumentFunction() {
		System.out.println("This document has drawings on it, and is good for architecual and design diagrams");
		
	}
}
