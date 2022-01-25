package com.question1;

/*Q1. Implement singleton design pattern, to ensure that a class have only one instance
and provide global point of access to it While designing singleton pattern consider following factors, what is good progamming
practice about singleton pattern?
1. Eager initialization
2. Static block initialization
3. Lazy Initialization
4. Thread Safe Singleton
5. Serialization issue
6. Cloning issue
7. Using Reflection to destroy Singleton Pattern
8. Enum Singleton
*/

import java.io.Serializable;

enum MySingleton {
	INSTANCE;
}

class Singleton implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	// threads have a local cache and that can lead to creation of more than one object 
	// we use volatile along with double locking
	private static volatile Singleton singleton = null;	//lazy instantiation

	private Singleton() {
		if (singleton != null) {
			//Reflection issue
			//if someone tries to create an object by calling the constructor through reflection
			//we avoid that by checking if we already have an object and throw an exception
			throw new IllegalStateException();
		}
	}

	public static Singleton getSingleton10() {
		if (singleton == null) {
			if (singleton == null) {
				//it is possible in case of single locking that two or more threads might enter the block and create more that one object
				//hence by double locking 
				synchronized (Singleton.class) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	// even this double locking method can be very confusing so there is an alternate approach that is Static instance holder

	/*
	 * 5. AVOIDING SERIALIZATION ISSUE 
	 * We define readResolve(), this is a special method that tells JVM to not to deserializee our object
	 * and return the same singleton object as generated. [Same hashcode]
	 */
	private Object readResolve() {
		return singleton;
	}

	/*
	 * 6. Clonning Issue
	 * someone might try to Clone our Object, we override the clone method and return the same singleton object instead.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return singleton;
	}
}

public class Question1 {
	public static void main(String[] args) {
		//ENUMs are the best way to implement singleton design patterns as they are singleton by default
		//But it is also a misuse of the Enum 
		MySingleton singletonEnum = MySingleton.INSTANCE;
		System.out.println(singletonEnum.hashCode());
		
		MySingleton singletonEnum2 = MySingleton.INSTANCE;
		System.out.println(singletonEnum2.hashCode());
	}
}
