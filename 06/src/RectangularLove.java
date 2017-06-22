/**
 * Created by sergeyo on 6/21/2017.
 */
public class RectangularLove {

    public static void main(String[] args) {
        Rectangle male = new Rectangle(-5, -5, 25, 25);
        Rectangle female = new Rectangle(-15, -0, 35, 55);

        printLove(isOverlap(male, female));


    }

    public static Rectangle isOverlap(Rectangle male, Rectangle female) {

        int highestLeft = Math.max(male.getLeftX(), female.getLeftX());
        int highestBottom = Math.max(male.getBottomY(), female.getBottomY());
        int lowestRight = Math.min(male.getLeftX() + male.getWidth(), female.getLeftX() + female.getWidth());
        int lowestUp = Math.min(male.getBottomY() + male.getHeight(), female.getBottomY() + female.getHeight());

        if (lowestRight < highestLeft || lowestUp < highestBottom) {
            return new Rectangle();
        }

        int width = lowestRight - highestLeft;
        int height = lowestUp - highestBottom;

        Rectangle love = new Rectangle(
                highestLeft, highestBottom, width, height

        );

        return love;
    }


    public static void printLove(Rectangle love) {
        System.out.println("x: " + love.getLeftX());
        System.out.println("y: " + love.getBottomY());
        System.out.println("w: " + love.getWidth());
        System.out.println("h: " + love.getHeight());
    }

}
