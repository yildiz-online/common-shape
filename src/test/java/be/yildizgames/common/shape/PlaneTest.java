/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Grégory Van den Borre
 */
class PlaneTest {

    @Nested
    class Constructor {

        @Test
        void happyFlow() {
            Plane p = Plane.rectangle(1,2);
            assertEquals(1, p.width);
            assertEquals(2, p.depth);
        }

        @Test
        void happyFlow1Arg() {
            Plane p = Plane.square(1);
            assertEquals(1, p.width);
            assertEquals(1, p.depth);
        }

        @Test
        void zeroWidth() {
            assertThrows(AssertionError.class, () -> Plane.rectangle(0,1));
        }


        @Test
        void zeroDepth() {
            assertThrows(AssertionError.class, () -> Plane.rectangle(1,0));
        }

        @Test
        void negativeWidth() {
            assertThrows(AssertionError.class, () -> Plane.rectangle(-1,3));
        }

        @Test
        void negativeDepth() {
            assertThrows(AssertionError.class, () -> Plane.rectangle(1,-1));
        }
    }

    @Nested
    class EqualsHashCode {

        @Test
        void sameHash() {
            Plane p1 = Plane.square(2);
            Plane p2 = Plane.square(2);
            assertEquals(p1.hashCode(), p2.hashCode());
        }

        @Test
        void differentHash() {
            Plane p1 = Plane.square(2);
            Plane p2 = Plane.square(3);
            assertNotEquals(p1.hashCode(), p2.hashCode());
        }

        @Test
        void sameValues() {
            Plane p1 = Plane.square(2);
            Plane p2 = Plane.square(2);
            assertEquals(p1, p2);
        }

        @Test
        void sameObject() {
            Plane p1 = Plane.square(2);
            assertEquals(p1, p1);
        }

        @Test
        void fromNull() {
            Plane p1 = Plane.square(2);
            assertFalse(p1.equals(null));
        }

        @Test
        void fromOtherType() {
            Plane p1 = Plane.square(2);
            assertFalse(p1.equals(2));
        }

        @Test
        void differentValues() {
            Plane p1 = Plane.square(2);
            assertFalse(p1.equals(Plane.square(3)));
        }
    }

    @Test
    void testToString() {
        Plane p = Plane.rectangle(1,2);
        Assertions.assertEquals("Plane(1, 2)", p.toString());
    }
}