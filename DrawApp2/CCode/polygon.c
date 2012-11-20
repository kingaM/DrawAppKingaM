#include "init.h"
#include "graphics.h"

int main(void)
{
	
	setGraphicsMode();
	setDimensions(600, 600);
  setGradientColour(blue, green);
  double d[] = {0, 0, 100, 100, 250, 200};
  drawPolygon(d, 6);


}
