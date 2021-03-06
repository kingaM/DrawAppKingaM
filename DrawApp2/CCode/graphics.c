#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "graphics.h"

void drawLine(int x1, int y1, int x2, int y2)
{
	printf("DL %i %i %i %i\n", x1, y1, x2, y2);
}

void drawRect(int x1, int x2, int width, int height)
{
	printf("DR %i %i %i %i\n", x1, x2, width, height);
}

void drawOval(int x, int y, int width, int height)
{
	printf("DO %i %i %i %i\n",x,y,width,height);
}

void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
{
	printf("DA %i %i %i %i %i %i\n",x,y,width,height, startAngle, arcAngle);
}

void drawString(char* s, int x, int y)
{
	printf("DS %i %i @%s\n",x,y,s);
}

void drawPolygon(double d[], int length)
{
	int i = 0;
	printf("DP ");
	for(i = 0; i < length; i++)
	{
		printf("%f ", d[i]);
	}
	printf("\n");
}

void drawImage(int x, int y, int width, int height, char path[])
{
	printf("DI %i %i %i %i %s\n", x, y, width, height, path);
}

void setColour(colour c)
{
	char* colourName = malloc(sizeof(char)*10);
	getColour(c, colourName);
	printf("SC %s\n", colourName);
	free(colourName);
}

void setFillColour(colour c)
{
	char* colourName = malloc(sizeof(char)*10);
	getColour(c, colourName);
	printf("SF %s\n", colourName);
	free(colourName);
}

void clearFillColour()
{
	printf("CFC\n");
}

void clearStrokeColour()
{
	printf("CSC\n");
}

void setGradientColour(colour c1, colour c2)
{
	char* colour1 = malloc(sizeof(char)*10);
	char* colour2 = malloc(sizeof(char)*10);
	getColour(c1, colour1);
	getColour(c2, colour2);
	printf("GC %s %s\n", colour1, colour2);
	free(colour1);
	free(colour2);
}

void setRotate(int angle)
{
	printf("SR %i\n", angle);
}

void getColour(colour c, char* colourName)
{
	switch(c)
	{
	case black : strcpy(colourName, "black"); break;
	case blue :strcpy(colourName, "blue"); break;
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
