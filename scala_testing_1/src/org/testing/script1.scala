// This is another comment
println("This is a script Hello World!!")

/*
This is a comment
*/
println("This is a script Hello World!! " + args(0) + " done.")

// Here another comment
var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}

// Here another comment
var j = 0
while (j < args.length) {
  if (j != 0)
    print(" ")
    print(args(j))
    j += 1
}
println()

args.foreach(arg => println(arg))

args.foreach(println)

//comment
for (arg < args)
	println(arg)
