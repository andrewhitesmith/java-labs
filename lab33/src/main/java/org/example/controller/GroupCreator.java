package org.example.controller;

import org.example.model.Group;
import org.example.model.Human;

public class GroupCreator {
    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}
