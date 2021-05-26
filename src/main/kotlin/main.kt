import classes.* //import all classes
import functions.doCommands.* //import all doCommands

fun main(args: Array<String>) {
    println("Hello World!")

    print("Choose a number: ");
    var a: Int = Integer.parseInt( readLine() );

    println("You chose $a");
}