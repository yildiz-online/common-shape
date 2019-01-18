/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.common.shape;

/**
 * Contains a plane coordinates.
 *
 * @author Grégory Van den Borre
 */
public final class Plane {

    /**
     * Width size of the plane.
     */
    public final int width;

    /**
     * Depth size of the plane.
     */
    public final int depth;

    /**
     * Full constructor.
     * @param widthSize Width size of the box.
     * @param depthSize Depth size of the box.
     */
    private Plane(final int widthSize, final int depthSize) {
        super();
        assert widthSize > 0;
        assert depthSize > 0;
        this.width = widthSize;
        this.depth = depthSize;
    }

    /**
     * Create a square plane.
     * @param size Size for the width and depth
     */
    public static Plane square(final int size) {
        return new Plane(size, size);
    }

    /**
     * Create a rectangle plane.
     * @param widthSize Width size of the box.
     * @param depthSize Depth size of the box.
     */
    public static Plane rectangle(final int widthSize, final int depthSize) {
        return new Plane(widthSize, depthSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Plane plane = (Plane) o;

        return width == plane.width && depth == plane.depth;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + depth;
        return result;
    }

    @Override
    public String toString() {
        return "Plane(" + this.width + ", " + this.depth + ")";
    }

}
