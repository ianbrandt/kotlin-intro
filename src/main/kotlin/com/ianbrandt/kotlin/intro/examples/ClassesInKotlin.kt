package com.ianbrandt.kotlin.intro.examples

// Kotlin has classes, much like in Java

class Class

// No curly braces required if there's no body
// Kotlin keeps it terse like that


// Kotlin classes are final by default
//class AttemptedSubclass : Class() // Does not compile (see bytecode)

// See "Effective Java, 3rd Edition" by Joshua Bloch
// Item 19: DESIGN AND DOCUMENT FOR INHERITANCE OR ELSE PROHIBIT IT

// You can explicitly "open" a Kotlin class for inheritance like so...
open class BaseClass {

	// Kotlin has methods (i.e. functions), and they're "fun"! 😏
	fun finalFunction() {
		println("Can't touch this!")
	}

	// As with classes, functions are final in Kotlin by default
	// They can of course be opened too...
	open fun openFunction() {
		println("Base class implementation")
	}
}

class Subclass : BaseClass() {

	// Does not compile...
//	fun finalFunction() {
//		println("nope!")
//	}

	// You can explicitly override open functions
	override fun openFunction() {
		println("Subclass implementation")
	}
}

fun main() {

	// There's no 'new' keyword in Kotlin
	// Just invoke the constructor function...
	val clazz = Class()

	println(clazz)

	val baseClass = BaseClass()
	val subclass = Subclass()

	baseClass.finalFunction()
	subclass.finalFunction()

	baseClass.openFunction()
	subclass.openFunction()
}
