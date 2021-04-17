package com.example.designpattern.composite.general.transparent;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public String operation() {
        return this.name;
    }
}
