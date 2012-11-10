enum colour {black,blue,cyan,darkgray,gray,green,lightgray,magenta,orange,pink,red,white,yellow};
typedef enum colour colour;

void penUp();
void penDown();
void setPenColour(colour c);
void goForward(int);
void turnLeft(int);
void turnRight(int);
void getColour(colour c, char*);
