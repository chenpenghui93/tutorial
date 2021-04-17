package com.example.designprinciple.lsp.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Square implements Quadrangle {
    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getWidth() {
        return 0;
    }

    @Override
    public long getHeight() {
        return 0;
    }
}
