package com.example.designprinciple.lsp.before;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Test {
    public static void resize(Rectangle rectangle) {
        //长方形的宽应该大于等于高，让高自增，直到高等于宽，称为正方形
        while (rectangle.getWidth() >= rectangle.getHeight()) {
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("width: " + rectangle.getWidth() + " " + "height: " + rectangle.getHeight());
        }
        System.out.println("resize()结束" +
                "\nwidth： " + rectangle.getWidth() + " " + "height: " + rectangle.getHeight());
    }

    public static void main(String[] args) {
        //可以看到输出中最后，width<height，不正常
//        Rectangle rectangle = new Rectangle();
//        rectangle.setWidth(20);
//        rectangle.setHeight(15);
//        resize(rectangle);

        Square square = new Square();
        square.setLength(10);
        resize(square);
    }


}
