package org.fcyt;

import org.fcyt.view.GUIPrincipal;

public class Main {
    public static void main(String[] args) {
        GUIPrincipal view = new GUIPrincipal();
        view.setLocationRelativeTo(view);
        view.setVisible(true);
    }
}