package com.ianbrandt.kotlin.intro.examples

private const val STRING = "string"

fun main() {

	val template = "Kotlin supports $STRING templates!\n\n"

	val rawString = """
		You can use "raw" strings for more substantial bodies of text.
		val someString = "That gets you out of "
				+ "concatenation-wrapping, and lets you use literal whitespace "
				+ "instead of escape sequences such as \t, \n, etc."
		You can put arbitrary expressions in raw strings with curly braces.
		${"\n".repeat(2)}
		You can trim leading indentation.
		""".trimIndent()

	val prefixedRawString = """
		> You can also trim to a prefix string,
		> as with email-style quotations.
		> The default prefix is "|" for `.trimMargin()`.
		""".trimMargin("> ")

	println(template + rawString + prefixedRawString)
}
