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
 * Data to create a box.
 *
 * @author Grégory Van den Borre
 */
public final class Box {

    /**
     * Width size of the box.
     */
    public final int width;

    /**
     * Height size of the box.
     */
    public final int height;

    /**
     * Depth size of the box.
     */
    public final int depth;

    /**
     * Full constructor.
     *
     * @param widthSize  Width size of the box.
     * @param heightSize Height size of the box.
     * @param depthSize  Depth size of the box.
     */
    private Box(final int widthSize, final int heightSize, final int depthSize) {
        super();
        assert widthSize > 0;
        assert heightSize > 0;
        assert depthSize > 0;
        this.width = widthSize;
        this.height = heightSize;
        this.depth = depthSize;
    }

    /**
     * Create a cube.
     *
     * @param size  Size of the box.
     */
    public static Box cube(final int size) {
        return new Box(size, size, size);
    }

    /**
     * Create a box.
     *
     * @param widthSize  Width size of the box.
     * @param heightSize Height size of the box.
     * @param depthSize  Depth size of the box.
     */
    public static Box box(final int widthSize, final int heightSize, final int depthSize) {
        return new Box(widthSize, heightSize, depthSize);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Box box = (Box) o;

        return width == box.width && height == box.height && depth == box.depth;
    }

    @Override
    public final int hashCode() {
        int result = width;
        result = 31 * result + height;
        result = 31 * result + depth;
        return result;
    }
}
