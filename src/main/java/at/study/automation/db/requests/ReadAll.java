package at.study.automation.db.requests;

import java.util.List;

import at.study.automation.model.Entity;

public interface ReadAll<T extends Entity> {

    List<T> readAll();

}
