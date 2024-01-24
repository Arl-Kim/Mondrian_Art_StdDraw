import edu.princeton.cs.introcs.StdDraw
import kotlin.random.Random

/**
 *@author Kimutai
 *
 * The class MondrianStdDraw Generates abstract Mondrian Art using a recursive splitting technique and StdDraw
 *
 *@property canvasWidth the width of the canvas
 * @property canvasHeight the height of the canvas
 * */
class MondrianStdDraw(val canvasWidth: Double, val canvasHeight: Double) {

    /**
     * Generates abstract art using a recursive splitting technique.
     */
    fun generateArt(){
        StdDraw.setCanvasSize(canvasWidth.toInt(), canvasHeight.toInt())
        StdDraw.setXscale(0.0, 0.0, canvasWidth)
        StdDraw.setYscale(0.0, 0.0, canvasHeight)

        generateArtRecursively(0.0, 0.0, canvasWidth, canvasHeight)

        //Keeps the window open until user closes it
        StdDraw.show()
    }

    /**
     * Recursively generates abstract art by splitting the canvas.
     *
     * @param x The x-coordinate of the current region.
     * @param y The y-coordinate of the current region.
     * @param width The width of the current region.
     * @param height The height of the current region.
     */
    private fun generateArtRecursively(x: Double, y: Double, width: Double, height: Double){
        //Define the threshold for splitting
        val splitThreshold = 60.0

        //Make decision on splitting
        val shouldSplit = when{
            (width > canvasWidth / 2  && height > canvasHeight / 2) -> true
            (width > splitThreshold && height > splitThreshold) ->
                Random.nextDouble() < 2.0 / 3 && Random.nextDouble() < 2.0 / 3
            else -> false
        }

        if(shouldSplit){
            //Splits into 4 regions
            val verticalLine = Random.nextDouble(x + width / 3, x + 2 * width / 3)
            val horizontalLine = Random.nextDouble(y + height / 3, y + 2 * height / 3)

            generateArtRecursively(x, y, verticalLine - x, horizontalLine - y)
            generateArtRecursively(verticalLine, y, x + width - verticalLine, horizontalLine - y)
            generateArtRecursively(x, horizontalLine, verticalLine - x, y + height - horizontalLine)
            generateArtRecursively(verticalLine, horizontalLine, x + width - verticalLine, y + height - horizontalLine)
        }
        else{
            //Do not split but fill with random color instead
            val fill = if (Random.nextDouble() < 1.0 / 4) randomColor() else "white"
            StdDraw.setPenColor(fill)
            StdDraw.filledRectangle(x + width / 2, y + height / 2, width / 2, height / 2)
        }
    }

    /**
     * Generates a random color from a predefined list.
     *
     * @return A randomly selected color.
     */
    private fun randomColor(): String{
        val colors = listOf("red", "blue", "yellow")
        return colors.random()
    }

    /**
     * The main function that creates an instance of MondrianArtGenerator and generates abstract art.
     */
    fun main(){
        val generator = MondrianStdDraw(800.0, 600.0)
        generator.generateArt()
    }
}