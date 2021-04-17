package com.example.designprinciple.lsp.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Rectangle implements Quadrangle {
    private long height;
    private long width;

    @Override
    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    @Override
    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }
}
