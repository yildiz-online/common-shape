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
 * Data to create a sphere.
 *
 * @author Grégory Van den Borre
 *
 * Invariant radius &gt; 0
 */
public final class Sphere {

    /**
     * Sphere radius.
     */
    public final float radius;

    /**
     * Full constructor.
     *
     * @param radiusSize Radius size of the sphere, must be &gt; 0.
     */
    private Sphere(final float radiusSize) {
        super();
        assert radiusSize > 0;
        this.radius = radiusSize;
    }

    /**
     * Full constructor.
     *
     * @param radiusSize Radius size of the sphere, must be &gt; 0.
     */
    public static Sphere fromRadius(final float radiusSize) {
        return new Sphere(radiusSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sphere sphere = (Sphere) o;

        return Float.compare(sphere.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Float.floatToIntBits(radius);
    }
}

