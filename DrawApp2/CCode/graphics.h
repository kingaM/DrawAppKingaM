enum colour {black,blue,cyan,darkgray,gray,green,lightgray,magenta,orange,pink,red,white,yellow};
typedef enum colour colour;

void drawLine(int,int,int,int);
void drawRect(int,int,int,int);
void drawOval(int,int,int,int);
void drawArc(int,int,int,int,int,int);
void fillRect(int,int,int,int);
void drawString(char*,int,int);

void setColour(colour);
void getColour(colour, char *);
void drawPolygon(double[], int);
void drawImage(int, int, int, int, char[]);
void setFillColour(colour);
void setGradientColour(colour, colour);
void setRotate(int);
void clearFillColour();
void clearStrokeColour();
