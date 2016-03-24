package org.vegan.factory.reflection;

public abstract class Document {
	
	private String message;
	
    public Document() {
        System.out.println("New Document instance created: " + this.toString());
    }
    
    public Document(String message){
    	this.message = message;
    }
    
    public void printSlogan(){
    	System.out.println("We are the document company.");
    	System.out.println("The message is:  " + message);
    }
    
    public abstract void describeDocumentFunction();
}
