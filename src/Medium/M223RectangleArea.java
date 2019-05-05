package Medium;

public class M223RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = 0;
        int height = 0;
        // consider height
        if (A < E) {
            if ( E >= C) {
                height = 0;
            } else {
                if ( G < C) {
                    height = G - E;
                } else {
                    height = C - E;
                }
            }
        } else {
            if(A >= G) {
                height = 0;
            } else {
                if (C < G) {
                    height = C - A;
                } else {
                    height = G - A;
                }
            }
        }

        // consider widht;
        if (B < F) {
            if (F > D) {
                width = 0;
            } else {
                if (H < D) {
                    width = H - F;
                } else {
                    width = D - F;
                }
            }
        } else {
            if (B > H) {
                width = 0;
            } else {
                if (D < H) {
                    width = D - B;
                } else {
                    width = H - B;
                }
            }
        }

        return ((D-B) * (C-A) + (G-E) * (H-F) -width * height);
    }
}
