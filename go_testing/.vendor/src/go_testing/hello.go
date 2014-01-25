package main

import "fmt"

// start point
func main() {

	/*fmt.Println("1 + 1 =", 1+1)
	fmt.Println("1 + 1 =", 1.0+1.0)

	fmt.Println(len("Hello World"))
	fmt.Println("Hello World"[1])
	fmt.Println("Hello " + "World")*/

	//booleans()

	vars1()
}

func booleans() {
	fmt.Println(true && true)
	fmt.Println(true && false)
	fmt.Println(true || true)
	fmt.Println(true || false)
	fmt.Println(!true)
}

// basics about variables
func vars1() {
	var x string = "Hello World"
	fmt.Println(x)
}
