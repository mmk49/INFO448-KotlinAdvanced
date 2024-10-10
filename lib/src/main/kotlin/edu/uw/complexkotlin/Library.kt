/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package edu.uw.complexkotlin

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15).
// use map() to return a list with "", "FIZZ" (for 3s) or "BUZZ" (for 5s).
// use fold() to compress the array of strings down into a single string.
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ for 0..15.
// store this lambda into 'fizzbuzz' so that the tests can call it
//
val fizzbuzz : (IntRange) -> String = { it -> it.map {
        if(it % 3 == 0 && it % 5 == 0) {
            "FIZZBUZZ"
        } else if(it % 3 == 0) {
            "FIZZ"
        } else if(it % 5 == 0) {
            "BUZZ"
        } else {
            ""
        }
    }.fold("") {acc, word -> acc + word}
}

// Example usage
/*
if (fizzbuzz(1..2) == "")
    println("Success!")
if (fizzbuzz(1..3) == "FIZZ")
    println("Success!")
if (fizzbuzz(1..5) == "FIZZBUZZ")
    println("Success!")
*/

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: (String) -> String): String {
    var str = ""
    for (it in 1..this) {
        str += block("repeat")
    }
    return str
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
// Create r1 as a lambda that calls process() with message "FOO" and a block that returns "BAR"
val r1 = { process("FOO") { _ -> "BAR"} }

// Create r2 as a lambda that calls process() with message "FOO" and a block that upper-cases 
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"
val r2_message = "wooga"
val r2 = { process("FOO") { _ -> 3.times({r2_message}).uppercase()}}


// write an enum-based state machine between talking and thinking
enum class Philosopher { 
  THINKING {
    override fun signal() = TALKING
    override fun toString() = "Deep thoughts...."
  },
    
  TALKING {
    override fun signal() = THINKING
    override fun toString() = "Allow me to suggest an idea..."
  };
    
  abstract fun signal(): Philosopher
}

// create an class "Command" that can be used as a function.
// To do this, provide an "invoke()" function that takes a 
// single parameter ("message" of type String). Command's
// primary constructor should take a String argument ("prompt").
// When invoked, the Command object should return a String
// containing the prompt and then the message.
// Example:
// val cmd = Command(": ")
// val result = cmd("Hello!")
// result should equal ": Hello!"
class Command(val prompt: String) {
    operator fun invoke(message: String): String {
        return prompt + message
    }
}
