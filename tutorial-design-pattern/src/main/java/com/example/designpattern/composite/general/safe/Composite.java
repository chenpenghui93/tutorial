package com.example.designpattern.composite.general.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 *
 * @author chenpenghui
 * @date 2021-3-28
 */
public class Composite extends Component {

    private List<Component> components;

    public Composite(String name) {
        super(name);
        this.components = new ArrayList<>();
    }

    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder(this.name);
        for (Component component : this.components) {
            builder.append("\n");
            builder.append(component.operation());
        }
        return builder.toString();
    }

    public boolean addChild(Component component) {
        return this.components.add(component);
    }

    public boolean removeChild(Component component) {
        return this.components.remove(component);
    }

    public Component getChild(int index) {
        return this.components.get(index);
    }
}
