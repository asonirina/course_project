package by.bsu.project.general.view;

import by.bsu.project.general.model.AttributeCounting;

/**
 * Created by iason
 * on 11/16/2015.
 */
public class ACInfo {
    String name = "";
    public ACInfo(AttributeCounting ac) {
        this.name = ac.getEntity().getUser().getSecondName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
