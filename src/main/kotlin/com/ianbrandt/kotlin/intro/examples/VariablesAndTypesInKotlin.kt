package com.ianbrandt.kotlin.intro.examples

// val's are read only (final), var's are mutable

val bool = false // final Boolean

var j = 0 // non-final Int

// Name first, then, optionally, the type after a colon
// (Similar to Scala, Swift, Go, Rust, Pascal, ML, etc.)

val b: Byte = 0 // Type required due to no literal

// Variables aren't defaulted; they must be initialized

// Kotlin abstracts away primitives vs wrapper types

val c = 'c' // Char
val s: Short = 0 // Again the type is required due to no literal
val i = 0 // Int
val l = 0L // Long, lowercase 'l' not supported
val f = 0.0f // Float, 'F' also supported
val d = 0.0 // Double, 'd/D' not supported


fun withVariables() {
//	i++ // Does not compile
	j++
}

fun main() {
	println(
		"Boolean: $bool, Byte: $b, Char: $c, Short: $s, Int: $i, Long: $l, " +
			"Float: $f, Double: $d, variable Int j: $j")
	withVariables()
	println("variable Int j: $j")
}
