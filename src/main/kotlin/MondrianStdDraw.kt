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

    }
}