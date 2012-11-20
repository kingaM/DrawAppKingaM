#include "init.h"
#include "turtle.h"

int main(void)
{
	setTurtleMode(100, 100, 0);
	penDown();
	goForward(30);
	turnLeft(90);
	goForward(40);
	turnLeft(90);
	goForward(30);
	turnLeft(90);
	goForward(40);
	turnLeft(90);
	setPenColour(blue);
	penUp();
	goForward(100);
	penDown();
	goForward(30);
	turnLeft(90);
	goForward(40);
	turnLeft(90);
	goForward(30);
turnLeft(90);
	goForward(40);
	turnLeft(90);
}
