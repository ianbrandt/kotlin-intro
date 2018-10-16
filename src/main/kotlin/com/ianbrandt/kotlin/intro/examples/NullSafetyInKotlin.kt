package com.ianbrandt.kotlin.intro.examples

fun main() {

	// Types by default are non-nullable in Kotlin

	var name: String = ""
	name = "Ezra"
//	name = null // Does not compile

	// You have to explicitly declare a variable as a nullable type
	// (if you really want that 🤔)

	var nullableName: String? = "Bridger"
//	nullableName = null



	// Directly referencing a property or calling a function on a nullable
	// type is a compile-time error

	println("Non-nullable name length: ${name.length}")

//	println(nullableName.length) // Does not compile

	// Kotlin has the null-safe dereference operator for that
	println("Safe nullable name length: ${nullableName?.length}")


	// The compiler is smart about safe calls on nullable types
	// This is called "smart casting"

	if (nullableName != null) {
		println("Smart casted nullable name length: ${nullableName.length}")
	}


	// And there's so much more that we probably don't have time for...

	val possiblyNullNames = listOf("Ezra", null, "Luke")

	for (possibleName in possiblyNullNames) {
		possibleName?.let { println("Let's only print non-null names: $it") }
	}

	for (possibleName in possiblyNullNames) {
		val defaultedName = possibleName ?: "Elvis"
		println(
			"""Or we could use the "Elvis" operator to default null names: $defaultedName""")
	}

	try {
		val requiredName =
			nullableName ?: throw IllegalArgumentException(
				"Or we could throw a better exception for missing arguments")
	} catch (e: IllegalArgumentException) {
		println(e.message)
	}

	for (definiteName in possiblyNullNames.filterNotNull()) {
		println(
			"Or we could use filtering and smart casting: ${definiteName.length}")
	}

	try {
		nullableName!!.length
	} catch (e: NullPointerException) {
		println("Or we might really just love NullPointerExceptions!!")
	}
}
