import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  PImage imgBackground;
  PImage imgLightingBolt;

  float fltLightingX = 200;
  float fltLightingY = 200;
  float fltLightingSpeed = 2; 
  float fltLightingDirectionX = -1; 
  float fltLightingDirectionY = -1; 
	
  float fltSqrX = width/2;
  float fltSqrY = width/2; 
  float fltSqrSpeed = 5; 
  float fltSqrDirectionX = -1; 
  float fltSqrDirectionY = -1; 

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
   imgBackground = loadImage("background.jpeg");
   imgBackground.resize(imgBackground.width*3, imgBackground.height*3);
   imgLightingBolt = loadImage("lightingbolt.png");
   imgLightingBolt.resize(imgLightingBolt.width/2, imgLightingBolt.height/2);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    image (imgBackground, 0, 0);

    image(imgLightingBolt, fltLightingX, fltLightingY); 
    fltLightingX = fltLightingX + (fltLightingDirectionX*fltLightingSpeed);
    if (fltLightingX < 0 || fltLightingX > width - imgLightingBolt.width){
      fltLightingDirectionX = fltLightingDirectionX * -1; 
    }
    fltLightingY = (float)0.02 * (float)Math.pow(fltLightingX - 125, 2); 
    fltLightingY = fltLightingY + (fltLightingDirectionY*fltLightingSpeed);
    if (fltLightingY < 0 || fltLightingY > height - imgLightingBolt.height){
      fltLightingDirectionY = fltLightingDirectionY * -1; 
    }

    fill(255,0,0); 
    rect(fltSqrX, fltSqrY, 50, 50);
      fltSqrX = fltSqrX + (fltSqrDirectionX*fltSqrSpeed);
    if (fltSqrX < 0 || fltSqrX > width - 50){
      fltSqrDirectionX *= -1; 
    }

    fltSqrY = fltSqrY + (fltSqrDirectionY*fltSqrSpeed);
    if (fltSqrY < 0 || fltSqrY > height - 50){
      fltSqrDirectionY *= -1; 
    }
  }
}