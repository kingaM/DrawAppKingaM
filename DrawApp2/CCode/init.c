#include <stdio.h>
#include "init.h"

void setDimensions(int height, int width)
{
	printf("D %i %i\n", height, width);
}

void setTurtleMode(int x, int y, int a)
{
	printf("T %i %i %i\n", x, y, a);
}

void setGraphicsMode()
{
	printf("G\n");
}

