//// Kevin Schaefer
//// CST 112 Eve -- FINAL

//// Declare and initialize
int many=5;

Squid school[]=  new Squid[many];
String names[]=  { "One", "Two", "Red", "Blue", "Fish" };

Boat fleet[]= new Boat[many];
String boatNames[]= {"Jenny", "Penny", "XPenny", "Minnow", "Mimi" };

Lobster ks[]= new Lobster[many];
String lobsterNames[]= {"Larry", "Lex", "Leo", "Liz", "Lou" };

float spacing;
float surface;
float moonX=0, moonY=100;
int score=0;
boolean mouseClicked = false;

//// Size & reset
void setup() {
  size( 800, 600 );
  //size( 1000, 800 );  
  spacing=  width/(many+1);  
  reset();
}

//// Reset function
void reset() {
  score=0;
  surface=  random(  height/4, height/2 );
  moonY=  surface/3;
  moonY=  random( 200, surface+200 );
  
  float x=  spacing;
  for (int i=0; i<many; i++ ) {
    school[i]=  new Squid( names[i], x );      // spaces squids evenly
    x += spacing;
  }
  for (int i=0; i<many; i++ ) {
    fleet[i]=  new Boat( boatNames[i]);        // creates new boats
  }
  for (int i=0; i<many; i++ ) {
    ks[i]=  new Lobster( lobsterNames[i]);     // creates new lobsters
  }   
}

//// Display button for function
void showButton( float x, float y, float w, float h ) {
  fill(255,175,0);
  rectMode( CORNER );
  rect ( x,y,w,h, 7 );
  fill(0);
  text ("HI/LO", x+30, y+20);
}

//// Iterate and sort value functions for Boat
void sortBoatX(Boat[] a, int many) {         // Sorts the boats by X positions
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].x > a[k].x) k = j;
    }
    swapBoat(a, m-1, k);
  }
}
void sortBoatDX(Boat[] a, int many) {        // Sorts the boats by DX values
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].dx < a[k].dx) k = j;
    }
    swapBoat(a, m-1, k);
  }
}
void sortBoatCargo(Boat[] a, int many) {     // Sorts the boats by cargo amount
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].cargo < a[k].cargo) k = j;
    }
    swapBoat(a, m-1, k);
  }
}

//// Iterate and sort value functions for Squid
void sortSquidX(Squid[] a, int many) {        // Sorts the squids by X positions
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].x > a[k].x) k = j;
    }
    swapSquid(a, m-1, k);
  }
}
void sortSquidY(Squid[] a, int many) {        // Sorts the squids by Y positions
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].y > a[k].y) k = j;
    }
    swapSquid(a, m-1, k);
  }
}
void sortSquidDY(Squid[] a, int many) {       // Sorts the squids by DY values
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].dy > a[k].dy) k = j;
    } 
    swapSquid(a, m-1, k);
  }
}
void sortSquidL(Squid[] a, int many) {        // Sorts the squids by leg number
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].legs > a[k].legs) k = j;
    }
    swapSquid(a, m-1, k);
  }
}

//// Iterate and sort value functions for Lobster
void sortLobsterX(Lobster[] a, int many) {    // Sorts the squids by X positions
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].x > a[k].x) k = j;
    }
    swapLobster(a, m-1, k);
  }
}
void sortLobsterY(Lobster[] a, int many) {    // Sorts the squids by Y positions
  for (int m = many; m > 1; m--) {
    int k = 0;
    for (int j = 1; j<m; j++) {
      if (a[j].y > a[k].y) k = j;
    }
    swapLobster(a, m-1, k);
  }
}

//// Function to swap boat properties
void swapBoat(Boat[] a, int k, int j) {      // Swaps the values inputted
  float tmpX;
  float tmpDX;
  int tmpC;
  String tmpN;

  tmpX = a[k].x;            // x swap
  a[k].x = a[j].x;
  a[j].x = tmpX;

  tmpDX = a[k].dx;          // dx swap
  a[k].dx = a[j].dx;
  a[j].dx = tmpDX;

  tmpC = a[k].cargo;        // cargo swap
  a[k].cargo = a[j].cargo;
  a[j].cargo = tmpC;

  tmpN = a[k].name;         // name swap
  a[k].name = a[j].name;
  a[j].name = tmpN;
}

//// Function to swap squid properties
void swapSquid(Squid[] a, int k, int j) {    // Swaps the values inputted
  float tmpX;
  float tmpY;
  float tmpDY;
  int tmpL;
  String tmpN;

  tmpX = a[k].x;          // x swap
  a[k].x = a[j].x;
  a[j].x = tmpX;

  tmpY = a[k].y;          // y swap
  a[k].y = a[j].y;
  a[j].y = tmpY;

  tmpDY = a[k].dy;        // dy swap
  a[k].dy = a[j].dy;
  a[j].dy = tmpDY;

  tmpL = a[k].legs;       // legs swap
  a[k].legs = a[j].legs;
  a[j].legs = tmpL;

  tmpN = a[k].name;       // name swap
  a[k].name = a[j].name;
  a[j].name = tmpN;
}

//// Function to swap lobster properties
void swapLobster(Lobster[] a, int k, int j) {      // Swaps the values inputted
  float tmpX;
  float tmpY;
  String tmpN;

  tmpX = a[k].x;          // x swap
  a[k].x = a[j].x;
  a[j].x = tmpX;

  tmpY = a[k].y;          // y swap
  a[k].y = a[j].y;
  a[j].y = tmpY;

  tmpN = a[k].name;       // name swap
  a[k].name = a[j].name;
  a[j].name = tmpN;
}

//// DRAW:  scene, show, action, messages, report
void draw() {
  scene();
  show();
  showButton(width-125,15, 100, 30);
  // Show (x,y) value when click or $ pressed
  if ( (key == '$') || (mouseClicked == true) ) {
    fill(255,200,200,210);    
    rect(width/3, height/80, 300, 100);
    fill(255,255,255);
    text("Click anywhere on screen to resume.", width/2.5, height/2);
    fill(0);
    
    sortLobsterY(ks, ks.length);   // Run the sort by Y function
    
    // HIGHEST LOBSTER (lowest Y value)
    text( "Highest Lobster Coordinates:", width/3+20, height/80+20);  
    text("X:", width/3+30, height/80+40);
    text( ks[0].x, width/3+40, height/80+40);
    text("Y:", width/3+110, height/80+40);    
    text( ks[0].y, width/3+120, height/80+40);
    text( ks[0].name, width/3+220, height/80+40);
    
    // LOWEST LOBSTER (highest Y value)
    text( "Lowest Lobster Coordinates:", width/3+20, height/80+70);
    text("X:", width/3+30, height/80+90);    
    text( ks[4].x, width/3+40, height/80+90);
    text("Y:", width/3+110, height/80+90);        
    text( ks[4].y, width/3+120, height/80+90);
    text( ks[4].name, width/3+220, height/80+90);
  }
  // Shows report if any caps key pressed
  else if (key >= 'A' && key <= 'Z') {
    boatReport(100, fleet, fleet.length);
    squidReport(200, school, school.length);
    lobsterReport(300, ks, ks.length);
    messages(); }
  // Only runs action if prior conditions not met  
  else {
    action();
    messages();
  }
}

//// Display instructions, title, and score
void messages() {
  fill(255,255,255);
  textSize( 20 );
  text( "Gone Fishin'", width/2.5, 20 ); // Title
  textSize(12);
  text( "Kevin Schaefer", 15, height-10); // Name
  
  // Boat Instructions
  text( "Hold B key to show boats in position order", 50, 40 );
  text( "Hold D key to show boats in speed order (from + to -)", 50, 55 );
  text( "Hold F key to show boats in cargo order", 50, 70 );
  // Squid Instructions
  text( "Hold X key to show squid in position order", width/2, 40 );
  text( "Hold Y key to show squid in height order", width/2, 55 );
  text( "Hold S key to show squid in speed order (from + to -)", width/2, 70 );
  text( "Hold L key to show squid in leg number order", width/2, 85 );
  
  // Display score
  if (score>0) text( "SCORE:  "+score, width*0.6, 20 );
  fill(0);
}

//// METHODS TO MOVE & DRAW.
void scene() {
  background( 50,150,200 );  // Dark sky
  if (moonX > width+100) {   // Moon
    moonX=  -100;
    moonY=  random( 100, surface+50 );
  }
  moonX += 1;
  fill( 200,150,50 );
  ellipse( moonX, moonY-150*sin( PI * moonX/width ), 40,40 );
  // Dark water.
  fill( 0,100,50 );
  noStroke();
  rect( 0,surface, width, height-surface );
  // Draws evenly spaced red triangles along the side under water
  for (float i=surface+20; i<height-41; i+=100 ) {
    fill(255,0,0);
    triangle(width-5,i, width-5,i+40, width-25,i+20);
  }  
}

//// Moves the squids/boats/lobsters
void action() {
  for (int i=0; i<many; i++ ) {    // Squids
    school[i].move();
  }
  for (int i=0; i<many; i++ ) {    // Boats
    fleet[i].move();
  }
  for (int i=0; i<many; i++ ) {    // Lobsters
    ks[i].move();
  }
}

//// Show the squids/boats/lobsters
void show() {
  float x=  spacing;
  for (int i=0; i<many; i++ ) {    // Squids
    school[i].x=  x;
    x += spacing;
    school[i].show();
  }
  for (int i=0; i<many; i++ ) {    // Boats
    fleet[i].show();
  }
  for (int i=0; i<many; i++ ) {    // Lobsters
    ks[i].show();
  }
}

//// Creates the report of boat properties
void boatReport( float top, Boat[] b, int many ) {
  fill(255,200,200,210);
  rect( 50,top, width-100, 20*many );
  float x=70, y=top+20;
  // Labels
  fill(150,0,0);
  text( "Boat", x+20, y );
  text( "Cargo", x+70, y );
  text( "X", x+125, y );
  text( "DX", x+285, y );
  fill(0);
  // Iterates through boat index to display
  for (int i=0; i<many; i++) {
    y += 15;    // Creates next line
    text( i, x, y );
    text( b[i].name, x+20, y );
    text( b[i].cargo, x+70, y );
    text( b[i].x, x+125, y );
    text( b[i].dx, x+285, y );
  }  
}

//// Creates the report of squid properties
void squidReport( float top, Squid[] a, int many ) {
  fill(255,255,200, 200);
  rect( 50,top, width-100, 20*many );
  float x=70, y=top+20;
  // Labels
  fill(150,0,0);
  text( "Squid", x+20, y );
  text( "Legs", x+70, y );
  text( "X", x+125, y );
  text( "Y", x+205, y );
  text( "DY", x+365, y );
  fill(0);
  // Iterates through squid index to display
  for (int i=0; i<many; i++) {    
    y += 15;    // Next line.
    text( i, x, y );
    text( a[i].name, x+20, y );
    text( a[i].legs, x+70, y );
    text( a[i].x, x+125, y );
    text( a[i].y, x+205, y );
    text( a[i].dy, x+365, y );
  }
}
  
//// Creates the report of lobster properties
void lobsterReport( float top, Lobster[] c, int many ) {
  fill(0,255,255,210);
  rect( 50,top, width-100, 20*many );
  float x=70, y=top+20;
  // Labels
  fill(150,0,0);
  text( "Lobster", x+20, y );
  text( "X", x+125, y );
  text( "Y", x+205, y );
  text( "DX", x+285, y );
  text( "DY", x+365, y );  
  fill(0);
  // // Iterates through Lobster index to display
  for (int i=0; i<many; i++) {
    y += 15;    // Next line.
    text( i, x, y );
    text( c[i].name, x+20, y );
    text( c[i].x, x+125, y );
    text( c[i].y, x+205, y );
    text( c[i].dx, x+285, y );
    text( c[i].dy, x+365, y );  
  }  
}    
    
//// EVENT HANDLERS:  keys & clicks 
void keyPressed() {
  if (key == 'B') {
    sortBoatX(fleet, fleet.length); }        // Sort position (x)
  if (key == 'D') {
    sortBoatDX(fleet, fleet.length ); }      // Sort speed (dx)
  if (key == 'F') {
    sortBoatCargo(fleet, fleet.length ); }   // Sort # cargo
    
  if (key == 'X') {
    sortSquidX(school, school.length); }     // Sort position (x)
  if (key == 'Y') {
    sortSquidY(school, school.length); }     // Sort height (y)
  if (key == 'S') {
    sortSquidDY(school, school.length); }    // Sort speed (dy)
  if (key == 'L') {
    sortSquidL(school, school.length); }     // Sort # legs
    
  if (key == 'r') reset();
  // Sends squid to the bottom
  if (key == '0') school[0].bottom(); 
  if (key == '1') school[1].bottom(); 
  if (key == '2') school[2].bottom(); 
  if (key == '3') school[3].bottom(); 
  if (key == '4') school[4].bottom();  
  // Send highest to bottom.
  if (key == 'h') {
    int k=0;
    for (int i=1; i<many; i++ ) {
      if (school[i].y < school[k].y) k=i;    // k is index of highest.
    }
    school[k].bottom();     
  }
  // Cheat codes:
  // Send all to top or bottom.
  if (key == 'b') {
    for (int k=0; k<many; k++ ) {    // to the bottom
      school[k].bottom();     
    }
  }
  if (key == 't') {
    for (int k=0; k<many; k++ ) {    // to the top
      school[k].y=  surface+10;
      school[k].dy=  -0.1  ;
    }
  }
}

//// Determines if button is clicked
void mouseClicked() {
  if ((mouseX) > (width-125) && (mouseX) < ((width-125)+100) &&
     (mouseY) > (15) && (mouseY) < (45)) {
       mouseClicked= true;
     }
     else {
     mouseClicked= false; }
}

//// OBJECTS ////
class Squid {
  float x,y;        // Coordinates
  float dx=0,dy=0;  // Speed
  float w=40,h=40;  // Width/height
  int legs=10;      // Number of legs.
  String name="";
  float r,g,b;      // Color.
  int count=0;
  //// CONSTRUCTORS ////
  Squid( String s, float x ) {
    this.name=  s;
    this.x=x;
    bottom();
    // Purplish
    r=  random(100, 255);
    g=  random(0, 100);
    b=  random(100, 250);
  }
  //// Start again at bottom  (Random speed.)
  void bottom() {
    y=  height - h;
    dy= -random( 0.1, 0.9 );
    legs= int( random(1, 10.9) );
  }
  //// METHODS: move & show ////
  void move() {
    x += dx;
    y += dy;
    if (y>height) {
      bottom();
      count++;
    }
    else if (y<surface) { 
      dy=  -3 * dy;        // Descend fast if hit surface
    }
  }
  //// Display the squid
  void show() {
    fill(r,g,b);
    stroke(r,g,b);
    ellipse( x,y, w,h );         // round top
    rect( x-w/2,y, w,h/2 );      // flat bottom
    // Legs
    fill(r,g,b);
    float legX=  x-w/2, foot=0;
    foot=  dy>=0 ? 0 : (y%47 > 23) ? 5 : -5;
    strokeWeight(3);
    for (int i=0; i<legs; i++) {
      line( legX, y+h/2, legX+foot, 20+y+h/2 );
      legX += w / (legs-1);
    }
      strokeWeight(3);
    fill(200,200,0);
    text( name, x-w/2, y-10+h/2 );
    fill(0);
    text( legs, x+2-w/2, y+h/2 );
    fill(255);
    if (count>0) text( count, x, y+h/2 );
  }
  // Return true if near
  boolean hit( float xx, float yy ) {
    return dist( xx,yy, x,y ) < h;
  }
}

//// BOAT CLASS ////
class Boat {
  String name="";
  float x, y=surface, dx=2; // initial properties
  int cargo=0, caught=0;
  // Assign name, random x and dx
  Boat(String s) {
    this.name=  s;
    x = random(0,width);
    dx = random(-3, 3);
  }  
  // Creates movement, determines cargo, speed & direction
  void move() {
    int caught=0;
    x += dx;    
    // Checks for a hit, adds to caught, sends squid to bottom
    for (int i=0; i<many; i++ ) {
      if (school[i].hit( x, surface )) {
        caught += school[i].legs;
        school[i].bottom();
      }
    }  
    cargo += caught;             // squid legs caught in cargo         
    if (caught>0) x += 2*dx;     // Jump after catch
    if (x<0) {
      score += cargo;            // Add cargo to global score
      cargo=0;
      dx = random( 1, 3 );       // Variable boat speed
    }    
    if (x>width)  {
      dx = -random( 0.5, 3 );    // Slower return
    }
  }  
  
  // Draw & show boat
  void show() {
    fill(255,130,0);
    noStroke();
    rect( x, surface-20, 50, 20 );
    if (dx>0) { triangle( x+50,surface, x+50,surface-20, x+70,surface-20 ); } // face right
    else {      triangle( x,surface, x,surface-20, x-20,surface-20 ); }       // face left
    rect( x+12, surface-30, 25, 10 );      // Cabin
    fill(0);
    rect( x+20, surface-40, 10, 10 );      // Smokestack
    // Display name & cargo.
    fill(255);
    text( name, x+5, surface-10 );
    fill(0);
    text( cargo, x+20, surface );
  }    
}

//// LOBSTER CLASS ////
class Lobster {
  String name="";
  float x,   dx=2; // initial properties
  float y,   dy=2;
  int cargo=0, caught=0;
  int counter=0;
  // Assign name, random x and dx
  Lobster(String s) {
    this.name=  s;
    x = 0;
    y = random((surface+height)/2, height);
    dx = random(0, 3);
    dy = random(-3, 0);
  }  
  // Creates lobster movement, speed & direction
  void move() {
    x += dx;  
    y += dy;
    counter += 1;
    for (int i=0; i<many; i++ ) {    // Squid to bottom if lobster hit
      if (school[i].hit( x, y )) {
        caught += school[i].legs;
        school[i].bottom();
      }
    }    
    if ( (x<0) || (x>width) ) {    // Reverse horizontal direction if hit boundaries
      dx *= -1;
    }
    if ( (y<surface+30) || (y>height) ) {  // Reverse vertical direction if hit boundaries
      dy *= -1;
    }    
  }  
  
  // Draw & show lobster
  void show() {
    fill(255,0,0);
    noStroke();
    ellipse( x, y, 80, 20 ); // body
    // LOBSTER FACING RIGHT DIRECTION
    // Moving claws
    if (dx>0) {
      if (counter/30 % 2 == 0) {
        arc(x+20, y-21, 15, 30, 0, PI+QUARTER_PI, PIE);              // top open
        arc(x+20, y+21, 15, 30, HALF_PI+QUARTER_PI, TWO_PI, PIE);    // bottom open
      }
      else {
        arc(x+20, y-21, 15, 30, 0-QUARTER_PI, PI+HALF_PI, PIE);      // top closed
        arc(x+20, y+21, 15, 30, HALF_PI, TWO_PI+QUARTER_PI, PIE);    // bottom closed
      }
      triangle(x-25,y, x-45,y-12, x-45,y+12);    // Tail
      fill(0);
      ellipse(x+28,y-3,3,3);                     // Eyes
      ellipse(x+28,y+3,3,3);
    }
    // LOBSTER FACING LEFT DIRECTION
    // Moving claws
    else {
      if (counter/30 % 2 == 0) {
        arc(x-20, y-21, 15, 30, 0-QUARTER_PI, PI, PIE);              // top open
        arc(x-20, y+21, 15, 30, PI, TWO_PI+QUARTER_PI, PIE);         // bottom open
      }
      else {
        arc(x-20, y-21, 15, 30, 0-HALF_PI, PI+QUARTER_PI, PIE);      // top closed
        arc(x-20, y+21, 15, 30, PI-QUARTER_PI, TWO_PI+HALF_PI, PIE); // bottom closed
      }
      triangle(x+25,y, x+45,y-12, x+45,y+12);    // Tail      
      fill(0);
      ellipse(x-28,y-3,3,3);                     // Eyes
      ellipse(x-28,y+3,3,3);
    }
    fill(255);
    text( name, x-15, y+3 );
    fill(0);
  }    
  // Return true if near
  boolean hit( float xx, float yy ) {
    return dist( xx,yy, x,y ) < 12;
  }
}
