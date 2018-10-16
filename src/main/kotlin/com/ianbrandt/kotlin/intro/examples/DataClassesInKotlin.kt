package com.ianbrandt.kotlin.intro.examples

data class KotlinPerson(
	var name: String,
	var favoriteProgrammingLanguage: String = "Kotlin",
	var age: Int = 1
)

fun main(args: Array<String>) {
	val luke = KotlinPerson("Luke")
	println(luke)

	val (name, favoriteProgrammingLanguage) = luke
	println("Use the $favoriteProgrammingLanguage, $name!")

	val leia = luke.copy(name = "Leia")
	println(leia.age)
}
