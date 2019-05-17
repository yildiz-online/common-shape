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
public final class BoxTest {

    @Nested
    public class Constructor {

        @Test
        public void happyFlow() {
            Box b = Box.box(1,2,3);
            assertEquals(1, b.width);
            assertEquals(2, b.height);
            assertEquals(3, b.depth);
        }

        @Test
        public void happyFlow1Arg() {
            Box b = Box.cube(5);
            assertEquals(5, b.width);
            assertEquals(5, b.height);
            assertEquals(5, b.depth);
        }

        @Test
        public void zeroWidth() {
            assertThrows(AssertionError.class, () -> Box.box(0,2,3));
        }

        @Test
        public void zeroHeight() {
            assertThrows(AssertionError.class, () -> Box.box(1,0,3));
        }

        @Test
        public void zeroDepth() {
            assertThrows(AssertionError.class, () -> Box.box(1,2,0));
        }

        @Test
        public void negativeWidth() {
            assertThrows(AssertionError.class, () -> Box.box(-1,2,3));
        }

        @Test
        public void negativeHeight() {
            assertThrows(AssertionError.class, () -> Box.box(1,-1,3));
        }

        @Test
        public void negativeDepth() {
            assertThrows(AssertionError.class, () -> Box.box(1,2,-1));
        }
    }

    @Nested
    public class EqualsHashCode {

        @Test
        public void sameHash() {
            Box b1 = Box.cube(2);
            Box b2 = Box.cube(2);
            assertEquals(b1.hashCode(), b2.hashCode());
        }

        @Test
        public void differentHash() {
            Box b1 = Box.cube(2);
            Box b2 = Box.cube(3);
            assertNotEquals(b1.hashCode(), b2.hashCode());
        }

        @Test
        public void sameValues() {
            Box b1 = Box.cube(2);
            Box b2 = Box.cube(2);
            assertEquals(b1, b2);
        }

        @Test
        public void sameObject() {
            Box b1 = Box.cube(2);
            assertEquals(b1, b1);
        }

        @Test
        public void fromNull() {
            Box b1 = Box.cube(2);
            assertFalse(b1.equals(null));
        }

        @Test
        public void fromOtherType() {
            Box b1 = Box.cube(2);
            assertFalse(b1.equals(2));
        }

        @Test
        public void differentValues() {
            Box b1 = Box.cube(2);
            assertFalse(b1.equals(Box.cube(3)));
        }
    }

}
