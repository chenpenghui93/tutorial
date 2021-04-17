package com.example.designpattern.composite.general.transparent;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public class Test {
    public static void main(String[] args) {
        Component root = new Composite("root");

        Component branchA = new Composite("---branch A");
        Component branchB = new Composite("------branch B");

        Component leafA = new Composite("------leaf A");
        Component leafB = new Composite("---------leaf B");
        Component leafC = new Composite("------leaf C");

        root.addChild(branchA);
        root.addChild(leafC);
        branchA.addChild(leafA);
        branchA.addChild(branchB);
        branchB.addChild(leafB);

        System.out.println(root.operation());
    }
}
