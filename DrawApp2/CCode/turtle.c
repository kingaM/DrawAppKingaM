#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "turtle.h"

void penUp()
{
	printf("PU\n");
}

void penDown()
{
	printf("PD\n");
}

void setPenColour(colour c)
{
	char* colourName = malloc(sizeof(char)*10);
	getColour(c, colourName);
	printf("PC %s\n", colourName);
	free(colourName);
}

void goForward(int step)
{
	printf("GF %i\n", step);
}

void turnLeft(int angle)
{
	printf("TL %i\n", angle);
}

void turnRight(int angle)
{
	printf("TR %i\n", angle);
}

void getColour(colour c, char* colourName)
{
	switch(c)
	{
	case black : strcpy(colourName, "black"); break;
	case blue : strcpy(colourName, "blue"); break;
	case cyan : strcpy(colourName, "cyan"); break;
	case darkgray : strcpy(colourName, "darkgray"); break;
	case gray : strcpy(colourName, "gray"); break;
	case green : strcpy(colourName, "green"); break;
	case lightgray : strcpy(colourName, "lightgray"); break;
	case magenta : strcpy(colourName, "magenta"); break;
	case orange : strcpy(colourName, "orange"); break;
	case pink : strcpy(colourName, "pink"); break;
	case red : strcpy(colourName, "red"); break;
	case white : strcpy(colourName, "white"); break;
	case yellow : strcpy(colourName, "yellow"); break;
	}
}
