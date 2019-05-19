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


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Grégory Van den Borre
 */
public class SphereTest {

    @Nested
    public class Constructor {

        @Test
        public void happyFlow() {
            Sphere s = Sphere.fromRadius(5);
            assertEquals(5, s.radius, 0.00001f);
        }

        @Test
        public void zeroRadius() {
            assertThrows(AssertionError.class, () -> Sphere.fromRadius(0));
        }


        @Test
        public void negativeRadius() {
            assertThrows(AssertionError.class, () -> Sphere.fromRadius(-1));
        }
    }

    @Nested
    public class EqualsHashCode {

        @Test
        public void sameHash() {
            Sphere p1 = Sphere.fromRadius(2);
            Sphere p2 = Sphere.fromRadius(2);
            assertEquals(p1.hashCode(), p2.hashCode());
        }

        @Test
        public void differentHash() {
            Sphere p1 = Sphere.fromRadius(2);
            Sphere p2 = Sphere.fromRadius(3);
            assertNotEquals(p1.hashCode(), p2.hashCode());
        }

        @Test
        public void sameValues() {
            Sphere p1 = Sphere.fromRadius(2);
            Sphere p2 = Sphere.fromRadius(2);
            assertEquals(p1, p2);
        }

        @Test
        public void sameObject() {
            Sphere p1 = Sphere.fromRadius(2);
            assertEquals(p1, p1);
        }

        @Test
        public void fromNull() {
            Sphere p1 = Sphere.fromRadius(2);
            assertFalse(p1.equals(null));
        }

        @Test
        public void fromOtherType() {
            Sphere p1 = Sphere.fromRadius(2);
            assertFalse(p1.equals(2));
        }

        @Test
        public void differentValues() {
            Sphere p1 = Sphere.fromRadius(2);
            assertFalse(p1.equals(Sphere.fromRadius(3)));
        }
    }
}
