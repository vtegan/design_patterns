package org.vegan.factory.reflection;

public class DocumentFactory {

	public Document createDocument(Class<? extends Document> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		}
	}


	//This url may have a better design.
	//http://www.hubberspot.com/2012/11/how-to-implement-factory-design-pattern.html
	public Document createDocument(String className, String message){
		try {
			@SuppressWarnings("unchecked")
			Class<Document> cl = (Class<Document>) Class.forName(className);
			Document doc = cl.newInstance();
			
			return doc;

			//The code below would also work.
			//Class<?> cl = Class.forName(className);
			//Document doc = (Document) cl.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
